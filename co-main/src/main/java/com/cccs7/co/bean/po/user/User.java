package com.cccs7.co.bean.po.user;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cccs7.mybatisplus.entity.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * (CoUser)表实体类
 *
 * @author makejava
 * @since 2023-09-11 16:14:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
public class User extends BaseEntity {

    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String username;

    private String nickName;

    private String password;

    private String email;

    private String phonenumber;

    private String sex;

    private String avatar;

    private String userType;

    private String introduction;

}



