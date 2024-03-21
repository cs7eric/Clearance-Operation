package com.cccs7.co.strategy.impl;

import com.cccs7.co.enums.LabelType;
import com.cccs7.co.enums.OperationType;
import com.cccs7.co.service.LabelOperationService;
import com.cccs7.co.strategy.LabelOperationStrategy;

/**
 * <p> 分类创建策略 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 分类创建策略
 * @Date 2024/3/21 23:04
 */
public class CategoryCreateStrategy implements LabelOperationStrategy {
    @Override
    public <T> T execute(LabelOperationService<T> operationService) {
        return null;
    }

    @Override
    public String getIdentifier() {
        return LabelType.CATEGORY + "_" + OperationType.CREATE;
    }
}
