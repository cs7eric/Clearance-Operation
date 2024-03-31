package com.cccs7.co.controller;

import com.cccs7.co.bean.dto.common.PageRequestDTO;
import com.cccs7.co.bean.po.cases.FraudCase;
import com.cccs7.co.mapper.FraudCaseMapper;
import com.cccs7.co.service.FraudCaseService;
import com.cccs7.mybatisplus.entity.PageResult;
import com.cccs7.web.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p> FraudCase Controller </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description FraudCase Controller
 * @Date 2024/3/26 23:01
 */
@RestController
@RequestMapping("/fraud")
public class FraudCaseController {


    @Autowired
    private FraudCaseMapper fraudCaseMapper;

    @Autowired
    private FraudCaseService fraudCaseService;

    @PostMapping("/page")
    public Result<PageResult> page(@RequestBody PageRequestDTO pageRequestDTO) {
        Integer pageNum = pageRequestDTO.getPageNum();
        Integer pageSize = pageRequestDTO.getPageSize();

        return Result.ok(fraudCaseService.findPage(pageSize, pageNum));

    }
}
