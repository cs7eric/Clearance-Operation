package com.cccs7.co.service.strategies;

import com.cccs7.co.bean.dto.user.UserActionDTO;
import com.cccs7.redis.util.RedisCache;

/**
 * <p> 用户行为策略接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户行为策略接口
 * @Date 2023/10/25 23:21
 */
public interface UserActionStrategy {
    /**
     * 执行对应的行为
     *
     * @param userActionDTO 用户行动Dto
     * @param redisCache    redis缓存
     */
    void execute(UserActionDTO userActionDTO, RedisCache redisCache);
}
