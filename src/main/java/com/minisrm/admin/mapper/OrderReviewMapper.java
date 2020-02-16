package com.minisrm.admin.mapper;

import com.minisrm.admin.model.Order;
import com.minisrm.admin.model.OrderReview;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Map;

public interface OrderReviewMapper extends BaseMapper<OrderReview> {
    int save(OrderReview orderReview);
}
