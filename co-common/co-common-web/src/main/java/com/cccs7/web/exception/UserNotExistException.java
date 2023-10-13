package com.cccs7.web.exception;

/**
 * <p> 用户异常类 - 用户不存在 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户异常类 - 用户不存在
 * @Date 2023/10/11 18:03
 */
public class UserNotExistException extends BaseException {

    public UserNotExistException() {
        super(ExceptionInfo.USER_NOT_EXIST);
    }

}

