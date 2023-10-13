package com.cccs7.web.exception;

/**
 *
 * 文章发布失败异常
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 文章发布失败异常
 * @Date: 2023/10/13 16:25
 */
public class ArticlePublishFailedException extends BaseException{

    public ArticlePublishFailedException(String msg) {
        super(msg);
    }

    public ArticlePublishFailedException() {
    }
}
