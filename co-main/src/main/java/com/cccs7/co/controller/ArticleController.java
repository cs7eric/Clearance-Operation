package com.cccs7.co.controller;

import com.cccs7.co.bean.entity.Article;
import com.cccs7.co.service.ArticleService;
import com.cccs7.web.bean.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p> ArticleController </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description ArticleController
 * @Date 2023/10/9 10:43
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @GetMapping
    public Result<Article> getArticleById(@RequestParam String id){
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException("not null of id");
        }
        Article article = articleService.getArticleById(id);
        System.out.println(article);
        return Result.ok(article);
    }

    @GetMapping("/all")
    public Result<List<Article>> getAllArticle(){
        List<Article> allArticles = articleService.getAllArticles();
        return Result.ok(allArticles);
    }

}
