package com.cccs7.web.exception;

/**
 * <p> 用户异常类 - 用户密码修改失败 </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 用户密码修改失败
 * @Date: 2023/10/13 12:41
 */
public class PasswordEditFailedException extends BaseException{

    public PasswordEditFailedException() {
    }

    public PasswordEditFailedException(String msg) {
        super(msg);
    }
}
