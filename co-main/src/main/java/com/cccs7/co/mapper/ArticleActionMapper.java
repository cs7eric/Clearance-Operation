package com.cccs7.co.mapper;

import com.cccs7.co.bean.po.user.UserArticleAction;
import com.cccs7.mybatisplus.mapper.MyBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p> 用户文章行为Mapper </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户文章行为Mapper
 * @Date 2023/10/27 10:27
 */
@Mapper
public interface ArticleActionMapper extends MyBaseMapper<UserArticleAction> {

    /**
     * 批量插入或更新
     *
     * @param dataList 数据列表
     */
    void batchInsertOrUpdate(List<UserArticleAction> dataList);
}
