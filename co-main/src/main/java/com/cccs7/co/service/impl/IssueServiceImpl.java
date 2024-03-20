package com.cccs7.co.service.impl;

import com.cccs7.co.bean.dto.article.IssueDTO;
import com.cccs7.co.bean.po.article.Issue;
import com.cccs7.co.convert.IssueConverter;
import com.cccs7.co.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Issue getIssue(String id) {
        Issue issue = mongoTemplate.findById(id, Issue.class);
        return issue;
    }

    @Override
    public List<Issue> getIssues() {
        return null;
    }

    @Override
    public void updateIssue(IssueDTO issueDTO) {
        Issue issue = IssueConverter.INSTANCE.dto2po(issueDTO);
        mongoTemplate.save(issue);
    }

    @Override
    public void deleteIssue(IssueDTO issueDTO) {

    }

    @Override
    public void createIssue(IssueDTO issueDTO) {

    }

    @Override
    public void postIssue(IssueDTO issueDTO) {

        Issue issue = IssueConverter.INSTANCE.dto2po(issueDTO);
        issue.setStatus(ISSUE_STATUS_PROCEEDING);
        issue.setCreateTime(new Date());
        issue.setFocusNum(0);
        issue.setReplyNum(0);
        mongoTemplate.save(issue);
    }


    @Override
    public List<Issue> getAllIssues() {

        List<Issue> issueList = mongoTemplate.findAll(Issue.class);
        return issueList;
    }
}
