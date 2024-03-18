package com.cccs7.co.bean.dto;

import lombok.Data;

/**
 * <p> 选项DTO </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 选项DTO
 * @Date 2024/3/18 10:57
 */
@Data
public class OptionDTO {

    private Long id;
    private String optionContent;
    private Boolean isCorrect;
}
