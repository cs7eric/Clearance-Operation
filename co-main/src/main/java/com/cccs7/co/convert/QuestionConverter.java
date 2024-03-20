package com.cccs7.co.convert;

import com.cccs7.co.bean.dto.subject.QuestionDTO;
import com.cccs7.co.bean.po.subject.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p> quest实体转换器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description quest实体转换器
 * @Date 2024/3/19 8:44
 */

@Mapper
public interface QuestionConverter {

    QuestionConverter INSTANCE = Mappers.getMapper(QuestionConverter.class);

    /**
     * 将 QuestionDTO 转换为 Question
     *
     * @param questionDTO 问题Dto
     * @return {@link Question}
     */
    Question dto2po(QuestionDTO questionDTO);

    /**
     * 将 Question 转换为 QuestionDTO
     *
     * @param question 问题
     * @return {@link QuestionDTO}
     */
    QuestionDTO po2dto(Question question);





}
