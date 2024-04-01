package com.cccs7.co.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccs7.co.bean.dto.user.UserActionDTO;
import com.cccs7.co.bean.po.user.UserArticleAction;
import com.cccs7.co.enums.UserActionType;
import com.cccs7.co.factory.UserActionFactory;
import com.cccs7.co.mapper.ArticleActionMapper;
import com.cccs7.co.mapper.UserActionMapper;
import com.cccs7.co.service.UserActionService;
import com.cccs7.co.strategy.UserActionStrategy;
import com.cccs7.redis.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p> 用户行为接口实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 用户行为接口实现类
 * @Date 2023/10/25 23:57
 */
@Service
public class UserActionServiceImpl
        extends ServiceImpl<UserActionMapper, UserArticleAction>
        implements UserActionService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserActionMapper userActionMapper;

    @Autowired
    private ArticleActionMapper articleActionMapper;

    @Lazy
    @Autowired
    private ArticleServiceImpl articleService;


    @Override
    public void doAction(UserActionDTO userActionDTO) {

        String actionType = userActionDTO.getUserActionType();
        UserActionType userActionType = UserActionType.valueOf(actionType.toUpperCase());
        UserActionStrategy actionStrategy = UserActionFactory.getStrategy(userActionType);
        actionStrategy.execute(userActionDTO, redisCache);
    }


    @Override
    public boolean existItem(Long userId, String articleId) {
        LambdaQueryWrapper<UserArticleAction> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserArticleAction::getUserId, userId)
                .eq(UserArticleAction::getArticleId, articleId);

        UserArticleAction articleAction = articleActionMapper.selectOne(queryWrapper);
        return !Objects.isNull(articleAction);
    }

    @Override
    public void update(UserArticleAction userArticleAction) {
        String articleId = userArticleAction.getArticleId();
        Long userId = userArticleAction.getUserId();
        LambdaUpdateWrapper<UserArticleAction> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(UserArticleAction::getUserId, userId)
                .eq(UserArticleAction::getArticleId, articleId);
        articleActionMapper.update(userArticleAction, updateWrapper);
    }


    @Override
    public void batchInsertOrUpdate(List<UserArticleAction> dataList) {
        StringBuilder sql = new StringBuilder("INSERT INTO your_table_name (userId, articleId, your_column_name) VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE your_column_name = VALUES(your_column_name)");
    }

    /**
     * 根据用户id获取用户操作文章列表
     *
     * @param userId 用户id
     * @return {@link List}<{@link UserArticleAction}>
     */
    public List<UserArticleAction> getArticleListByUserId(Long userId) {

        LambdaQueryWrapper<UserArticleAction> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserArticleAction::getUserId, userId);
        return articleActionMapper.selectList(queryWrapper);
    }


    @Override
    public List getLikesByUsername(String username) {
        LambdaQueryWrapper<UserArticleAction> wrapper = new LambdaQueryWrapper<UserArticleAction>()
                .eq(UserArticleAction::getUsername, username)
                .eq(UserArticleAction::getIsLiked, 1);
        List<UserArticleAction> likeList = userActionMapper.selectList(wrapper);


        List<String> collected = likeList.stream().map(UserArticleAction::getArticleId)
                .collect(Collectors.toList());
        return collected.stream().map(articleId -> articleService.getArticleById(articleId))
                .collect(Collectors.toList());


    }

    @Override
    public List getLikesById(Long id) {
        LambdaQueryWrapper<UserArticleAction> wrapper = new LambdaQueryWrapper<UserArticleAction>();

        wrapper.eq(UserArticleAction::getUserId, id)
                .eq(UserArticleAction::getIsLiked, 1);

        List<UserArticleAction> likeList = userActionMapper.selectList(wrapper);


        List<String> collected = likeList.stream().map(UserArticleAction::getArticleId)
                .collect(Collectors.toList());
        return collected.stream().map(articleId -> articleService.getArticleById(articleId))
                .collect(Collectors.toList());
    }



    @Override
    public void getList() {
        Long id = 1712410707829501954L;
        LambdaQueryWrapper<UserArticleAction> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserArticleAction::getUserId, id);
        List<UserArticleAction> actions = userActionMapper.selectList(queryWrapper);
        actions.forEach(System.out::println);
    }
}
