package com.cccs7.web.exception;

/**
 * <p> 用户异常类 - 用户id不存在 </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 用户Id不存在
 * @Date: 2023/10/13 14:38
 */
public class UserIdNotExistException extends BaseException{

    public UserIdNotExistException(String msg) {
        super(msg);
    }

    public UserIdNotExistException() {
    }
}
