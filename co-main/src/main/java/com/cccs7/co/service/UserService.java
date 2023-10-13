package com.cccs7.co.service;

import com.cccs7.co.bean.entity.User;
import com.cccs7.co.bean.req.UserReq;
import com.cccs7.web.bean.Result;
import org.springframework.stereotype.Service;

/**
 * <p> User服务接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description User服务接口
 * @Date 2023/9/15 23:15
 */
@Service
public interface UserService {
    /**
     * 登录
     *
     * @param userReq 用户
     * @return {@link Result}
     */
    Result login(UserReq userReq);

    /**
     * 注册
     *
     * @param userReq 用户
     */
    Result register(UserReq userReq);

    /**
     * 更新用户信息
     *
     * @param user 用户
     */
    void update(User user);

    /**
     * 验证
     * 注册或登录
     *
     * @param userReq 用户
     * @return {@link Result}
     */
    Result verify(UserReq userReq);

    /**
     * 判断用户是否存在
     *
     * @param userReq 用户
     * @return {@link Boolean}
     */
    Boolean exist(UserReq userReq);
}
