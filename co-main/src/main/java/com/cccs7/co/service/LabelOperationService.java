package com.cccs7.co.service;

import com.cccs7.co.enums.LabelType;

import java.util.List;

/**
 * <p> 标签、分类接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 标签、分类接口
 * @Date 2024/3/21 8:11
 */
public interface LabelOperationService<E>{

    /**
     * 创建策略
     */
    void create(List list);

    /**
     * 删除
     */
    void delete();

    /**
     * 列表
     *
     * @param clazz clazz
     * @return {@link List}<{@link T}>
     */
    <T> List<T> list(Class<T> clazz);

    /**
     * 列表
     *
     * @return {@link List}<{@link E}>
     */
    List<E> list();
}
