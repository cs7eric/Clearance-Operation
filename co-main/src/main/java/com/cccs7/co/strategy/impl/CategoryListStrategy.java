package com.cccs7.co.strategy.impl;

import com.cccs7.co.enums.LabelType;
import com.cccs7.co.enums.OperationType;
import com.cccs7.co.service.LabelOperationService;
import com.cccs7.co.strategy.LabelOperationStrategy;

/**
 * <p> 分类列表策略 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 分类列表策略
 * @Date 2024/3/21 22:51
 */
public class CategoryListStrategy implements LabelOperationStrategy {

    @Override
    public <T> T execute(LabelOperationService<T> operationService) {
        return null;
    }

    @Override
    public String getIdentifier() {
        String identifier = LabelType.CATEGORY.toString() + "_" + OperationType.LIST;
        return identifier;
    }
}
