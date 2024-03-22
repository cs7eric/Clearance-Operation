package com.cccs7.co.strategy.impl;

import com.cccs7.co.bean.po.article.Tag;
import com.cccs7.co.enums.LabelType;
import com.cccs7.co.enums.OperationType;
import com.cccs7.co.service.LabelOperationService;
import com.cccs7.co.service.impl.TagServiceImpl;
import com.cccs7.co.strategy.LabelOperationStrategy;

import java.util.List;

/**
 * <p> 标签列表策略 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 标签列表策略
 * @Date 2024/3/21 23:01
 */
public class TagListStrategy implements LabelOperationStrategy {

    @Override
    public <T> T execute(LabelOperationService<T> operationService) {

        TagServiceImpl tagService = (TagServiceImpl) operationService;
        List<Tag> tagList = tagService.list();
        tagList.forEach(System.out::println);
        return (T) tagList;
    }

    @Override
    public String getIdentifier() {
        return LabelType.TAG + "_" + OperationType.LIST;
    }
}
