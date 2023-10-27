package com.cccs7.co.service.impl;

import com.cccs7.co.bean.dto.UserActionDTO;
import com.cccs7.co.bean.po.UserArticleAction;
import com.cccs7.co.enums.UserActionType;
import com.cccs7.co.factory.UserActionFactory;
import com.cccs7.co.service.UserActionService;
import com.cccs7.co.service.strategies.UserActionStrategy;
import com.cccs7.redis.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> 用户行为接口实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户行为接口实现类
 * @Date 2023/10/25 23:57
 */
@Service
public class UserActionServiceImpl implements UserActionService {

    @Autowired
    private RedisCache redisCache;

    @Override
    public void doAction(UserActionDTO userActionDTO) {

        String actionType = userActionDTO.getUserActionType();
        UserActionType userActionType = UserActionType.valueOf(actionType.toUpperCase());
        UserActionStrategy actionStrategy = UserActionFactory.getStrategy(userActionType);
        actionStrategy.execute(userActionDTO, redisCache);
    }
}
