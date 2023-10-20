package com.cccs7.co.service;

import com.cccs7.co.bean.dto.IssueDTO;
import com.cccs7.co.bean.po.Issue;

import java.util.List;

/**
 * <p> 问题接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 问题接口
 * @Date 2023/10/19 10:28
 */
public interface IssueService {


    /**
     * 获取单个问题信息
     *
     * @param id id
     * @return {@link Issue}
     */
    Issue getIssue(String id);

    /**
     * 获取问题集
     *
     * @return {@link List}<{@link Issue}>
     */
    List<Issue> getIssues();

    /**
     * 更新问题
     *
     * @param issueDTO 问题Dto
     */
    void updateIssue(IssueDTO issueDTO);

    /**
     * 删除问题
     *
     * @param issueDTO 问题Dto
     */
    void deleteIssue(IssueDTO issueDTO);

    /**
     * 创建问题
     *
     * @param issueDTO 问题Dto
     */
    void createIssue(IssueDTO issueDTO);


}
