package com.cccs7.co.bean.dto.user;

import lombok.Data;

/**
 * <p> 用户关注DTO </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户关注DTO
 * @Date 2024/4/9 9:02
 */

@Data
public class UserFollowDTO {

    private Long userId;

    private Long followId;

    private Integer isFollowed;
}
