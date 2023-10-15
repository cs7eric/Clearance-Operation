package com.cccs7.co.service.impl;

import com.cccs7.co.bean.po.Comment;
import com.cccs7.co.dao.CommentRepository;
import com.cccs7.co.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 文章评论点赞接口实现类
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 文章评论点赞接口实现类
 * @Date: 2023/10/15 16:59
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 添加评论
     * @param comment
     */
    @Override
    public void createComment(Comment comment) {

        comment.setCreateTime(new Date());
        comment.setLikeNum(0);
        comment.setReplyNum(0);
        comment.setState("1");

        commentRepository.save(comment);

    }

    /**
     * 通过id查询评论
     * @param id
     * @return
     */
    @Override
    public Comment getCommentById(String id) {
        
        return commentRepository.findById(id).get();
    }

    /**
     * 查询所有评论
     * @return
     */
    @Override
    public List<Comment> findAll() {

        return commentRepository.findAll();
    }

    /**
     * 通过id删除评论
     * @param id
     */
    @Override
    public void deleteComment(String id) {

        commentRepository.deleteById(id);
    }
}
