package com.cccs7.co.service.impl;

import com.cccs7.co.bean.po.user.User;
import com.cccs7.co.bean.po.user.UserArticleAction;
import com.cccs7.co.config.RedisKey;
import com.cccs7.co.id.UuidUtils;
import com.cccs7.co.mapper.ArticleActionMapper;
import com.cccs7.co.service.DataSyncService;
import com.cccs7.co.service.UserService;
import com.cccs7.redis.util.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p> 数据同步服务接口实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 数据同步服务接口实现类
 * @Date 2023/10/26 23:36
 */
@Slf4j
@Service
public class DataSyncServiceImpl implements DataSyncService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ArticleActionMapper articleActionMapper;

    public void syncDataToMysql() {
        String likesPrefix = RedisKey.USER_LIKES_PREFIX;
        Set<String> set = redisCache.getKeysWithPrefix(likesPrefix);

        Map<String, String> resultMap = set.stream()
                .collect(Collectors.toMap(
                        key -> key,
                        key -> redisCache.getCacheObject(key)
                ));


        List<UserArticleAction> articleActions = new ArrayList<>();
        resultMap.forEach(
                (key, value) -> {
                    System.out.println(key + "->" + value);
                    String[] parts = key.split(":");
                    String userIdStr = parts[1];
                    Long userId = Long.parseLong(userIdStr);
                    User user = userService.getById(userId);
                    String username = user.getUsername();

                    System.out.println(parts[0]);
                    if (RedisKey.USER_LIKES_PREFIX.equals(parts[0] + ":")) {
                        UserArticleAction userArticleAction = new UserArticleAction();

                        userArticleAction.setUserId(userId);
                        userArticleAction.setArticleId(value);
                        userArticleAction.setCreateBy(userIdStr);
                        userArticleAction.setCreateTime(new Date());
                        userArticleAction.setIsLiked(true);
                        userArticleAction.setDelFlag(0);
                        userArticleAction.setUsername(username);
                        articleActions.add(userArticleAction);
                    }
                    if (RedisKey.USER_COLLECTS_PREFIX.equals(parts[0] + ":")) {
                        UserArticleAction userArticleAction = new UserArticleAction();

                        userArticleAction.setUserId(userId);
                        userArticleAction.setCreateBy(userIdStr);
                        userArticleAction.setCreateTime(new Date());
                        userArticleAction.setDelFlag(0);
                        userArticleAction.setArticleId(value);
                        userArticleAction.setIsCollected(true);
                        userArticleAction.setUsername(username);

                        articleActions.add(userArticleAction);
                    }

                });
        int i = articleActionMapper.insertBatchSomeColumn(articleActions);
    }

    @Override
    @Scheduled(cron = "0 0 */2 * * *")
    public void dsyncData() {
        String prefix = RedisKey.USER_PREFIX;
        Set<String> keySet = redisCache.getKeysWithPrefix(prefix);
        HashMap<String, Set<String>> actionMap = new HashMap<>();

        keySet.forEach(item -> {
            Set<String> articleSet = redisCache.getCacheSet(item);
            actionMap.put(item, articleSet);
        });

        HashMap<Long, Set<String>> likeMap = new HashMap<>();
        HashMap<Long, Set<String>> collectMap = new HashMap<>();

        actionMap.forEach(
                (key, value) -> {
                    System.out.println(key + "->" + value);
                    String[] actionKey = key.split(":");
                    String actionType = actionKey[0] + ":";
                    Long userId = Long.parseLong(actionKey[1]);
                    if (actionType.equalsIgnoreCase(RedisKey.USER_LIKES_PREFIX)) {
                        likeMap.put(userId, value);
                    } else {
                        collectMap.put(userId, value);
                    }
                }
        );

        List<UserArticleAction> likeList = classifyData(RedisKey.USER_LIKES_PREFIX, likeMap);
        List<UserArticleAction> collectList = classifyData(RedisKey.USER_COLLECTS_PREFIX, collectMap);


        if (!CollectionUtils.isEmpty(likeList)) {
            articleActionMapper.batchInsertOrUpdate(likeList);
        }
        if (!CollectionUtils.isEmpty(collectList)) {
            articleActionMapper.batchInsertOrUpdate(collectList);
        }

        redisCache.deleteKeysWithPrefix(RedisKey.USER_PREFIX);
    }


    /**
     * 分类数据
     *
     * @param dataMap    数据
     * @param actionType 动作类型
     * @return {@link List}<{@link UserArticleAction}>
     */
    public List<UserArticleAction> classifyData(String actionType, Map<Long, Set<String>> dataMap) {

        List<UserArticleAction> actionList = new ArrayList<>();
        dataMap.forEach(
                (key, value) -> {
                    log.info("key:{} -> value:{}", key, value);
                    value.forEach(item -> {
                        UserArticleAction articleAction = new UserArticleAction();
                        articleAction.setId(UuidUtils.getUuid());
                        articleAction.setUserId(key);
                        articleAction.setArticleId(item);
                        articleAction.setCreateTime(new Date());
                        articleAction.setDelFlag(0);
                        articleAction.setCreateBy(key.toString());
                        if (actionType.equalsIgnoreCase(RedisKey.USER_LIKES_PREFIX)) {
                            articleAction.setIsLiked(true);
                        } else {
                            articleAction.setIsCollected(true);
                        }
                        actionList.add(articleAction);
                    });
                }
        );


        return actionList;
    }
}
