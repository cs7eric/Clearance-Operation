package com.cccs7.co.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cccs7.co.bean.dto.user.UserDTO;
import com.cccs7.co.bean.po.user.User;
import com.cccs7.mybatisplus.entity.PageResult;
import com.cccs7.web.bean.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> User服务接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description User服务接口
 * @Date 2023/9/15 23:15
 */
@Service
public interface UserService {
    /**
     * 登录
     *
     * @param userDTO 用户
     * @return {@link Result}
     */
    Result login(UserDTO userDTO);

    /**
     * 注册
     *
     * @param userDTO 用户
     * @return {@link Result}
     */
    Result register(UserDTO userDTO);

    /**
     * 更新用户信息
     *
     * @param user 用户
     */
    void update(User user);

    /**
     * 验证
     * 注册或登录
     *
     * @param userDTO 用户
     * @return {@link Result}
     */
    Result verify(UserDTO userDTO);

    /**
     * 判断用户是否存在
     *
     * @param userDTO 用户
     * @return {@link Boolean}
     */
    Boolean exist(UserDTO userDTO);


    /**
     * 通过用户名获取用户
     *
     * @param userId 用户id
     * @return {@link User}
     */
    User getUserById(Long userId);

    /**
     * 随机获取指定数量用户
     *
     * @param count 数
     * @return {@link List}
     */
    List getRandomUser(Integer count);

    /**
     * 模糊查询
     *
     * @param pageSize 分页大小
     * @param pageNum  当前页数
     * @param keyword  关键字
     * @return {@link IPage}
     */
    PageResult searchFuzzy(Integer pageSize, Integer pageNum, String keyword);

    /**
     * 关注用户
     *
     * @param userId   用户id
     * @param followId 被关注id
     */
    void follow(Long userId, Long followId);

    /**
     * 取消关注
     *
     * @param userId   用户id
     * @param followId 被关注id
     */
    void unfollow(Long userId, Long followId);

    /**
     * 获取某用户粉丝列表
     *
     * @param userId 用户id
     * @return {@link List}
     */
    List getFollowers(Long userId);

    /**
     *  获取某用户正在关注列表
     *
     * @param userId 用户id
     * @return {@link List}
     */
    List getFollowing(Long userId);
}
