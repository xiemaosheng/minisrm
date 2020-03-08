package com.minisrm.admin.service.impl;

import com.minisrm.admin.mapper.OrderReviewMapper;
import com.minisrm.admin.model.OrderReview;
import com.minisrm.admin.service.OrderReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderReviewServiceImpl implements OrderReviewService {
    @Autowired
    private OrderReviewMapper orderReviewMapper;

    @Override
    public int save(OrderReview orderReview) {
        return orderReviewMapper.save(orderReview);
    }

    @Override
    public void updateByCondition(OrderReview orderReview) {
        orderReviewMapper.updateByCondition(orderReview);
    }

    @Override
    public Long countByOrderId(Long orderId) {
        return orderReviewMapper.countByOrderId(orderId);
    }
}
