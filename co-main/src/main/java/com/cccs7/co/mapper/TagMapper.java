package com.cccs7.co.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cccs7.co.bean.po.article.Tag;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p> TagMapper </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description TagMapper
 * @Date 2024/3/20 23:48
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {
}
