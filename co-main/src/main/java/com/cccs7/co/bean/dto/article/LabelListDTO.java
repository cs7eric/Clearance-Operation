package com.cccs7.co.bean.dto.article;

import lombok.Data;

import java.util.List;

/**
 * <p> label集合dto </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description label集合dto
 * @Date 2024/3/26 9:09
 */

@Data
public class LabelListDTO {


    private String labelType;

    private List labelList;
}
