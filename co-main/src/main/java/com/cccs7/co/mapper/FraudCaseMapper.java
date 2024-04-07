package com.cccs7.co.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cccs7.co.bean.po.cases.FraudCase;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p> FraudCase Mapper </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description FraudCase Mapper
 * @Date 2024/3/26 23:05
 */
@Mapper
public interface FraudCaseMapper extends BaseMapper<FraudCase> {

    /**
     * 随机查询
     *
     * @param limit 限制
     * @return {@link List}<{@link FraudCase}>
     */
    @Select("SELECT * FROM `case_fraud` ORDER BY RAND() LIMIT #{limit}")
    List<FraudCase> selectRandom(Integer limit);

    /**
     * 分页模糊查询
     *
     * @param page 分页
     * @param key  key
     * @return {@link IPage}<{@link FraudCase}>
     */
    IPage<FraudCase> pageFuzzy(Page<FraudCase> page, @Param("key") String key);
}
