package com.cccs7.co.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccs7.co.bean.po.article.Tag;
import com.cccs7.co.mapper.TagMapper;
import com.cccs7.co.service.LabelOperationService;
import com.cccs7.co.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 标签服务实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 标签服务实现类
 * @Date 2024/3/20 23:52
 */
@Service
public class TagServiceImpl
        extends ServiceImpl<TagMapper, Tag>
        implements TagService, IService<Tag>, LabelOperationService<Tag> {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public void create(List list) {

    }

    @Override
    public void delete() {

    }

    @Override
    public <T> List<T> list(Class<T> clazz) {
        return null;
    }

    @Override
    public List<Tag> list() {
//        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        return tagMapper.selectList(null);
    }


}
