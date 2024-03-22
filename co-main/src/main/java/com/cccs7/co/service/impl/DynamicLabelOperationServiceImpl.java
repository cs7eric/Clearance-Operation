package com.cccs7.co.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccs7.co.enums.LabelType;
import com.cccs7.co.service.DynamicLabelOperationService;
import com.cccs7.co.service.LabelOperationService;
import com.cccs7.co.service.TagService;
import com.cccs7.co.strategy.LabelOperationStrategy;
import com.cccs7.co.strategy.impl.CategoryCreateStrategy;
import com.cccs7.co.strategy.impl.CategoryListStrategy;
import com.cccs7.co.strategy.impl.TagCreateStrategy;
import com.cccs7.co.strategy.impl.TagListStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> 动态策略服务实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 动态策略服务实现类
 * @Date 2024/3/21 22:37
 */
@Service
public class DynamicLabelOperationServiceImpl implements DynamicLabelOperationService {


    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TagServiceImpl tagService;


    private static final Map<String, LabelOperationStrategy> STRATEGY_MAP = new HashMap<>();

    static {
        initializeStrategies();
    }

    private static void initializeStrategies() {
        List<LabelOperationStrategy> strategies = new ArrayList<>();
        strategies.add(new CategoryListStrategy());
        strategies.add(new CategoryCreateStrategy());
        strategies.add(new TagCreateStrategy());
        strategies.add(new TagListStrategy());

        // 填充策略映射
        strategies.forEach(strategy -> STRATEGY_MAP.put(strategy.getIdentifier(), strategy));
    }

    /**
     * 动态标签操作服务实现类
     *
     */
    public DynamicLabelOperationServiceImpl() {
    }


    /**
     * 执行操作
     *
     * @param labelType     标签类型
     * @param operationType 操作类型
     * @return {@link T}
     */
    public <T> T performOperation(String labelType, String operationType) {
        String identifier = labelType + "_" + operationType;
        String identifierUpperCase = identifier.toUpperCase();
        StringBuilder sb = new StringBuilder("com.cccs7.co.service.impl.");
        sb.append(labelType.substring(0, 1).toUpperCase());
        sb.append(labelType.substring(1));
        sb.append("ServiceImpl");
        String service = sb.toString();
        LabelOperationStrategy strategy = STRATEGY_MAP.get(identifierUpperCase);

        try {
            Class<?> serviceClass = Class.forName(service);
            Object serviceInstance = applicationContext.getBean(serviceClass);
            return strategy.execute((LabelOperationService<T>) serviceInstance);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
