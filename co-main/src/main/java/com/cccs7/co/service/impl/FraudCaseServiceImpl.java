package com.cccs7.co.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccs7.co.bean.po.cases.FraudCase;
import com.cccs7.co.mapper.FraudCaseMapper;
import com.cccs7.co.service.FraudCaseService;
import com.cccs7.mybatisplus.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> FraudCase 服务实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description FraudCase 服务实现类
 * @Date 2024/3/26 23:07
 */
@Service
public class FraudCaseServiceImpl
        extends ServiceImpl<FraudCaseMapper, FraudCase>
        implements FraudCaseService, IService<FraudCase> {


    @Autowired
    private FraudCaseMapper fraudCaseMapper;

    @Override
    public PageResult<FraudCase> findPage(Integer pageSize, Integer pageNum) {
        Page<FraudCase> page = new Page<>(pageNum, pageSize);
        IPage<FraudCase> pageData = fraudCaseMapper.selectPage(page, null);
        PageResult<FraudCase> pageResult = new PageResult<>();
        pageResult.loadData(pageData);
        return pageResult;
    }
}
