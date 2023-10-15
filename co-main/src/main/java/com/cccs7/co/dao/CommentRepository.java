package com.cccs7.co.dao;

import com.cccs7.co.bean.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * <p> 评论数据访问接口 </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 评论数据访问接口 , 评论的持久层接口
 * @Date: 2023/10/15 16:49
 */
public interface CommentRepository extends MongoRepository<Comment, String> {

    //根据父id查询子评论的分页列表
    Page<Comment> findByParentId(String parentId, Pageable pageable);

}
