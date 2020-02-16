package com.minisrm.admin.common.page;

import java.io.Serializable;

public class PageModel implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PAGE_NUM = "pageNum";

    public static final String PAGE_SIZE = "pageSize";

    public static final String ORDER_BY = "orderBy";

    private int pageNum = 1;

    private int pageSize = 10;

    private String orderBy;

    public PageModel() {

    }

    public PageModel(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

}
