package com.cccs7.co.strategy;

import com.cccs7.co.bean.po.article.Article;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * <p> 发布服务策略接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 发布服务策略接口
 * @Date 2023/10/20 13:47
 */
public interface PublishingStrategy {

    /**
     * 发布服务
     *
     * @param article       文章
     * @param mongoTemplate
     */
    void publish(Article article,  MongoTemplate mongoTemplate);
}
