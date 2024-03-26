package com.cccs7.co.strategy.impl;

import com.cccs7.co.bean.po.article.Tag;
import com.cccs7.co.bean.po.article.Tag;
import com.cccs7.co.enums.LabelType;
import com.cccs7.co.enums.OperationType;
import com.cccs7.co.service.LabelOperationService;
import com.cccs7.co.service.TagService;
import com.cccs7.co.service.impl.TagServiceImpl;
import com.cccs7.co.service.impl.TagServiceImpl;
import com.cccs7.co.strategy.LabelOperationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p> 标签创建策略 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 标签创建策略
 * @Date 2024/3/21 23:03
 */
public class TagCreateStrategy implements LabelOperationStrategy {

    @Override
    public <T> T execute(LabelOperationService<T> operationService, Map<String,Object> dataMap) {

        TagServiceImpl tagService = (TagServiceImpl) operationService;
        List<String> list = (List<String>) dataMap.get("list");
        List<Tag> tags = new ArrayList<>();
        List<Tag> resList = list.stream().map(item -> {

                    Tag Tag = new Tag();
                    Tag.setTagType(String.valueOf(LabelType.TAG));
                    Tag.setTagName(item);
                    return Tag;
                }
        ).collect(Collectors.toList());
        try {
            tagService.saveBatch(resList);
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
        return LabelType.TAG + "_" + OperationType.CREATE;
    }
}
