package com.cccs7.co.service;

import com.cccs7.co.bean.dto.CommentDTO;
import com.cccs7.co.bean.po.Comment;
import com.cccs7.web.bean.Result;

import java.util.List;

/**
 * <p> 评论服务接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 评论服务接口
 * @Date 2023/10/14 23:53
 */
public interface CommentService {

    /**
     * 获得第一级评论
     *
     * @param articleId 文章id
     * @return {@link List}<{@link Comment}>
     */
    List<Comment> getFirstLevelComments(String articleId);

    /**
     * 创建评论
     *
     * @param commentDTO 评论Dto
     */
    void createComment(CommentDTO commentDTO);

    /**
     * 更新评论
     *
     * @param commentDTO 评论Dto
     */
    void updateComment(CommentDTO commentDTO);

    /**
     * 删除评论
     *
     * @param commentDTO 评论Dto
     */
    void deleteComment(CommentDTO commentDTO);

    /**
     * 根据parentId获取特定一级评论下的子评论
     *
     * @param articleId 文章id
     * @param commentId 评论id
     * @return {@link List}<{@link Comment}>
     */
    List<Comment> getRepliesToParentComment(String articleId, String commentId);

}
