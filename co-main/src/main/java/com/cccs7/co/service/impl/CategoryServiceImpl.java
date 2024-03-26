package com.cccs7.co.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccs7.co.bean.po.article.Category;
import com.cccs7.co.enums.LabelType;
import com.cccs7.co.mapper.CategoryMapper;
import com.cccs7.co.service.CategoryService;
import com.cccs7.co.service.LabelOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 分类服务实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 分类服务实现类
 * @Date 2024/3/20 23:53
 */

@Service
public class CategoryServiceImpl
        extends ServiceImpl<CategoryMapper, Category>
        implements IService<Category>,CategoryService, LabelOperationService<Category> {


    @Autowired
    private CategoryMapper categoryMapper;

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
    public List<Category> list() {
        return categoryMapper.selectList(null);
    }
}
