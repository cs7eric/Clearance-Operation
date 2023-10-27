package com.cccs7.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> 自定义BaseMapper </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 自定义BaseMapper
 * @Date 2023/10/27 10:23
 */
@Mapper
public interface MyBaseMapper<T> extends BaseMapper<T> {

    /**
     * 批量插入
     *
     * @param batchList 批处理列表
     * @return int
     */
    int insertBatchSomeColumn(@Param("list")List<T> batchList);
}
