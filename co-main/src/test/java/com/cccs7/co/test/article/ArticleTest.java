package com.cccs7.co.test.article;

import com.cccs7.co.bean.dto.article.ArticleDTO;
import com.cccs7.co.bean.po.user.UserArticleAction;
import com.cccs7.co.service.ArticleService;
import com.cccs7.co.service.UserActionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * <p> 文章业务测试类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 文章业务测试类
 * @Date 2023/10/31 10:23
 */
@SpringBootTest
public class ArticleTest {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserActionService userActionService;

    @Test
    public void testGetArticles() {

        ArticleDTO dto = new ArticleDTO();
        dto.setUserId(1712410707829501954L);
        articleService.getAllArticles(dto);
    }

    @Test
    public void testGetAction() {
        List<UserArticleAction> list = userActionService.getArticleListByUserId(1712410707829501954L);
        list.forEach(System.out::println);
    }
}
