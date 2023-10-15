package com.cccs7.co.service;

import com.cccs7.co.bean.po.Comment;

import java.util.List;

/**
 * <p> 文章评论点赞接口 </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 文章评论点赞接口
 * @Date: 2023/10/15 16:58
 */
public interface CommentService {

    /**
     * 添加评论
     * @param comment
     */
    void createComment(Comment comment);

    /**
     * 查询所有评论
     * @return
     */
    List<Comment> findAll();

    /**
     * 通过id删除评论
     * @param id
     */
    void deleteComment(String id);

    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    Comment getCommentById(String id);
}
