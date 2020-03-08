package com.minisrm.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.minisrm.admin.common.bean.result.Result;
import com.minisrm.admin.common.page.PageModel;
import com.minisrm.admin.common.page.QueryMap;
import com.minisrm.admin.mapper.OrderMapper;
import com.minisrm.admin.mapper.OrderReviewMapper;
import com.minisrm.admin.model.Order;
import com.minisrm.admin.model.OrderReview;
import com.minisrm.admin.model.User;
import com.minisrm.admin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderReviewMapper orderReviewMapper;


    @Override
    public List<Order> selectList(Map<String, Object> condition, String orderBy) {
        return orderMapper.selectList(condition, orderBy);
    }

    @Override
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public Result<PageInfo<Order>> listByPage(QueryMap<Order> queryMap) {
        PageModel page = queryMap.getPage();
        PageHelper.startPage(page);
        Map<String, Object> map = new HashMap<>();
        map.put("mktName", queryMap.getEntity().getMktName());
        map.put("status", queryMap.getEntity().getStatus());
        List<Order> list = new ArrayList<>();
        list = orderMapper.selectList(map, page.getOrderBy());
        return new Result<>(new PageInfo<>(list));
    }

    @Override
    @Transactional
    public void save(Order order) {
        if (ObjectUtils.isEmpty(order)) {
            return;
        }
        int result = orderMapper.save(order);
        if (result > 0) {
            // todo
            String title = order.getTitle();
            String content = order.getContent();
            if (StringUtils.isEmpty(title) && StringUtils.isEmpty(content)) {
                return;
            } else {
                //
                OrderReview review = new OrderReview();
                review.setTitle(order.getTitle());
                review.setContent(order.getContent());
                review.setCreateTime(new Date());
                review.setOrderId(order.getId());
                review.setReviewDateTime(order.getReviewDateTime());
                review.setReviewImgUrl(order.getReviewImgUrl());
                review.setReviewLinkUrl(order.getReviewLinkUrl());
                review.setReviewJtUrl(order.getReviewJtUrl());
                review.setReviewUserId(order.getReviewUserId());
                review.setReviewUserName(order.getReviewUserName());
                review.setReviewVideoUrl(order.getReviewVideoUrl());
                review.setUpdateTime(new Date());
                orderReviewMapper.save(review);
            }
        }
    }

    @Override
    public void edit(Order order) {
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void updateStatus(long id, long status) {
        orderMapper.updateStatus(id, status);
    }

    @Override
    @Transactional
    public void updateByCondition(Order condition) {
        orderMapper.updateByCondition(condition);
        if (!StringUtils.isEmpty(condition.getTitle()) && StringUtils.isEmpty(condition.getContent())) {
            OrderReview review = new OrderReview();
            review.setTitle(condition.getTitle());
            review.setContent(condition.getContent());
            review.setOrderId(condition.getId());
            review.setReviewDateTime(condition.getReviewDateTime());
            review.setReviewImgUrl(condition.getReviewImgUrl());
            review.setReviewLinkUrl(condition.getReviewLinkUrl());
            review.setReviewJtUrl(condition.getReviewJtUrl());
            review.setReviewUserId(condition.getReviewUserId());
            review.setReviewUserName(condition.getReviewUserName());
            review.setReviewVideoUrl(condition.getReviewVideoUrl());
            review.setUpdateTime(new Date());
            if (orderReviewMapper.countByOrderId(condition.getId()) >= 1) {
                orderReviewMapper.updateByCondition(review);
            } else {
                orderReviewMapper.save(review);
            }

        }
    }

    @Override
    public Order findBy(Long id) {
        return orderMapper.findById(id);
    }
}
