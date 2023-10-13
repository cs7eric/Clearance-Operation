package com.cccs7.web.exception;

/**
 * <p> 非法字符异常 </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 非法字符异常
 * @Date: 2023/10/13 13:19
 */
public class InvaildSymbolException extends BaseException{

    public InvaildSymbolException(String msg) {
        super(msg);
    }

    public InvaildSymbolException() {
    }
}
