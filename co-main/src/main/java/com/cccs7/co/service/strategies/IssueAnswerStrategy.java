package com.cccs7.co.service.strategies;

import com.cccs7.co.bean.po.Article;
import com.cccs7.co.bean.po.ArticleInfo;
import com.cccs7.co.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoAction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p> 问题回答服务策略实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 问题回答服务策略实现类
 * @Date 2023/10/20 13:51
 */
@Component
public class IssueAnswerStrategy implements PublishingStrategy{


    @Override
    public void publish(Article article, MongoTemplate mongoTemplate) {
        article.setPublishTime(new Date());
        article.setStatus(ArticleInfo.ARTICLE_STATUS_PUBLISHED);
        article.setLikes(0);
        article.setReplyNum(0);
        article.setCategory("");
        mongoTemplate.save(article);
    }
}
