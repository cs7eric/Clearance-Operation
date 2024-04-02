package com.cccs7.co.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cccs7.mybatisplus.entity.PageResult;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * <p> FraudCase 服务类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description FraudCase 服务类
 * @Date 2024/3/26 23:06
 */
public interface FraudCaseService  {

    /**
     * 分页查询
     *
     * @param pageSize 分页大小
     * @param pageNum  当前页数
     * @return {@link PageResult}
     */
    PageResult findPage(Integer pageSize, Integer pageNum);

    /**
     * 找到列表
     * 随机查询指定数量案例
     *
     * @param count 数量
     * @return {@link List}
     */
    List findList(Integer count);
}
