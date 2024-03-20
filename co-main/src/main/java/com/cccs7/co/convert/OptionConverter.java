package com.cccs7.co.convert;

import com.cccs7.co.bean.dto.OptionDTO;
import com.cccs7.co.bean.po.Option;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p> option 转换器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description option 转换器
 * @Date 2024/3/19 10:11
 */
@Mapper
public interface OptionConverter {

    OptionConverter INSTANCE = Mappers.getMapper(OptionConverter.class);

    /**
     * dto2po
     *
     * @param optionDTO 选项Dto
     * @return {@link Option}
     */
    Option dto2po(OptionDTO optionDTO);


    /**
     * po2dto
     *
     * @param option 选项
     * @return {@link OptionDTO}
     */
    OptionDTO po2dto(Option option);
}
