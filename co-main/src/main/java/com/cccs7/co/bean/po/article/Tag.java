package com.cccs7.co.bean.po.article;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p> 标签 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 标签
 * @Date 2024/1/21 21:54
 */

@Data
@TableName("sys_tag")
public class Tag {

    @TableId
    private Long id;

    private String tagName;

    private String tagType;
}
