package com.cccs7.co.bean.po.user;

import com.cccs7.mybatisplus.entity.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

/**
 * 用户文章操作
 * <p> 用户与文章之间的交互 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户与文章之间的交互
 * @Date 2023/10/25 22:20
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class UserArticleAction extends BaseEntity {

    @Id
    private String  id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String username;

    private String articleId;

    private Boolean isLiked;

    private Boolean isCollected;
}

