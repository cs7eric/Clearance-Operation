package com.cccs7.web.exception;

/**
 * <p> 验证码异常类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 验证码异常类
 * @Date 2023/10/13 17:48
 */
public class CodeException extends BaseException{
    public CodeException(String msg) {
        super(msg);
    }

    public CodeException() {
        super();
    }
}
