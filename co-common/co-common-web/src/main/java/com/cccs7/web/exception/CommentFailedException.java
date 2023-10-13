package com.cccs7.web.exception;

/**
 * 评论失败异常
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 评论失败
 * @Date: 2023/10/13 15:50
 */
public class CommentFailedException extends BaseException{

    public CommentFailedException(String msg) {
        super(msg);
    }

    public CommentFailedException() {
    }
}
