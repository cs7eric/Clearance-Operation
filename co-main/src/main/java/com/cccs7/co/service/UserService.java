package com.cccs7.co.service;

import com.cccs7.co.bean.entity.User;
import com.cccs7.web.bean.Result;

/**
 * <p> User服务接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description User服务接口
 * @Date 2023/9/15 23:15
 */
public interface UserService {
    /**
     * 登录
     *
     * @param user 用户
     * @return {@link Result}
     */
    Result login(User user);
}
