package com.minisrm.admin.service;

import com.minisrm.admin.model.OrderReview;

public interface OrderReviewService {
    int save(OrderReview orderReview);

    void updateByCondition(OrderReview orderReview);

    Long countByOrderId(Long orderId);
}
