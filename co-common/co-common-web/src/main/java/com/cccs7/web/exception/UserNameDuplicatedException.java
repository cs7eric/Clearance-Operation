package com.cccs7.web.exception;

/**
 * <p> 用户异常类 - 用户名重复异常 </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 用户名重复异常
 * @Date: 2023/10/13 12:44
 */
public class UserNameDuplicatedException extends BaseException{

    public UserNameDuplicatedException() {
    }

    public UserNameDuplicatedException(String msg) {
        super(msg);
    }
}
