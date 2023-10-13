package com.cccs7.co.bean.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * <p> 评论实体类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 评论实体类
 * @Date 2023/10/13 23:35
 */
@Data
@Document(collection = "comments")
public class Comment {

    /**
     * MongoDB  comments 主键id字段
     */
    @Id
    private String id;

    private String articleId;

    private String content;

    private String userId;

    private String nickname;

    private Date createTime;

    private Integer likeNum;

    private Integer replyNum;

    private String state;

    private String parentId;

}
