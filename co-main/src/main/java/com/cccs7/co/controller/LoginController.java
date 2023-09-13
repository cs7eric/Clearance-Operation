package com.cccs7.co.controller;

import com.cccs7.co.bean.entity.CoUser;
import com.cccs7.co.service.LoginService;
import com.cccs7.web.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> LoginController - 登录控制器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description LoginController - 登录控制器
 * @Date 2023/9/13 23:38
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login (@RequestBody CoUser user) {
        return loginService.login(user);
    }
}
