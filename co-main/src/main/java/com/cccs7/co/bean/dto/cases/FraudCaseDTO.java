package com.cccs7.co.bean.dto.cases;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p> 诈骗案例实体类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 诈骗案例实体类
 * @Date 2024/3/26 22:19
 */
@Data
public class FraudCaseDTO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;
    private String title;
    private String description;
    private String type;
    private Date date;
    private BigDecimal amount;
    private String victimAgeRange;
    private String region;
    private Date createTime;
    private Date updateTime;
    private Integer delFlag;
    private String additionalInfo;
}
