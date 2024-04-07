package com.cccs7.co.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cccs7.co.bean.po.user.UserArticleAction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p> UserActionMapper </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description UserActionMapper
 * @Date 2024/4/1 10:15
 */
@Mapper
public interface UserActionMapper extends BaseMapper<UserArticleAction> {

    /**
     * 通过用户名与类型分页查询喜欢列表
     *
     * @param page        分页
     * @param username    用户名
     * @param isLiked
     * @param isCollected
     * @return {@link IPage}<{@link UserArticleAction}>
     */
    IPage<UserArticleAction> findPageLikesByUsernameWithType(Page page, @Param("userId") String username, @Param("isLiked") Boolean isLiked, @Param("isCollected") Boolean isCollected);
}
