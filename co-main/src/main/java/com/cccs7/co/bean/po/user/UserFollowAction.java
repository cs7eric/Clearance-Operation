package com.cccs7.co.bean.po.user;

import lombok.Data;

import java.util.Date;

/**
 * <p> 用户关注 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户关注
 * @Date 2024/4/9 8:59
 */
@Data
public class UserFollowAction {

    private String id;

    private Long userId;

    private Long followId;

    private Integer isFollowed;

    private Date createTime;

    private Date updateTime;
}
