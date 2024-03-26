package com.cccs7.co.bean.dto.common;

import com.cccs7.co.bean.po.article.Category;
import lombok.Data;

import java.util.Date;

/**
 * <p> 分页请求DTO </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 分页请求DTO
 * @Date 2024/3/26 22:58
 */
@Data
public class PageRequestDTO {

    private Integer pageSize;

    private Integer pageNum;

    private Date beginTime;

    private Date endTime;

    private Category category;
}
