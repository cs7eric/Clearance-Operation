package com.cccs7.co.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccs7.co.bean.dto.user.UserDTO;
import com.cccs7.co.bean.bo.LoginUser;
import com.cccs7.co.bean.po.user.User;
import com.cccs7.co.convert.UserConverter;
import com.cccs7.co.mapper.MenuMapper;
import com.cccs7.co.mapper.UserMapper;
import com.cccs7.co.service.UserService;
import com.cccs7.co.util.JwtUtils;
import com.cccs7.redis.util.RedisCache;
import com.cccs7.web.bean.Result;
import com.cccs7.web.exception.CodeException;
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
public class UserServiceImpl
        extends ServiceImpl<UserMapper, User>
        implements UserService, IService<User> {

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
     * @param userDTO 用户
     * @return {@link Result}<{@link HashMap}<{@link String}, {@link String}>>
     */
    @Override
    public Result<HashMap<String, Object>> login(UserDTO userDTO) {

        User user = new User();
        user = UserConverter.INSTANCE.dto2po(userDTO);

        //判断验证码是否正确
        String code = userDTO.getCode();
        String email = userDTO.getEmail();
        String codeKey = "auth:" + email;
        String redisCode = redisCache.getCacheObject(codeKey);
        if (StringUtils.isBlank(redisCode)) {
            throw new CodeException();
        }
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
        String userid = one.getId().toString();
        String jwt = JwtUtils.createJWT(userid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", jwt);
        map.put("userInfo", loginUser);

        // 把完整的信息 存到 redis, userid 作为 key
        redisCache.setCacheObject("login:" + userid, loginUser);
        return Result.ok(map);
    }

    /**
     * 注册
     *
     * @param userDTO 用户
     */
    @Override
    public Result register(UserDTO userDTO) {

        User user = new User();
        user = UserConverter.INSTANCE.dto2po(userDTO);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户信息错误，请重新提交");
        }

        user.setUsername(user.getEmail());
        user.setAvatar("/src/assets/default_avatar.jpg");

        userMapper.insert(user);
        return Result.ok("注册成功");
    }

    @Override
    public Result<HashMap<String, Object>> verify(UserDTO userDTO) {

        //判断当前用户是否已经注册
        Boolean exist = exist(userDTO);
        HashMap<String, Object> infoMap = new HashMap<>();
        if (!exist) {
            //用户未注册 -> 注册
            register(userDTO);
        }
        return login(userDTO);
    }

    /**
     * 更新
     *
     * @param user 用户
     */
    @Override
    public void update(User user) {
        // 根据用户名查询用户
        LambdaUpdateWrapper<User> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        userMapper.update(user, queryWrapper);
    }

    /**
     * 判断用户是否已经注册
     *
     * @param userDTO 用户
     * @return {@link Boolean}
     */
    @Override
    public Boolean exist(UserDTO userDTO) {

        User user = new User();
        // 将UserDTO转换成UserPO
        user = UserConverter.INSTANCE.dto2po(userDTO);
        // 获取用户邮箱
        String userEmail = user.getEmail();

        // 使用LambdaQueryWrapper查询用户
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 设置查询条件
        queryWrapper.eq(User::getEmail, userEmail);
        // 查询用户
        User dbUser = userMapper.selectOne(queryWrapper);
        // 判断查询结果是否为空
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


    /**
     * 通过用户名获取用户
     *
     * @param username 用户名
     * @return {@link User}
     */
    @Override
    public User getUserByUsername(String username) {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        return userMapper.selectOne(queryWrapper);
    }
}
