package com.cccs7.co.mapper;

import com.cccs7.co.bean.po.UserArticleAction;
import com.cccs7.mybatisplus.mapper.MyBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p> 用户文章行为Mapper </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户文章行为Mapper
 * @Date 2023/10/27 10:27
 */
@Mapper
public interface ArticleActionMapper extends MyBaseMapper<UserArticleAction> {
}
