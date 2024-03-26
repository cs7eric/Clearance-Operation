package com.cccs7.co.convert.impl;

import com.cccs7.co.bean.dto.article.LabelDTO;
import com.cccs7.co.bean.po.article.Category;
import com.cccs7.co.bean.po.article.Tag;
import com.cccs7.co.controller.LabelController;
import com.cccs7.co.convert.LabelConverter;

/**
 * <p> label 转换器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description label 转换器
 * @Date 2024/3/26 10:50
 */
public class LabelConverterImpl implements LabelConverter {

    @Override
    public Tag label2tag(LabelDTO labelDTO) {

        Tag tag = new Tag();
        tag.setTagName(labelDTO.getLabelName());
        tag.setTagType(labelDTO.getLabelType());
        return tag;
    }

    @Override
    public Category label2category(LabelDTO labelDTO) {

        Category category = new Category();
        category.setCategoryName(labelDTO.getLabelName());
        category.setCategoryName(labelDTO.getLabelType());
        return category;
    }
}
