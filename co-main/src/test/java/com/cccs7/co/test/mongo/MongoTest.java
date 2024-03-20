package com.cccs7.co.test.mongo;

import com.cccs7.co.bean.po.article.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * <p> Mongo 测试类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description Mongo 测试类
 * @Date 2023/10/20 22:32
 */
@SpringBootTest
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testMongo() {

        Article article = new Article();
        //为article一些属性赋值
        article.setArticleType("article");
        article.setReplyNum(1);
        mongoTemplate.save(article);


    }
}
