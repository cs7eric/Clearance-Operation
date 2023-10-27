package com.cccs7.co.factory;

import com.cccs7.co.enums.UserActionType;
import com.cccs7.co.service.strategies.CollectActionStrategy;
import com.cccs7.co.service.strategies.LikeActionStrategy;
import com.cccs7.co.service.strategies.UserActionStrategy;
import com.cccs7.redis.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> 用户行为策略工厂类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户行为策略工厂类
 * @Date 2023/10/25 23:22
 */
@Component
public class UserActionFactory {

    @Autowired
    private RedisCache redisCache;

    private static final Map<UserActionType, UserActionStrategy> strategies = new HashMap<>();

    static {
        strategies.put(UserActionType.LIKE, new LikeActionStrategy());
        strategies.put(UserActionType.COLLECT, new CollectActionStrategy());
    }

    public static UserActionStrategy getStrategy(UserActionType actionType) {
        return strategies.get(actionType);
    }
}
