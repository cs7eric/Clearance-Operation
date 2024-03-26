package com.cccs7.co.strategy.impl;

import com.cccs7.co.bean.po.article.Category;
import com.cccs7.co.bean.po.article.Tag;
import com.cccs7.co.enums.LabelType;
import com.cccs7.co.enums.OperationType;
import com.cccs7.co.service.LabelOperationService;
import com.cccs7.co.service.impl.CategoryServiceImpl;
import com.cccs7.co.service.impl.TagServiceImpl;
import com.cccs7.co.strategy.LabelOperationStrategy;

import java.util.List;
import java.util.Map;

/**
 * <p> 分类列表策略 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 分类列表策略
 * @Date 2024/3/21 22:51
 */
public class CategoryListStrategy implements LabelOperationStrategy {

    @Override
    public <T> T execute(LabelOperationService<T> operationService, Map<String,Object> dataMap) {
        CategoryServiceImpl categoryService = (CategoryServiceImpl) operationService;
        List<Category> categoryList = categoryService.list();
        categoryList.forEach(System.out::println);
        return (T) categoryList;
    }

    @Override
    public String getIdentifier() {
        String identifier = LabelType.CATEGORY.toString() + "_" + OperationType.LIST;
        return identifier;
    }
}
