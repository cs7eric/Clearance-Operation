package com.cccs7.co.convert;

import com.cccs7.co.bean.dto.ArticleDTO;
import com.cccs7.co.bean.po.Article;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

/**
 * <p> Article实体映射 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description Article实体映射
 * @Date 2023/10/13 23:20
 */
@Mapper(componentModel = "spring")
public interface ArticleConverter {

    ArticleConverter INSTANCE = Mappers.getMapper(ArticleConverter.class);

    /**
     * 将 ArticleDTO 转换为 Article
     *
     * @param articleDTO 文章Dto
     * @return {@link Article}
     */
    Article dto2po(ArticleDTO articleDTO);

    /**
     * 将 Article 转换为 ArticleDTO
     *
     * @param article 文章
     * @return {@link ArticleDTO}
     */
    ArticleDTO po2dto(Article article);
}
