package com.cccs7.co.bean.dto.article;

import lombok.Data;

import java.util.List;

/**
 * <p> 传递请求分页文章列表的参数 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 传递请求分页文章列表的参数
 * @Date 2023/10/13 23:15
 */
@Data
public class ArticleListDTO {
    private Integer page;
    private Integer size;
    private String sortBy;
    private String sortOrder;
    private String category;
    private Long authorId;
    private List<String> tags;
}
