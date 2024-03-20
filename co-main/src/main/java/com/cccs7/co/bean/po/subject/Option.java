package com.cccs7.co.bean.po.subject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.data.annotation.Id;

/**
 * <p> 题目选项实体类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 题目选项实体类
 * @Date 2024/3/18 10:51
 */
@Data
@TableName("sub_options")
public class Option {

    @Id
    private Long id;

    private Long questionId;

    private String optionContent;
    private Boolean isCorrect;

}
