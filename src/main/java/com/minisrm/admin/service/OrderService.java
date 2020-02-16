package com.minisrm.admin.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.minisrm.admin.common.bean.result.Result;
import com.minisrm.admin.common.page.QueryMap;
import com.minisrm.admin.model.Order;
import com.minisrm.admin.model.Test;
import com.minisrm.admin.model.User;

import java.util.List;
import java.util.Map;

public interface OrderService {

    Result<PageInfo<Order>> listByPage(QueryMap<Order> queryMap);

    List<Order> selectList(Map<String, Object> condition, String orderBy);

    List<Order> selectAll();

    void save(Order order);

    void edit(Order order);

    Order findBy(Long id);
}
