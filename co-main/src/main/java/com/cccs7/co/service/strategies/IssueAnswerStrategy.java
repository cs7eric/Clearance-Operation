package com.cccs7.co.service.strategies;

import com.cccs7.co.bean.po.Article;
import com.cccs7.co.bean.po.ArticleInfo;
import com.cccs7.co.bean.po.Issue;
import com.cccs7.co.service.ArticleService;
import com.cccs7.co.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoAction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    @Autowired
    private IssueService issueService;

    @Override
    public void publish(Article article, MongoTemplate mongoTemplate) {

        //初始化回答基本数据
        setBaseInfo(article);
        //更新问题信息
        String issueId = article.getIssueId();
        Query query = new Query(Criteria.where("id").is(issueId));
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true);
        Update update = new Update().inc("replyNum", 1);
        mongoTemplate.findAndModify(query, update, options, Issue.class);

        mongoTemplate.save(article);
    }


    public void setBaseInfo (Article article) {
        article.setPublishTime(new Date());
        article.setStatus(ArticleInfo.ARTICLE_STATUS_PUBLISHED);
        article.setLikes(0);
        article.setReplyNum(0);
        article.setCategory("");
    }
}
