package com.cccs7.co.controller;

import com.cccs7.co.bean.entity.User;
import com.cccs7.co.service.UserService;
import com.cccs7.web.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> 用户控制层 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户控制层
 * @Date 2023/9/17 21:56
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册  - 普通用户注册
     *
     * @param user 用户
     * @return {@link Result}<{@link String}>
     */
    @PostMapping("/register")
    public Result<String> register(@RequestBody User user){

        userService.register(user);
        return Result.ok("注册成功");
    }

    @PostMapping("/login")
    public Result login (@RequestBody User user) {
        return userService.login(user);
    }
}
