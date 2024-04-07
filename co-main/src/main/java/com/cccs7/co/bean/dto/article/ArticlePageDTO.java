package com.cccs7.co.bean.dto.article;

import com.cccs7.co.bean.dto.common.PageRequestDTO;
import com.cccs7.co.bean.po.article.Article;
import lombok.Data;

import java.util.List;

/**
 * <p> 文章分页DTO </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 文章分页DTO
 * @Date 2024/3/31 21:57
 */
@Data
public class ArticlePageDTO extends PageRequestDTO {

    private String username;

    private List<Article> data;

    private Long total;

    private String actionType;
}
