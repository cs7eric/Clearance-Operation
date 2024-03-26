package com.cccs7.co.controller;

import com.cccs7.co.bean.dto.article.LabelDTO;
import com.cccs7.co.bean.dto.article.LabelListDTO;
import com.cccs7.co.service.impl.CategoryServiceImpl;
import com.cccs7.co.service.impl.DynamicLabelOperationServiceImpl;
import com.cccs7.co.service.impl.TagServiceImpl;
import com.cccs7.web.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @Autowired
    private DynamicLabelOperationServiceImpl dynamicLabelOperationService;

    @GetMapping("/list")
    public <T> Result<List<T>> getList(@RequestParam("type") String type) {

        HashMap<String, Object> dataMap = new HashMap<>();
        List<T> resList =  dynamicLabelOperationService.performOperation(type, "List", dataMap);
        return Result.ok(resList);
    }

    @PostMapping
    public Result<String> create(@RequestBody LabelListDTO labelListDTO) {
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("list", labelListDTO.getLabelList());
        dynamicLabelOperationService.performOperation(labelListDTO.getLabelType(),"Create", dataMap);
        return Result.ok("添加成功");
    }
}
