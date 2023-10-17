package com.cccs7.co.bean.dto;

import lombok.Data;

import java.util.Date;

/**
 * <p> 评论实体类数据传输对象 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 评论实体类数据传输对象
 * @Date 2023/10/13 23:38
 */
@Data
public class CommentDTO {

    private String id;

    private String articleId;

    private String content;

    private String userId;

    private String nickName;

    private Date createTime;

    private Integer likeNum;

    private String parentId;

    private String state;

    private String authorAvatar;

}
