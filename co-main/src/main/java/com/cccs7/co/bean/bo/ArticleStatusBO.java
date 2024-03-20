package com.cccs7.co.bean.bo;

import com.cccs7.co.bean.po.user.UserArticleAction;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> 文章状态业务类BO </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 文章状态业务类BO
 * @Date 2023/10/30 15:13
 */
@Data
public class ArticleStatusBO {

    private String articleId;
    private Boolean isLiked;
    private Boolean isCollected;

    /**
     * 获取当前文章用户行为状态 （用户文章操作 ： 点赞、收藏）
     *
     * @param dataList 数据列表
     * @return {@link List}<{@link ArticleStatusBO}>
     */
    public static List<ArticleStatusBO> fromUserArticleActions (List<UserArticleAction> dataList) {

        return dataList.stream()
                .map( action -> {
                    ArticleStatusBO articleStatus = new ArticleStatusBO();
                    articleStatus.setArticleId(action.getArticleId());
                    articleStatus.setIsLiked(action.getIsLiked());
                    articleStatus.setIsCollected(action.getIsCollected());
                    return articleStatus;
                })
                .collect(Collectors.toList());
    }
}
