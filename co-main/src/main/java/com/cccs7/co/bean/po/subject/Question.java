package com.cccs7.co.bean.po.subject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 题目实体类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 题目实体类
 * @Date 2024/3/18 10:49
 */
@Data
@TableName("sub_questions")
public class Question {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String title;
    private String content;

    private List<Option> options = new ArrayList<>();


}
