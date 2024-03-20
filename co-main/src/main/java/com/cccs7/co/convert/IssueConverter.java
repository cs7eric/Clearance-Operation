package com.cccs7.co.convert;

import com.cccs7.co.bean.dto.article.IssueDTO;
import com.cccs7.co.bean.po.article.Issue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <p> Issue实体映射器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description Issue实体映射器
 * @Date 2023/10/19 10:25
 */
@Mapper
public interface IssueConverter {

    IssueConverter INSTANCE = Mappers.getMapper(IssueConverter.class);

    /**
     * dto2po
     *
     * @param issueDTO 问题Dto
     * @return {@link Issue}
     */
    Issue dto2po(IssueDTO issueDTO);


    /**
     * po2dto
     *
     * @param issue 问题
     * @return {@link IssueDTO}
     */
    IssueDTO po2dto(Issue issue);
}
