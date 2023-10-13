package com.cccs7.web.exception;

/**
 * 文件异常类 - 文件上传失败异常
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 文件上传失败
 * @Date: 2023/10/13 12:48
 */
public class FileUploadFailedException extends BaseException {

    public FileUploadFailedException(String msg) {
        super(msg);
    }

    public FileUploadFailedException() {
    }
}
