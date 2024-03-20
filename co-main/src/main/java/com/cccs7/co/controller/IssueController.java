package com.cccs7.co.controller;

import com.cccs7.co.bean.dto.article.IssueDTO;
import com.cccs7.co.bean.po.article.Issue;
import com.cccs7.co.service.IssueService;
import com.cccs7.web.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p> 问题 controller </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 问题 controller
 * @Date 2023/10/19 10:24
 */

@RestController
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping
    public Result<String> postIssue(@RequestBody IssueDTO issueDTO) {

        issueService.postIssue(issueDTO);
        return Result.ok("success");
    }


    /**
     * 获取所有问题数据
     *
     * @return {@link Result}<{@link List}<{@link Issue}>>
     */
    @GetMapping("/all")
    public Result<List<Issue>> getAllIssues() {
        List<Issue> issueList = issueService.getAllIssues();
        return Result.ok(issueList);
    }

    /**
     * 获取单个问题数据
     *
     * @param id id
     * @return {@link Result}<{@link Issue}>
     */
    @GetMapping("/{id}")
    public Result<Issue> getIssue(@PathVariable String id) {
        Issue issue = issueService.getIssue(id);
        return Result.ok(issue);
    }
}
