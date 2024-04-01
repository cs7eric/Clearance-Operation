package com.cccs7.co.bean.dto.subject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * <p> 用户答案提交DTO </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户答案提交DTO
 * @Date 2024/3/18 10:58
 */
@Data
public class AnswerSubmissionDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    private Long questionId;
    private List<Long> selectedOptionIds;
}
