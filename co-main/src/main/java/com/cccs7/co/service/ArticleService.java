package com.cccs7.co.service;

import com.cccs7.co.bean.dto.ArticleDTO;
import com.cccs7.co.bean.po.Article;

import java.util.List;

/**
 * <p> 文章服务接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 文章服务接口
 * @Date 2023/10/9 10:51
 */
public interface ArticleService {

    /**
     * 创建文章
     *
     * @param articleDTO 文章Dto
     */
    void createArticle (ArticleDTO articleDTO);

    /**
     * 按id获取文章
     *
     * @param id id
     * @return {@link Article}
     */
    Article getArticleById (String id);


    /**
     * 获取所有文章
     *
     * @return {@link List}<{@link Article}>
     */
    List<Article> getAllArticles();


    /**
     * 按id删除
     *
     * @param id id
     */
    void deleteArticleById(String id);

    /**
     * 按id更新文章
     *
     * @param article 文章
     */
    void updateArticleById (Article article);

    /**
     * 按关键字搜索文章
     *
     * @param keyword 关键字
     * @return {@link List}<{@link Article}>
     */
    List<Article> searchArticlesWithKey(String keyword);


    /**
     * 按类别获取文章
     *
     * @param category 类别
     * @return {@link List}<{@link Article}>
     */
    List<Article> getArticlesByCategory(String category);

    /**
     * 获取问题回答文章列表
     *
     * @param id id
     * @return {@link List}<{@link Article}>
     */
    List<Article> getIssueAnswers(String id);
}
