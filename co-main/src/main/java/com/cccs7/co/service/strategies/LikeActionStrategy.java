package com.cccs7.co.service.strategies;

import com.cccs7.co.bean.dto.UserActionDTO;
import com.cccs7.co.config.RedisKey;
import com.cccs7.redis.util.RedisCache;
import lombok.extern.slf4j.Slf4j;

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
        log.info("点赞行为策略执行");
        redisCache.setCacheObject(RedisKey.USER_LIKES_PREFIX + userId, articleId);
    }
}
