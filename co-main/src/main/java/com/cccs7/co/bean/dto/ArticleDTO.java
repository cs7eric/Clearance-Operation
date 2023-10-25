package com.cccs7.co.bean.dto;

import com.cccs7.mybatisplus.entity.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <p> 文章数据传输对象 - DTO </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 文章数据传输对象 - DTO
 * @Date 2023/10/13 23:13
 */
@Data
public class ArticleDTO extends BaseEntity {

    private String id;
    private String content;
    private String title;
    private Date publishTime;
    private String author;
    private Long authorId;
    private Integer likes;
    private Integer replyNum;
    private String category;
    private List<String> tags;
    private String status;
    private String cover;
    private String issueId;
    private String articleType;
}
