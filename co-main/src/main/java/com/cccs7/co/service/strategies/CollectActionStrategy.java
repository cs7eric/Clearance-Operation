package com.cccs7.co.service.strategies;

import com.cccs7.co.bean.dto.UserActionDTO;
import com.cccs7.co.config.RedisKey;
import com.cccs7.redis.util.RedisCache;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

/**
 * <p> 收藏行为策略 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 收藏行为策略
 * @Date 2023/10/25 23:29
 */
@Slf4j
public class CollectActionStrategy implements UserActionStrategy {

    @Override
    public void execute(UserActionDTO userActionDTO, RedisCache redisCache) {
        Long userId = userActionDTO.getUserId();
        String articleId = userActionDTO.getArticleId();
        log.info("收藏行为策略执行");

        HashSet<String> articleSet = new HashSet<>();
        articleSet.add(articleId);
        redisCache.setCacheSet(RedisKey.USER_COLLECTS_PREFIX + userId, articleSet);
    }
}
