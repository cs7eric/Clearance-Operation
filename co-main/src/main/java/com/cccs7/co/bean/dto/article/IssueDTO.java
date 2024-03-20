package com.cccs7.co.bean.dto.article;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * <p> 问题DTO </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 问题DTO
 * @Date 2023/10/19 10:19
 */

@Data
@Getter
@Setter
public class IssueDTO {

    private String id;

    private String title;

    private String detailContent;

    private String expectContent;

    private String authorId;

    private Date createTime;

    private List<String> tags;

    private String status;

    private Integer replyNum;

    private Integer focusNum;

    private Date updateTime;



}
