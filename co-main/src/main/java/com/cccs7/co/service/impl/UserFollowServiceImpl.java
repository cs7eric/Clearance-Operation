package com.cccs7.co.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccs7.co.bean.po.user.UserFollowAction;
import com.cccs7.co.mapper.UserFollowMapper;
import com.cccs7.co.service.UserFollowService;
import org.springframework.stereotype.Service;

/**
 * <p> UserFollowService实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description UserFollowService实现类
 * @Date 2024/4/9 9:18
 */
@Service
public class UserFollowServiceImpl
                            extends ServiceImpl<UserFollowMapper, UserFollowAction>
                            implements UserFollowService, IService<UserFollowAction> {


}
