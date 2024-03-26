package com.cccs7.co.strategy.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccs7.co.bean.po.article.Category;
import com.cccs7.co.bean.po.article.Tag;
import com.cccs7.co.convert.LabelConverter;
import com.cccs7.co.enums.LabelType;
import com.cccs7.co.enums.OperationType;
import com.cccs7.co.service.LabelOperationService;
import com.cccs7.co.service.impl.CategoryServiceImpl;
import com.cccs7.co.service.impl.TagServiceImpl;
import com.cccs7.co.strategy.LabelOperationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p> 分类创建策略 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 分类创建策略
 * @Date 2024/3/21 23:04
 */
public class CategoryCreateStrategy implements LabelOperationStrategy {
    @Override
    public <T> T execute(LabelOperationService<T> operationService, Map<String,Object> dataMap) {
        CategoryServiceImpl categoryService = (CategoryServiceImpl) operationService;
        List<String> list = (List<String>) dataMap.get("list");
        List<Category> categories = new ArrayList<>();
        List<Category> resList = list.stream().map(item -> {

            Category category = new Category();
            category.setCategoryType(String.valueOf(LabelType.CATEGORY));
            category.setCategoryName(item);
            return category;
        }
        ).collect(Collectors.toList());


        try {
            categoryService.saveBatch(resList);
            // 操作成功
            return (T) Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            // 操作失败
            return (T) Boolean.FALSE;
        }
    }

    @Override
    public String getIdentifier() {
        return LabelType.CATEGORY + "_" + OperationType.CREATE;
    }
}
