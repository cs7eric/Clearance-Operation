package com.cccs7.co.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cccs7.mybatisplus.entity.PageResult;
import org.springframework.data.domain.Page;

/**
 * <p> FraudCase 服务类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description FraudCase 服务类
 * @Date 2024/3/26 23:06
 */
public interface FraudCaseService  {

    PageResult findPage(Integer pageSize, Integer pageNum);
}
