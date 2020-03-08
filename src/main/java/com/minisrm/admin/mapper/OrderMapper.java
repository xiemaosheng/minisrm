package com.minisrm.admin.mapper;

import com.minisrm.admin.model.Order;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Map;

public interface OrderMapper extends BaseMapper<Order> {

    int save(@Param("condition") Order order);

    int edit(@Param("condition") Order order);

    /**
     * 查询列表
     *
     * @param condition
     * @return
     */
    List<Order> selectList(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy);

    List<Order> selectAll();

    Order findById(@Param("id") Long id);

    void updateStatus(@Param("id") Long id, @Param("status") Long status);

    void updateByCondition(@Param("condition") Order order);
}
