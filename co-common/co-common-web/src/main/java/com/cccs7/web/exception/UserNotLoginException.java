package com.cccs7.web.exception;

/**
 * <p> 用户异常类 - 用户未登录异常 </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 用户未登录异常
 * @Date: 2023/10/13 12:45
 */
public class UserNotLoginException extends BaseException{

    public UserNotLoginException() {
    }

    public UserNotLoginException(String msg) {
        super(msg);
    }
}
