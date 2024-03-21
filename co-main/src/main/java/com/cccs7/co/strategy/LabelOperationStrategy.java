package com.cccs7.co.strategy;

import com.cccs7.co.service.LabelOperationService;

/**
 * <p> 创建策略 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 创建策略
 * @Date 2024/3/20 23:21
 */
public interface LabelOperationStrategy {

    /**
     * 执行
     *
     * @param operationService 操作service
     * @return {@link T}
     */
    <T> T execute(LabelOperationService<T> operationService);

    /**
     * 获得唯一标识符
     *
     * @return {@link String}
     */
    String getIdentifier();

}
