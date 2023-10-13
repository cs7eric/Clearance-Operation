package com.cccs7.web.exception;

/**
 * <p> 用户类异常 - 用户已存在 </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 用户已存在异常
 * @Date: 2023/10/13 15:42
 */
public class UserAlreadyExistException extends BaseException{

    public UserAlreadyExistException(String msg) {
        super(msg);
    }

    public UserAlreadyExistException() {
    }
}
