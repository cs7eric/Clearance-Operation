package com.cccs7.co.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cccs7.co.bean.bo.LoginUser;
import com.cccs7.co.bean.po.user.User;
import com.cccs7.co.mapper.MenuMapper;
import com.cccs7.co.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p> UserDetailServiceImpl </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description UserDetailServiceImpl
 * @Date 2023/9/15 10:09
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(wrapper);

        // if null, throw exception
        if (Objects.isNull(user)) {
            throw new RuntimeException("username or password error");
        }

        // 根据用户查询权限信息，添加到 LoginUser 中
        List<String> permsList = menuMapper.selectPermsByUserId(user.getId());
        // 封装为 UserDetail 对象返回
        return new LoginUser(user, permsList);
    }
}
