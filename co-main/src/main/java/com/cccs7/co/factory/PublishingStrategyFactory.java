package com.cccs7.co.factory;

import com.cccs7.co.bean.po.article.ArticleInfo;
import com.cccs7.co.strategy.impl.ArticlePublishingStrategy;
import com.cccs7.co.strategy.impl.IssueAnswerStrategy;
import com.cccs7.co.strategy.PublishingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * <p> 发布服务工厂类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 发布服务工厂类
 * @Date 2023/10/20 13:53
 */
@Component
public class PublishingStrategyFactory {


    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建策略
     *
     * @param articleType 文章类型
     * @return {@link PublishingStrategy}
     */
    public PublishingStrategy createStrategy(String articleType) {
        if (ArticleInfo.PUBLISH_TYPE_ARTICLE.equalsIgnoreCase(articleType)) {
            return new ArticlePublishingStrategy();
        } else if (ArticleInfo.PUBLISH_TYPE_ANSWER.equalsIgnoreCase(articleType)) {
            return new IssueAnswerStrategy();
        } else {
            throw new IllegalArgumentException("Invalid article type");
        }
    }
}
