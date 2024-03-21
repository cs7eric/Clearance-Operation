package com.cccs7.co.controller;

import com.cccs7.co.bean.dto.article.LabelDTO;
import com.cccs7.co.bean.po.article.Category;
import com.cccs7.co.enums.LabelType;
import com.cccs7.co.service.CategoryService;
import com.cccs7.co.service.LabelOperationService;
import com.cccs7.co.service.TagService;
import com.cccs7.co.service.impl.CategoryServiceImpl;
import com.cccs7.co.service.impl.TagServiceImpl;
import com.cccs7.web.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 标签分类controller </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 标签分类controller
 * @Date 2024/3/20 23:34
 */
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private TagServiceImpl tagServiceImpl;

    @GetMapping("/list")
    public <T> Result<List<T>> getList(@RequestParam("type") String type) {

        List<T> resList = new ArrayList<>();
        if (type.equalsIgnoreCase(LabelType.CATEGORY.toString())) {
            List<Category> list = categoryService.list();
        } else {

        }
        return null;
    }
}
