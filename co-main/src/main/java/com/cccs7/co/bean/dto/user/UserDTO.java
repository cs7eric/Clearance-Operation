package com.cccs7.co.bean.dto.user;

import com.cccs7.mybatisplus.entity.BaseEntity;
import lombok.Data;

/**
 * <p> UserReq </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description UserReq
 * @Date 2023/9/30 23:58
 */
@Data
public class UserDTO {

    private Long id;

    private String username;

    private String nickName;

    private String password;

    private String email;

    private String phonenumber;

    private String sex;

    private String avatar;

    private String userType;

    private String code;

}

