package com.cccs7.co.bean.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * (CoUser)表实体类
 *
 * @author makejava
 * @since 2023-09-11 16:14:11
 */

@Data
@TableName(value = "sys_user")
public class User  {

    @TableId
    private Long id;

    private String userName;

    private String nickName;

    private String password;

    private String email;

    private String phonenumber;

    private String sex;

    private String avatar;

    private String userType;

}


