package com.cccs7.co.bean.dto.article;

import com.cccs7.mybatisplus.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p> Label DTO </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description Label DTO
 * @Date 2024/3/20 23:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LabelDTO extends BaseEntity {

    private String labelName;

    private String labelType;
}

