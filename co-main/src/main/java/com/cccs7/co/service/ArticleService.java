package com.cccs7.co.service;

import com.cccs7.co.bean.dto.article.ArticleDTO;
import com.cccs7.co.bean.dto.article.ArticlePageDTO;
import com.cccs7.co.bean.dto.common.PageRequestDTO;
import com.cccs7.co.bean.po.article.Article;
import com.cccs7.mybatisplus.entity.PageResult;
import com.mongodb.lang.Nullable;

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
     * @param articleDTO 文章Dto
     * @return {@link List}<{@link Article}>
     */
    List getAllArticles(ArticleDTO articleDTO);


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

    /**
     * 按用户名获取文章
     *
     * @param username 用户名
     * @return {@link List}<{@link Article}>
     */
    List<Article> getArticlesByUsername(String username);


    /**
     * 得到文章通过分页
     *
     * @param pageNum  当前页数
     * @param pageSize 分页大小
     * @param username 用户名
     * @return {@link PageResult}<{@link Article}>
     */
    PageResult<Article> getArticlesByPage(Integer pageNum, Integer pageSize,@Nullable String username);

    /**
     * 获取某用户的文章总数
     *
     * @param username 用户名
     * @return {@link Long}
     */
    Long getCountByUsername(@Nullable String username);

    /**
     * 模糊查询
     *
     * @param likeKey  模糊key
     * @param pageSize 分页大小
     * @param pageNum  当前页数
     * @return {@link ArticlePageDTO}
     */
    ArticlePageDTO queryFuzzily(Integer pageSize, Integer pageNum, String likeKey);

    }
