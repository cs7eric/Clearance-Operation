package com.cccs7.co.controller;

import com.cccs7.co.bean.dto.article.CommentDTO;
import com.cccs7.co.bean.po.article.Comment;
import com.cccs7.co.service.CommentService;
import com.cccs7.web.bean.Result;
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
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 获得第一级评论
     *
     * @param articleId 文章id
     * @return {@link Result}<{@link List}<{@link Comment}>>
     */
    @GetMapping("/{articleId}")
    public Result<List<Comment>> getFirstLevelComments(@PathVariable String articleId) {
        // 在这里使用articleId来获取一级评论
        List<Comment> commentList = commentService.getFirstLevelComments(articleId);
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


    /**
     * 在这里根据parentId获取特定一级评论下的子评论
     *
     * @param articleId 文章id
     * @param commentId  父id
     * @return {@link Result}<{@link List}<{@link Comment}>>
     */
    @GetMapping("/{articleId}/{commentId}/replies")
    public Result<List<Comment>> getRepliesToParentComment(
            @PathVariable String articleId,
            @PathVariable String commentId
    ) {
        // 在这里根据articleId和parentId获取子评论
        List<Comment> replies = commentService.getRepliesToParentComment(articleId, commentId);
        return Result.ok(replies);
    }
}
