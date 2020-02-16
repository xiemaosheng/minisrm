package com.minisrm.admin.mapper;

import com.minisrm.admin.model.Menu;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询列表
     *
     * @param menu
     * @return
     */
    List<Menu> selectList(@Param("condition") Menu menu, @Param("orderBy") String orderBy);

    List<Menu> getMenuListById(@Param("userId") Long userId);

    List<Menu> selectAll();
}
