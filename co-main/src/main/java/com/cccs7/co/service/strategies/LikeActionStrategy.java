package com.cccs7.co.service.strategies;

import com.cccs7.co.bean.dto.user.UserActionDTO;
import com.cccs7.co.config.RedisKey;
import com.cccs7.redis.util.RedisCache;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * <p> 点赞行为 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 点赞行为
 * @Date 2023/10/25 23:28
 */
@Slf4j
public class LikeActionStrategy implements UserActionStrategy{

    @Override
    public void execute(UserActionDTO userActionDTO, RedisCache redisCache) {
        Long userId = userActionDTO.getUserId();
        String articleId = userActionDTO.getArticleId();
        String likeKey = RedisKey.USER_LIKES_PREFIX + userId;
        log.info("点赞行为策略执行");
        Set<Object> likeSet = redisCache.getCacheSet(likeKey);
        if (likeSet.isEmpty()) {
            HashSet<String> articleSet = new HashSet<>();
            articleSet.add(articleId);
            redisCache.setCacheSet(RedisKey.USER_LIKES_PREFIX + userId, articleSet);
        }
        redisCache.addElementToSet(likeKey, articleId);


    }
}
