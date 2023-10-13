package com.cccs7.web.exception;

/**
 * <p> 举报失败异常 </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 举报失败异常
 * @Date: 2023/10/13 16:20
 */
public class ReportFailedException extends BaseException{

    public ReportFailedException() {
    }

    public ReportFailedException(String msg) {
        super(msg);
    }
}
