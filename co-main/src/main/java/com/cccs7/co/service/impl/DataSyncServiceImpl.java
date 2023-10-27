package com.cccs7.co.service.impl;

import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.cccs7.co.bean.po.UserArticleAction;
import com.cccs7.co.config.RedisKey;
import com.cccs7.co.mapper.ArticleActionMapper;
import com.cccs7.co.mapper.UserMapper;
import com.cccs7.co.service.DataSyncService;
import com.cccs7.redis.util.RedisCache;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p> 数据同步服务接口实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 数据同步服务接口实现类
 * @Date 2023/10/26 23:36
 */
@Service
public class DataSyncServiceImpl implements DataSyncService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleActionMapper articleActionMapper;

    @Scheduled(fixedRate = 100 * 60 * 60 * 2)
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


                    System.out.println(parts[0]);
                    if (RedisKey.USER_LIKES_PREFIX.equals(parts[0] + ":")) {
                        UserArticleAction userArticleAction = new UserArticleAction();

                        userArticleAction.setUserId(userId);
                        userArticleAction.setArticleId(value);
                        userArticleAction.setIsLiked(true);
                        articleActions.add(userArticleAction);
                    }
                    if (RedisKey.USER_COLLECTS_PREFIX.equals(parts[0] + ":")) {
                        UserArticleAction userArticleAction = new UserArticleAction();

                        userArticleAction.setUserId(userId);
                        userArticleAction.setArticleId(value);
                        userArticleAction.setIsCollected(true);
                        articleActions.add(userArticleAction);
                    }

                });
        int i = articleActionMapper.insertBatchSomeColumn(articleActions);



    }
}
