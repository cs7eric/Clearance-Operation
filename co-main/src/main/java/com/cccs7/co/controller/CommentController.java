package com.cccs7.co.controller;

import com.cccs7.co.bean.dto.CommentDTO;
import com.cccs7.co.bean.po.Comment;
import com.cccs7.co.service.CommentService;
import com.cccs7.web.bean.Result;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p> 评论Controller </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 评论Controller
 * @Date 2023/10/14 23:51
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 获取该ID下所有评论
     *
     * @param id id
     * @return {@link Result}
     */
    @GetMapping("/all")
    public Result<List<Comment>> getAllCommentsById(@RequestParam("id") String id) {

        List<Comment> commentList = commentService.getAllCommentsById(id);
        return Result.ok(commentList);
    }

    /**
     * 创建评论
     *
     * @param commentDTO 评论Dto
     * @return {@link Result}<{@link String}>
     */
    @PostMapping("/create")
    public Result<String> createComment(@RequestBody CommentDTO commentDTO) {

        commentService.createComment(commentDTO);
        return Result.ok("success");
    }

    /**
     * 更新评论内容
     *
     * @param commentDTO 评论Dto
     * @return {@link Result}
     */
    @PostMapping("/update")
    public Result updateComment(@RequestBody CommentDTO commentDTO) {

        commentService.updateComment(commentDTO);
        return Result.ok("更新成功");
    }

    /**
     * 删除评论
     *  伪删除：更新评论的 delete_flag 为 1
     * @param commentDTO 评论Dto
     * @return {@link Result}<{@link Comment}>
     */
    @PostMapping("/delete")
    public Result<Comment> deleteComment(@RequestBody CommentDTO commentDTO) {

        commentService.deleteComment(commentDTO);
        return Result.ok();
    }
}
