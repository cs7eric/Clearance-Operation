package com.cccs7.co.service;

import com.cccs7.co.bean.po.User;
import com.cccs7.web.bean.Result;

/**
 * <p> LoginService - 登录服务接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description LoginService - 登录服务接口
 * @Date 2023/9/13 23:40
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param user 用户
     * @return {@link Result}
     */
    Result login(User user);
}
