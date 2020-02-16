
package com.minisrm.admin.common.page;



import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    private List<T> entities;

    private int pageCount;

    private int pageIndex = 1;

    private int pageSize = 10;

    private int totalCount;
    
    public static <T> Page<T> convert(PageInfo<T> pageInfo) {
        Page<T> page = new Page<>();
        page.setEntities(pageInfo.getList());
        page.setPageCount(pageInfo.getPages());
        page.setPageIndex(pageInfo.getPageNum());
        page.setTotalCount(Long.valueOf(pageInfo.getTotal()).intValue());
        page.setPageSize(pageInfo.getPageSize());
        return page;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
