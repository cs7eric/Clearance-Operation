package com.cccs7.co.controller;

import com.cccs7.co.bean.po.Comment;
import com.cccs7.co.service.CommentService;
import com.cccs7.web.bean.Result;
import com.cccs7.web.exception.ExceptionInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p> 文章评论点赞Controller </p>
 *
 * @Author: byxl8112 - byxl8112@gmail.com
 * @Description: 文章评论点赞Controller
 * @Date: 2023/10/15 16:57
 */
@RestController
@RequestMapping("/comments")
@Api(tags = "文章评论点赞")
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加评论
     * @param comment comment
     * @return
     */
    @PostMapping("/createComment")
    public Result saveComment(@RequestBody Comment comment){
        commentService.createComment(comment);
        return Result.ok("添加评论成功");
    }

    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    @GetMapping
    public Result getCommentById(@RequestParam String id){
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException("not null of id");
        }

        Comment comment = commentService.getCommentById(id);

        if(Objects.isNull(comment)){
            return Result.ok(ExceptionInfo.COMMENT_NOT_EXIST);
        }

        return Result.ok(comment);
    }

    /**
     * 查询所有评论
     * @return
     */
    @GetMapping("/allComment")
    public Result<List<Comment>> getAllComment(){
        List<Comment> allComments = commentService.findAll();
        return Result.ok(allComments);
    }

    /**
     * 通过id删除评论
     * @param id id
     * @return
     */
    @DeleteMapping("/deleteComment")
    public Result deleteComment(@RequestParam String id){

        commentService.deleteComment(id);
        return Result.ok("删除评论成功");
    }




















}
