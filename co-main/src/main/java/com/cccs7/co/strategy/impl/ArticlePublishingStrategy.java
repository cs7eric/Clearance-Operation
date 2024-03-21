package com.cccs7.co.strategy.impl;

import com.cccs7.co.bean.po.article.Article;
import com.cccs7.co.bean.po.article.ArticleInfo;
import com.cccs7.co.strategy.PublishingStrategy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p> 文章发布服务策略实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 文章发布服务策略实现类
 * @Date 2023/10/20 13:50
 */
@Component
public class ArticlePublishingStrategy implements PublishingStrategy {



    @Override
    public void publish(Article article, MongoTemplate mongoTemplate) {
        article.setPublishTime(new Date());
        article.setStatus(ArticleInfo.ARTICLE_STATUS_PUBLISHED);
        article.setLikes(0);
        article.setReplyNum(0);
        article.setCategory("");
        article.setArticleType(ArticleInfo.PUBLISH_TYPE_ARTICLE);
        System.out.println(article);
        mongoTemplate.save(article);
    }
}
