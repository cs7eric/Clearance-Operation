package com.cccs7.co.bean.po;

import lombok.Data;

/**
 * <p> 分类实体类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 分类实体类
 * @Date 2024/3/14 23:34
 */

@Data
public class Category {


    private Long categoryId;

    private String categoryName;

    private String categoryType;
}
