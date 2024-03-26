package com.cccs7.co.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cccs7.co.bean.po.article.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p> CategoryMapper </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description CategoryMapper
 * @Date 2024/3/20 23:50
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
