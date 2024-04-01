package com.cccs7.co.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccs7.co.bean.bo.ArticleStatusBO;
import com.cccs7.co.bean.dto.article.ArticleDTO;
import com.cccs7.co.bean.dto.common.PageRequestDTO;
import com.cccs7.co.bean.po.article.Article;
import com.cccs7.co.bean.po.user.User;
import com.cccs7.co.bean.po.user.UserArticleAction;
import com.cccs7.co.convert.ArticleConverter;
import com.cccs7.co.factory.PublishingStrategyFactory;
import com.cccs7.co.mapper.ArticleMapper;
import com.cccs7.co.service.ArticleService;
import com.cccs7.co.service.UserActionService;
import com.cccs7.co.service.UserService;
import com.cccs7.co.strategy.PublishingStrategy;
import com.cccs7.mybatisplus.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> 文章服务接口实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 文章服务接口实现类
 * @Date 2023/10/9 10:53
 */
@Service
public class ArticleServiceImpl
        extends ServiceImpl<ArticleMapper, Article>
        implements ArticleService, IService<Article> {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Lazy
    @Autowired
    private UserActionService userActionService;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserService userService;


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
    public List getAllArticles(ArticleDTO articleDTO) {

        Long userId = articleDTO.getUserId();
        List<Article> articleList = mongoTemplate.findAll(Article.class);

        //如果 当前为未登录状态
        if (userId == null) {
            return articleList;
        }


        List<UserArticleAction> actionArticleList = userActionService.getArticleListByUserId(userId);

        List<ArticleStatusBO> articleStatusList = ArticleStatusBO.fromUserArticleActions(actionArticleList);

        // 用户为登录状态 : 加工文章数据
        return articleList.stream()
                .map(article -> {
                    String articleId = article.getId();
                    ArticleDTO dto = ArticleConverter.INSTANCE.po2dto(article);
                    articleStatusList.forEach(action -> {
                        String tmpArticleId = action.getArticleId();
                        if (tmpArticleId.equals(articleId)) {

                            Boolean isLiked = action.getIsLiked();
                            Boolean isCollected = action.getIsCollected();
                            dto.setIsLiked(isLiked);
                            dto.setIsCollected(isCollected);
                        }
                    });
                    return dto;
                }).collect(Collectors.toList());

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

    @Override
    public List<Article> getIssueAnswers(String issueId) {
        Query query = new Query(Criteria.where("issueId").is(issueId));
        return mongoTemplate.find(query, Article.class);
    }


    @Override
    public List<Article> getArticlesByUsername(String username) {
        //根据用户名查询文章数据
        Query query = new Query(Criteria.where("author").is(username));
        return mongoTemplate.find(query, Article.class);
    }

    @Override
    public List<Article> getArticlesByPage(Integer pageNum, Integer pageSize, String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("author").is(username));
        int skip = (pageNum - 1) * pageSize;
        return mongoTemplate.find(query.skip(skip).limit(pageSize), Article.class);
    }


    @Override
    public Long getCountByUsername(String username) {
        return mongoTemplate.count(new Query().addCriteria(Criteria.where("author").is(username)), Article.class);
    }
}
