package com.cccs7.co.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cccs7.co.bean.po.article.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p> ArticleMapper </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description ArticleMapper
 * @Date 2024/3/31 22:01
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
