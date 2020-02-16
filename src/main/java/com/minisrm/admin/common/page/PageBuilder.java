package com.minisrm.admin.common.page;

import com.minisrm.admin.common.web.WafRequestWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


public class PageBuilder {

    public static PageModel build() {
        HttpServletRequest request = getHttpServletRequest();
        int limit = Integer.valueOf(request.getParameter("limit") == null ? "10" : request.getParameter("limit"));
        int offset = Integer.valueOf(request.getParameter("offset") == null ? "0" : request.getParameter("offset"));
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        PageModel page = new PageModel();
        page.setPageNum(offset / limit + 1);
        page.setPageSize(limit);
        if (StringUtils.isNotEmpty(sort)) {
            if ("desc".equalsIgnoreCase(order)) {
                page.setOrderBy(sort + " desc");
            } else {
                page.setOrderBy(sort);
            }
        }
        return page;
    }

    public static <T> QueryMap<T> buildQueryMap() {
        return new QueryMap<T>().setPage(build());
    }

    private static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes requestAttr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return new WafRequestWrapper(requestAttr.getRequest());
    }

}
