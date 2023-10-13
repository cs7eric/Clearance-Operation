package com.cccs7.co.service;

import com.cccs7.co.bean.dto.UserDTO;
import com.cccs7.co.bean.po.User;
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
     * @param userDTO 用户
     * @return {@link Result}
     */
    Result login(UserDTO userDTO);

    /**
     * 注册
     *
     * @param userDTO 用户
     * @return {@link Result}
     */
    Result register(UserDTO userDTO);

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
     * @param userDTO 用户
     * @return {@link Result}
     */
    Result verify(UserDTO userDTO);

    /**
     * 判断用户是否存在
     *
     * @param userDTO 用户
     * @return {@link Boolean}
     */
    Boolean exist(UserDTO userDTO);
}
