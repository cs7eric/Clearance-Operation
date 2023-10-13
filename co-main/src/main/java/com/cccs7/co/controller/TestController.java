package com.cccs7.co.controller;

import com.cccs7.co.bean.po.User;
import com.cccs7.web.exception.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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
    public String testException (@RequestBody User user ) {

        if (Objects.isNull(user)) {
        }

        if (StringUtils.isNotBlank(user.getId().toString())) {
//            throw new BaseException(ExceptionInfo.USER_ID_NOT_EXIT);
            throw new UserBusinessException(ExceptionInfo.USER_ID_NOT_EXIST);
        }


        if (1 != 0) {
            throw new LoginFailedException();
        }


        System.out.println();

        return "ok";
    }
}
