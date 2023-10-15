package com.cccs7.co.test.comment;

import com.cccs7.co.bean.po.Comment;
import com.cccs7.co.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * <p> 评论测试类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 评论测试类
 * @Date 2023/10/14 23:57
 */
@SpringBootTest
public class CommentTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void testFindById() {
        String id = "6524eaf0bd5df419a9b11eb5";
        List<Comment> comments = commentService.getAllCommentsById(id);
        System.out.println("--------");
        comments.forEach(System.out::println);
        System.out.println("--------");
    }
}
