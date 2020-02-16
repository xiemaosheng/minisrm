package com.minisrm.admin.common.page;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageInfoBT<T> {

    private List<T> rows;

    private long total;

    private String code;

    public PageInfoBT(List<T> result) {
        this.rows = result;
        this.total = result.size();
    }

    public PageInfoBT(PageInfo<T> pageInfo) {
        if (pageInfo != null) {
            this.rows = pageInfo.getList();
            this.total = pageInfo.getTotal();
            this.code = "200";
        }
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
