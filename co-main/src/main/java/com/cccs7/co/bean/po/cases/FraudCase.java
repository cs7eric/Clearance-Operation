package com.cccs7.co.bean.po.cases;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cccs7.mybatisplus.entity.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p> 诈骗案例DTO</p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 诈骗案例DTO
 * @Date 2024/3/26 22:19
 */

@Data
@TableName("case_fraud")
public class FraudCase {

    @TableId(value = "id", type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;

    @TableField("title")
    private String title;

    @TableField("description")
    private String description;

    @TableField("type")
    private String type;

    @TableField("date")
    private Date date;

    @TableField("amount")
    private BigDecimal amount;

    @TableField("victim_age_range")
    private String victimAgeRange;

    @TableField("region")
    private String region;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("del_flag")
    private Integer delFlag;

    @TableField("additional_info")
    private String additionalInfo;
}
