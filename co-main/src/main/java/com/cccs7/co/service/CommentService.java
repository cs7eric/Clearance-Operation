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
     * 获取所有评论
     *
     * @param id id
     * @return {@link Result}
     */
    List<Comment> getAllCommentsById(String id);

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
}
