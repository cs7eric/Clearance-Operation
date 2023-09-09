package com.cccs7.web.bean;

import lombok.Setter;

/**
 * 分页请求类
 */
@Setter
public class PageRequest {
    private static final Long DEFAULT_PAGE_NO = 1L; // 默认页码为1
    private static final Long DEFAULT_PAGE_SIZE = 10L; // 默认每页显示10条记录

    private Long pageNo = DEFAULT_PAGE_NO; // 当前页码
    private Long pageSize = DEFAULT_PAGE_SIZE; // 每页显示的记录数

    /**
     * 获取页码，如果页码为空或小于1，则返回默认页码
     *
     * @return 页码
     */
    public Long getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return DEFAULT_PAGE_NO;
        }
        return pageNo;
    }

    /**
     * 获取每页记录数，如果每页记录数为空、小于1或超过Long类型的最大值，则返回默认每页记录数
     *
     * @return 每页记录数
     */
    public Long getPageSize() {
        if (pageSize == null || pageSize < 1 || pageSize > Long.MAX_VALUE) {
            return DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }
}