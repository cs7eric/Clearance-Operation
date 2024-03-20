package com.cccs7.co.bean.dto.user;

import lombok.Data;

/**
 * <p> 用户行为DTO </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户行为DTO
 * @Date 2023/10/26 15:11
 */
@Data
public class UserActionDTO {
    private Long id;

    private Long userId;

    private String articleId;

    private String userActionType;
}
