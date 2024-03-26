package com.cccs7.co.bean.po.article;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cccs7.mybatisplus.entity.BaseEntity;
import lombok.Data;

/**
 * <p> 分类实体类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 分类实体类
 * @Date 2024/3/14 23:34
 */

@Data
@TableName("sys_category")
public class Category {

    @TableId
    private Long id;

    private String categoryName;

    private String categoryType;
}
