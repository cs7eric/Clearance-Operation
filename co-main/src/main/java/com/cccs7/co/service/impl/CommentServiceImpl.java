package com.cccs7.co.service.impl;

import com.cccs7.co.bean.dto.CommentDTO;
import com.cccs7.co.bean.po.Comment;
import com.cccs7.co.convert.CommentConverter;
import com.cccs7.co.service.CommentService;
import com.cccs7.web.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p> 评论接口实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 评论接口实现类
 * @Date 2023/10/14 23:55
 */
@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 通过id获取所有评论
     *
     * @param id id
     * @return {@link List}<{@link Comment}>
     */
    @Override
    public List<Comment> getAllCommentsById(String id) {

        Query query = new Query(Criteria.where("articleId").is(id));
        return mongoTemplate.find(query, Comment.class);
    }

    @Override
    public void createComment(CommentDTO commentDTO) {

        Comment comment = CommentConverter.INSTANCE.dto2po(commentDTO);
        comment.setCreateTime(new Date());
        comment.setLikeNum(0);
        comment.setReplyNum(0);
        Comment saved = mongoTemplate.save(comment);
        System.out.println(saved);
    }
}
