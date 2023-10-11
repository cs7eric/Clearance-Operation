package com.cccs7.co.controller;

import com.cccs7.web.bean.Result;
import com.cccs7.web.exception.ExceptionInfo;
import com.cccs7.web.exception.LoginFailedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> 测试接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 测试接口
 * @Date 2023/9/10 22:39
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/boot")
    public String testBoot () {
        return "success";
    }

    @GetMapping("/exception")
    public String testException () {

        if (1 != 0) {
            throw new LoginFailedException();
        }
        return "ok";
    }
}
