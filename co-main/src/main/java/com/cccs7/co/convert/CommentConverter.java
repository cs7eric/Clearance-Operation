package com.cccs7.co.convert;

import com.cccs7.co.bean.dto.CommentDTO;
import com.cccs7.co.bean.po.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p> 评论实体类映射 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 评论实体类映射
 * @Date 2023/10/15 16:45
 */
@Mapper
public interface CommentConverter {

    CommentConverter INSTANCE = Mappers.getMapper(CommentConverter.class);

    /**
     * dto2po
     *
     * @param commentDTO 评论Dto
     * @return {@link Comment}
     */
    Comment dto2po(CommentDTO commentDTO);

    /**
     * po2dto
     *
     * @param comment 评论
     * @return {@link CommentDTO}
     */
    CommentDTO po2dto(Comment comment);
}
