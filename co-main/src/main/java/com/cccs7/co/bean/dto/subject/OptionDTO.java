package com.cccs7.co.bean.dto.subject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String optionContent;
    private Boolean isCorrect;
}
