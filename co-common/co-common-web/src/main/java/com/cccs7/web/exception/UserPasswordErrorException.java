package com.cccs7.web.exception;

/**
 * <p> 用户异常类 - 用户密码不存在 </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 用户密码错误异常
 * @Date: 2023/10/13 12:32
 */
public class UserPasswordErrorException extends BaseException{

    public UserPasswordErrorException() {
    }

    public UserPasswordErrorException(String msg) {
        super(msg);
    }
}
