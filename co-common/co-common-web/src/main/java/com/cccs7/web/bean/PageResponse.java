package com.cccs7.web.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页响应类
 * @param <T> 分页结果的数据类型
 */
@Data
public class PageResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    private Long pageNo = 1L; // 当前页码，默认为1

    /**
     *  每页显示的记录数，默认为10
     */
    private Long pageSize = 10L;

    /**
     *  总记录数
     */
    private Long total = 0L;

    /**
     * 总页
     */
    private Long totalPages = 0L;

    /**
     * 分页结果集合
     */
    private List<T> result = Collections.emptyList();

    /**
     * 当前页起始记录位置
     */
    private Long start = 1L;

    /**
     * 当前页结束记录位置
     */
    private Long end = 0L;

    /**
     * 设置分页结果集合
     * @param result 分页结果集合
     */
    public void setRecords(List<T> result) {
        this.result = result;
        if (result != null && !result.isEmpty() && this.total == 0) {
            setTotal((long) result.size()); // 如果总记录数为0且结果集不为空，则将总记录数设置为结果集的大小
        }
    }

    /**
     * 设置每页显示的记录数
     * @param pageSize 每页显示的记录数
     */
    public void setPageSize(Long pageSize) {
        if (pageSize != null && pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    /**
     * 设置当前页码
     * @param pageNo 当前页码
     */
    public void setCurrent(Long pageNo) {
        if (pageNo != null && pageNo > 0) {
            this.pageNo = pageNo;
        }
    }

    /**
     * 设置总记录数，并计算总页数、当前页起始位置和结束位置
     * @param total 总记录数
     */
    public void setTotal(Long total) {
        this.total = total;
        if (total == -1) {
            this.pageNo = 1L;
            return;
        }
        if (this.pageSize > 0) {
            this.totalPages = (total / this.pageSize) + (total % this.pageSize == 0 ? 0 : 1);
        } else {
            this.totalPages = 0L;
        }

        this.start = (this.pageNo > 0 ? (this.pageNo - 1) * this.pageSize : 0) + 1;
        this.end = (this.start - 1 + this.pageSize * (this.pageNo > 0 ? 1 : 0));
    }
}