package com.cccs7.co.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cccs7.co.bean.dto.user.UserActionDTO;
import com.cccs7.co.bean.po.article.Article;
import com.cccs7.co.bean.po.user.UserArticleAction;
import com.cccs7.mybatisplus.entity.PageResult;

import java.util.List;

/**
 * <p> 用户行为接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户行为接口
 * @Date 2023/10/25 23:57
 */
public interface UserActionService extends IService<UserArticleAction> {

    /**
     * 执行用户行为
     *
     * @param userActionDTO 用户行为Dto
     */
    void doAction(UserActionDTO userActionDTO);

    /**
     * 判断表中是否存在该条数据
     *
     * @param userId    用户id
     * @param articleId 文章id
     * @return boolean
     */
    boolean existItem(Long userId, String articleId);

    /**
     * 更新
     *
     * @param userArticleAction 用户文章操作
     */
    void update(UserArticleAction userArticleAction);

    /**
     * 批量插入或更新
     *
     * @param dataList 数据列表
     */
    void batchInsertOrUpdate(List<UserArticleAction> dataList);


    /**
     * 根据用户id获取文章列表
     *
     * @param userId 用户id
     * @return {@link List}<{@link UserArticleAction}>
     */
    List<UserArticleAction> getArticleListByUserId(Long  userId);

    /**
     * 通过用户名获得用户点赞列表
     *
     * @param username 用户名
     * @return {@link List}<{@link Article}>
     */
    List getLikesByUsername(String username);

    /**
     * 按id获取点赞数据
     *
     * @param id id
     * @return {@link List}
     */
    List getLikesById(Long id);

    void getList();

    /**
     * 分页查询用户喜欢列表
     *
     * @param pageNum    当前页数
     * @param pageSize   分页大小
     * @param userId   用户ID
     * @param actionType 动作类型
     * @return {@link PageResult}
     */
    PageResult findPageLikes(Integer pageNum, Integer pageSize, String userId, String actionType);
}
