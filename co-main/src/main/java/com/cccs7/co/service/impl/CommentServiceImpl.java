package com.cccs7.co.service.impl;

import com.cccs7.co.bean.dto.CommentDTO;
import com.cccs7.co.bean.po.Article;
import com.cccs7.co.bean.po.Comment;
import com.cccs7.co.convert.CommentConverter;
import com.cccs7.co.service.ArticleService;
import com.cccs7.co.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * <p> 评论接口实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 评论接口实现类
 * @Date 2023/10/14 23:55
 */
@Service
public class CommentServiceImpl implements CommentService {


    public static final String COMMENT_STATE_ACTIVE = "active";

    public static final String COMMENT_STATE_INACTIVE = "inactive";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ArticleService articleService;


    /**
     * 通过文章ID获得一级评论
     *
     * @param articleId 文章id
     * @return {@link List}<{@link Comment}>
     */
    @Override
    public List<Comment> getFirstLevelComments(String articleId) {

        List<Comment> commentsList;

        Query query = new Query(Criteria.where("articleId").is(articleId));
        commentsList = mongoTemplate.find(query, Comment.class);
        return commentsList;
    }

    /**
     * 创建评论
     *
     * @param commentDTO 评论Dto
     */
    @Override
    public void createComment(CommentDTO commentDTO) {

        Comment comment = CommentConverter.INSTANCE.dto2po(commentDTO);

        // 初始化当前评论基本信息
        setInfo(comment);
        mongoTemplate.save(comment);

        // 更新文章信息
        String articleId = commentDTO.getArticleId();
        Article article = articleService.getArticleById(articleId);
        article.setReplyNum(article.getReplyNum() + 1);
        articleService.updateArticleById(article);
    }

    /**
     * 更新评论
     *
     * @param commentDTO 评论Dto
     */
    @Override
    public void updateComment(CommentDTO commentDTO) {
        Comment comment = CommentConverter.INSTANCE.dto2po(commentDTO);
        mongoTemplate.save(comment);
    }


    /**
     * 删除评论
     * 将 comment 的 state 置为 "inactive"
     *
     * @param commentDTO 评论Dto
     */
    @Override
    public void deleteComment(CommentDTO commentDTO) {
        Comment comment = CommentConverter.INSTANCE.dto2po(commentDTO);
        String commentId = comment.getId();
        Query query = new Query(Criteria.where("id").is(commentId));
        Update update = new Update();
        update.set("state", COMMENT_STATE_INACTIVE);
        mongoTemplate.updateFirst(query, update, Comment.class);
    }

    /**
     * 根据parentId获取特定一级评论下的子评论
     *
     * @param articleId 文章id
     * @param parentId  父id
     * @return {@link List}<{@link Comment}>
     */
    @Override
    public List<Comment> getRepliesToParentComment(String articleId, String parentId) {

        //构造查询条件
        Criteria criteria = new Criteria();
        Query query = new Query(Criteria
                .where("articleId").is(articleId)
                .and("commentId").is(parentId));
        return mongoTemplate.find(query, Comment.class);
    }


    /**
     * 设置评论基本信息
     *
     * @param comment 评论
     */
    public void setInfo(Comment comment) {
        comment.setCreateTime(new Date());
        comment.setLikeNum(0);
        comment.setReplyNum(0);
        comment.setState(COMMENT_STATE_ACTIVE);
    }
}
