package com.cccs7.co.service.impl;

import com.cccs7.co.bean.dto.IssueDTO;
import com.cccs7.co.bean.po.Issue;
import com.cccs7.co.service.IssueService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 问题接口实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 问题接口实现类
 * @Date 2023/10/19 10:28
 */
@Service
public class IssueServiceImpl implements IssueService {

    /**
     * 问题状态: 已完成
     */
    public static final String ISSUE_STATUS_FULFILLED = "fulfilled";

    /**
     * 问题状态: 正在进行中
     */
    public static final String ISSUE_STATUS_PROCEEDING = "proceeding";

    @Override
    public Issue getIssue(String id) {
        return null;
    }

    @Override
    public List<Issue> getIssues() {
        return null;
    }

    @Override
    public void updateIssue(IssueDTO issueDTO) {

    }

    @Override
    public void deleteIssue(IssueDTO issueDTO) {

    }

    @Override
    public void createIssue(IssueDTO issueDTO) {

    }
}
