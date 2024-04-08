package com.cccs7.co.controller;

import com.cccs7.co.bean.dto.article.ArticleDTO;
import com.cccs7.co.bean.dto.article.ArticlePageDTO;
import com.cccs7.co.bean.dto.common.PageRequestDTO;
import com.cccs7.co.bean.dto.user.UserActionDTO;
import com.cccs7.co.bean.po.article.Article;
import com.cccs7.co.service.ArticleService;
import com.cccs7.co.service.UserActionService;
import com.cccs7.mybatisplus.entity.PageResult;
import com.cccs7.web.bean.PageResponse;
import com.cccs7.web.bean.Result;
import com.mongodb.lang.Nullable;
import javafx.print.Collation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * <p> ArticleController </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description ArticleController
 * @Date 2023/10/9 10:43
 */
@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserActionService userActionService;

    @GetMapping
    public Result getArticleById(@RequestParam String id) {
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException("not null of id");
        }
        Article article = articleService.getArticleById(id);
        if (Objects.isNull(article)) {
            return Result.ok(Collections.emptyList());
        }
        log.info("article:{}", article);
        return Result.ok(article);
    }

    /**
     * 获取所有文章
     *
     * @return {@link Result}<{@link List}<{@link Article}>>
     */
    @PostMapping("/all")
    public Result getAllArticle(@RequestBody ArticleDTO articleDTO) {
        List allArticles = articleService.getAllArticles(articleDTO);
        return Result.ok(allArticles);
    }

    /**
     * 创建文章
     *
     * @param articleDTO 文章Dto
     * @return {@link Result}<{@link String}>
     */
    @PostMapping("/create")
    public Result<String> createArticle(@RequestBody ArticleDTO articleDTO) {
        articleService.createArticle(articleDTO);
        return Result.ok("添加成功");
    }

    /**
     * 获取问题回答列表
     *
     * @param issueId 问题id
     * @return {@link Result}<{@link List}<{@link Article}>>
     */
    @GetMapping("/answers/{issueId}")
    public Result<List<Article>> getIssueAnswers(@PathVariable String issueId) {
        List<Article> answers = articleService.getIssueAnswers(issueId);
        return Result.ok(answers);
    }

    /**
     * 执行用户行为 - 点赞、收藏
     *
     * @param userActionDTO 用户行动Dto
     * @return {@link Result}<{@link String}>
     */
    @PostMapping("/action")
    public Result<String> doAction(@RequestBody UserActionDTO userActionDTO) {

        userActionService.doAction(userActionDTO);
        return Result.ok("操作成功");
    }

    @GetMapping("/user/{username}")
    public Result<List<Article>> getArticlesByUsername(@PathVariable String username) {
        List<Article> articles = articleService.getArticlesByUsername(username);
        return Result.ok(articles);
    }

    /**
     * 分页获取文章集合
     *
     * @param articlePageDTO 文章分页Dto
     * @return {@link Result}<{@link PageResult}<{@link Article}>>
     */
    @PostMapping("/page")
    public Result<PageResult<Article>> getArticlesByPage(@RequestBody ArticlePageDTO articlePageDTO) {

        Integer pageSize = articlePageDTO.getPageSize();
        Integer pageNum = articlePageDTO.getPageNum();
        String username = articlePageDTO.getUsername();


        PageResult<Article> res = articleService.getArticlesByPage(pageNum, pageSize, username);
        return Result.ok(res);
    }

    @GetMapping("/count")
    public Result<Long> getCountByUsername(@RequestParam @Nullable String username) {
        Long count = articleService.getCountByUsername(username);
        return Result.ok(count);
    }

    @GetMapping("/search")
    public Result<ArticlePageDTO> search(@RequestParam String likeKey,
                                            @RequestParam Integer pageSize,
                                            @RequestParam Integer pageNum) {

        HashMap<String, Object> dataMap = new HashMap<>();
        ArticlePageDTO res = articleService.queryFuzzily(pageSize, pageNum, likeKey);

        return Result.ok(res);
    }
}
