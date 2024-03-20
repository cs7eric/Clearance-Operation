package com.cccs7.co.bean.po.article;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * 问题
 * <p> 问题实体类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 问题实体类
 * @Date 2023/10/19 10:18
 */
@Data
@Getter
@Setter
@Document(collection = "issues")
public class Issue {

    @Id
    private String id;

    private String title;

    private String detailContent;

    private String expectContent;

    private String authorId;

    private Date createTime;

    private String status;

    private Integer replyNum;

    private Integer focusNum;

    private Date updateTime;

    private List<String> tags;


}
