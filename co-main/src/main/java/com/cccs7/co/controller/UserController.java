package com.cccs7.co.controller;

import com.cccs7.co.bean.dto.user.UserDTO;
import com.cccs7.co.bean.po.article.Article;
import com.cccs7.co.bean.po.user.User;
import com.cccs7.co.service.UserActionService;
import com.cccs7.co.service.UserService;
import com.cccs7.web.bean.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p> 用户控制层 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户控制层
 * @Date 2023/9/17 21:56
 */
@Api("用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserActionService userActionService;

    /**
     * 注册  - 普通用户注册
     *
     * @param userDTO 用户
     * @return {@link Result}<{@link String}>
     */
    @ApiOperation("用户注册、登录功能")
    @PostMapping("/verify")
    public Result verify(@RequestBody UserDTO userDTO) {
        return userService.verify(userDTO);
    }

    /**
     * 登录
     *
     * @param userDTO 用户
     * @return {@link Result}
     */
    @ApiOperation("用户登录")
    @PostMapping("/logino")
    public Result login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody User user) {
        userService.update(user);
        return Result.ok("用户信息更新成功");
    }

    @GetMapping("/likes")
    public Result<List> getLikeArticles(@RequestParam String username) {
        List likes = userActionService.getLikesByUsername(username);
        return Result.ok(likes);
    }

    @GetMapping("likes_id")
    public Result<List> getLikeArticlesById(@RequestParam String userId) {
        List articles = userActionService.getLikesById(Long.parseLong(userId));
        return Result.ok(articles);
    }
}
