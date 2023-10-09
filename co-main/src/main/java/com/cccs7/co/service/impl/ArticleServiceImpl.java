package com.cccs7.co.service.impl;

import com.cccs7.co.bean.entity.Article;
import com.cccs7.co.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 文章服务接口实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 文章服务接口实现类
 * @Date 2023/10/9 10:53
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void createArticle(Article article) {

    }

    @Override
    public Article getArticleById(String id) {

        return mongoTemplate.findById(id, Article.class);
    }

    @Override
    public List<Article> getAllArticles() {

        return mongoTemplate.findAll(Article.class);
    }

    @Override
    public void deleteArticleById(String id) {

    }

    @Override
    public void updateArticleById(Article article) {

    }

    @Override
    public List<Article> searchArticlesWithKey(String keyword) {
        return null;
    }

    @Override
    public List<Article> getArticlesByCategory(String category) {
        return null;
    }
}
