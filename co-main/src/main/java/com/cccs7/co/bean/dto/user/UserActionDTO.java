package com.cccs7.co.bean.dto.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private Long userId;

    private String username;

    private String articleId;

    private String userActionType;
}
