package com.cccs7.co.controller;

import com.cccs7.co.bean.dto.common.PageRequestDTO;
import com.cccs7.co.mapper.FraudCaseMapper;
import com.cccs7.co.service.FraudCaseService;
import com.cccs7.mybatisplus.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/page")
    public PageResult page(@RequestBody PageRequestDTO pageRequestDTO) {
        Integer pageNum = pageRequestDTO.getPageNum();
        Integer pageSize = pageRequestDTO.getPageSize();

        return fraudCaseService.findPage(pageSize, pageNum);

    }
}
