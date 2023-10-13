package com.cccs7.web.exception;

import com.cccs7.web.bean.Result;
import lombok.NoArgsConstructor;

/**
 * 登录异常类
 * 登录异常类
 * @author 16628
 * @date 2023/10/11
 */
public class LoginFailedException extends BaseException {

    public LoginFailedException(String msg) {
        super(msg);
    }

    public LoginFailedException() {
    }


}
