package com.cccs7.co.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cccs7.co.bean.entity.LoginUser;
import com.cccs7.co.bean.entity.User;
import com.cccs7.co.bean.req.UserReq;
import com.cccs7.co.convert.UserConverter;
import com.cccs7.co.mapper.MenuMapper;
import com.cccs7.co.mapper.UserMapper;
import com.cccs7.co.service.UserService;
import com.cccs7.co.util.JwtUtils;
import com.cccs7.redis.util.RedisCache;
import com.cccs7.web.bean.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private MenuMapper menuMapper;


    /**
     * 登录
     *
     * @param userReq 用户
     * @return {@link Result}<{@link HashMap}<{@link String}, {@link String}>>
     */
    @Override
    public Result<HashMap<String, Object>> login(UserReq userReq) {

        User user = UserConverter.INSTANCE.convertReqToUser(userReq);

        //判断验证码是否正确
        String code = userReq.getCode();
        String email = userReq.getEmail();
        String codeKey = "auth:" + email;
        String redisCode = redisCache.getCacheObject(codeKey);
        if (!redisCode.equalsIgnoreCase(code)) {
            throw new RuntimeException("验证码错误");
        }

        LoginUser loginUser = new LoginUser();
        // 邮箱验证码登录，忽略 用户信息的认证
        if (StringUtils.isNotBlank(user.getPassword())) {
            //进行用户验证
            loginUser = authenticateByUsernameAndPassword(user);
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getEmail, user.getEmail());
        User one = userMapper.selectOne(queryWrapper);
        loginUser.setUser(one);

        // 获取用户权限，并添加到 LoginUser 中
        List<String> permsList = menuMapper.selectPermsByUserId(user.getId());
        loginUser.setPermissions(permsList);

        // 如果认证通过，使用 userid 生成一个 jwt, jwt 存入 Result 中 返回
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtils.createJWT(userid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", jwt);
        map.put("user", loginUser);

        // 把完整的信息 存到 redis, userid 作为 key
        redisCache.setCacheObject("login:" + userid, loginUser);
        return Result.ok(map);
    }

    /**
     * 注册
     *
     * @param userReq 用户
     */
    @Override
    public Result register(UserReq userReq) {

        User user = UserConverter.INSTANCE.convertReqToUser(userReq);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户信息错误，请重新提交");
        }
        user.setUsername(user.getEmail());
        userMapper.insert(user);
        return Result.ok("注册成功");
    }

    @Override
    public Result<HashMap<String, Object>> verify(UserReq userReq) {

        //判断当前用户是否已经注册
        Boolean exist = exist(userReq);
        if (!exist) {
            //用户未注册 -> 注册
            return register(userReq);
        }
        return login(userReq);
    }

    /**
     * 更新
     *
     * @param user 用户
     */
    @Override
    public void update(User user) {
    }

    /**
     * 判断用户是否已经注册
     *
     * @param userReq 用户
     * @return {@link Boolean}
     */
    @Override
    public Boolean exist(UserReq userReq) {

        User user = UserConverter.INSTANCE.convertReqToUser(userReq);
        String userEmail = user.getEmail();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getEmail, userEmail);
        User dbUser = userMapper.selectOne(queryWrapper);
        return !Objects.isNull(dbUser);
    }


    /**
     * 通过用户名和密码验证
     *
     * @param user 用户
     * @return {@link LoginUser}
     */
    public LoginUser authenticateByUsernameAndPassword(User user) {
        // 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        // 如果认证没有通过，给出相应提示
        if (Objects.isNull(authentication)) {
            throw new RuntimeException("登录失败");
        }

        return (LoginUser) authentication.getPrincipal();

    }
}
