package com.cccs7.co.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cccs7.co.bean.po.user.UserFollowAction;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p> 用户关注Mapper </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户关注Mapper
 * @Date 2024/4/9 9:16
 */
@Mapper
public interface UserFollowMapper extends BaseMapper<UserFollowAction>{
}
