package com.cccs7.co.bean.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * <p> 文章实体类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 文章实体类
 * @Date 2023/10/9 10:33
 */
@Data
@Document(collection = "articles")
public class Article {

    @Id
    private String id;

    @Field("content")
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
}
