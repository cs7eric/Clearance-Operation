package com.cccs7.co.bean.po;

import com.baomidou.mybatisplus.annotation.TableName;
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

    private Long id;

    private String title;
    private String content;

    private List<Option> options = new ArrayList<>();


}
