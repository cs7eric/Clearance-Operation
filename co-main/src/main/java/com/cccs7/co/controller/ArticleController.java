package com.cccs7.co.controller;

import com.cccs7.co.bean.entity.Article;
import com.cccs7.co.service.ArticleService;
import com.cccs7.web.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Result getArticleById(@RequestParam String id){
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException("not null of id");
        }
        Article article = articleService.getArticleById(id);
        if (Objects.isNull(article)) {
            return Result.ok("该a不存在");
        }
        log.info("article:{}",article);
        return Result.ok(article);
    }

    @GetMapping("/all")
    public Result<List<Article>> getAllArticle(){
        List<Article> allArticles = articleService.getAllArticles();
        return Result.ok(allArticles);
    }

    @PostMapping("/create")
    public Result<String> createArticle(@RequestBody Article article) {
        articleService.createArticle(article);
        return Result.ok("添加成功");
    }

}
