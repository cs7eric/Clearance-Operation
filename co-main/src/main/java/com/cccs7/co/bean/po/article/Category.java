package com.cccs7.co.bean.po.article;

import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId
    private Long id;

    private String categoryName;

    private String categoryType;
}
