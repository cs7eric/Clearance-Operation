package com.cccs7.co.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cccs7.co.bean.po.User;
import com.cccs7.mybatisplus.mapper.MyBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p> UserMapper 接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description UserMapper 接口
 * @Date 2023/9/13 23:09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
