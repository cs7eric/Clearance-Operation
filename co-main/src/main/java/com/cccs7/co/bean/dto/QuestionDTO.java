package com.cccs7.co.bean.dto;

import lombok.Data;

import java.util.List;

/**
 * <p> 问题dto </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 问题dto
 * @Date 2024/3/18 10:55
 */
@Data
public class QuestionDTO {

    private Long id; // 对于更新操作，需要题目ID
    private String title;
    private String content;
    private String questionType;
    private String difficulty;
    private List<OptionDTO> options;
}
