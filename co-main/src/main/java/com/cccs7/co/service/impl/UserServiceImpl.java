package com.cccs7.co.service.impl;

import com.cccs7.co.bean.entity.LoginUser;
import com.cccs7.co.bean.entity.User;
import com.cccs7.co.mapper.UserMapper;
import com.cccs7.co.service.UserService;
import com.cccs7.co.util.JwtUtils;
import com.cccs7.redis.util.RedisCache;
import com.cccs7.web.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * <p> 用户服务接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户服务接口
 * @Date 2023/9/15 23:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     *
     * @param user 用户
     * @return {@link Result}<{@link HashMap}<{@link String}, {@link String}>>
     */
    @Override
    public Result<HashMap<String, String>> login(User user) {

        // 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        // 如果认证没有通过，给出相应提示
        if (Objects.isNull(authentication)) {
            throw new RuntimeException("登录失败");
        }

        // 如果认证通过，使用 userid 生成一个 jwt, jwt 存入 Result 中 返回
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtils.createJWT(userid);
        HashMap<String, String> map = new HashMap<>();
        map.put("token", jwt);

        // 把完整的信息 存到 redis, userid 作为 key
        redisCache.setCacheObject("login:" + userid, loginUser);
        return Result.ok(map);
    }

    /**
     * 注册
     *
     * @param user 用户
     */
    @Override
    public void register(User user) {
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户信息错误，请重新提交");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setId(null);
        user.setPassword(encodedPassword);
        userMapper.insert(user);
    }


    /**
     * 更新
     *
     * @param user 用户
     */
    @Override
    public void update(User user) {

    }
}
