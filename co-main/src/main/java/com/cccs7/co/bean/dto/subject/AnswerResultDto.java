package com.cccs7.co.bean.dto.subject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * <p> 答案校验DTO </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 答案校验DTO
 * @Date 2024/3/18 10:59
 */
@Data
public class AnswerResultDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long questionId;
    private Boolean isCorrect;
}
