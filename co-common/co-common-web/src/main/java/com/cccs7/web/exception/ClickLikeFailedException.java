package com.cccs7.web.exception;

/**
 * <p> 点赞失败异常 </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 点赞失败
 * @Date: 2023/10/13 15:52
 */
public class ClickLikeFailedException extends BaseException {

    public ClickLikeFailedException() {
    }

    public ClickLikeFailedException(String msg) {
        super(msg);
    }
}
