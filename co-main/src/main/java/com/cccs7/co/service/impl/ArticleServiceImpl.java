package com.cccs7.co.service.impl;

import com.cccs7.co.bean.dto.ArticleDTO;
import com.cccs7.co.bean.po.Article;
import com.cccs7.co.bean.po.ArticleInfo;
import com.cccs7.co.convert.ArticleConverter;
import com.cccs7.co.factory.PublishingStrategyFactory;
import com.cccs7.co.service.ArticleService;
import com.cccs7.co.service.strategies.PublishingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public void createArticle(ArticleDTO articleDTO) {

        Article article = ArticleConverter.INSTANCE.dto2po(articleDTO);
        // 创建发布策略工厂
        PublishingStrategyFactory strategyFactory = new PublishingStrategyFactory();
        // 获取文章类型
        String articleType = article.getArticleType();
        // 根据文章类型创建发布策略
        PublishingStrategy strategy = strategyFactory.createStrategy(articleType);
        // 发布文章
        strategy.publish(article, mongoTemplate);
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
        mongoTemplate.save(article);
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
