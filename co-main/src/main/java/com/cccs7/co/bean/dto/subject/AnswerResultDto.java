package com.cccs7.co.bean.dto.subject;

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

    private Long questionId;
    private Boolean isCorrect;
}
