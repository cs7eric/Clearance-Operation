package com.cccs7.web.exception;

/**
 * <p> 文章异常类 - 所查询的文章不存在 </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 所查询的文章不存在
 * @Date: 2023/10/13 12:47
 */
public class ArticleNotExistException extends BaseException{

    public ArticleNotExistException(String msg) {
        super(msg);
    }

    public ArticleNotExistException() {
    }
}
