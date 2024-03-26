package com.cccs7.co.convert;

import com.cccs7.co.bean.dto.article.LabelDTO;
import com.cccs7.co.bean.po.article.Category;
import com.cccs7.co.bean.po.article.Tag;
import org.mapstruct.factory.Mappers;

/**
 * <p> label 转换器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description label 转换器
 * @Date 2024/3/26 10:51
 */
public interface LabelConverter {

    LabelConverter INSTANCE = Mappers.getMapper(LabelConverter.class);

    /**
     * labelToTag
     *
     * @param labelDTO 标签Dto
     * @return {@link Tag}
     */
    Tag label2tag(LabelDTO labelDTO);

    /**
     * labelToCategory
     *
     * @param labelDTO 标签Dto
     * @return {@link Category}
     */
    Category label2category(LabelDTO labelDTO);
}
