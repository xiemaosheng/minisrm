package com.minisrm.admin.mapper;

import com.minisrm.admin.model.Test;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface TestMapper extends BaseMapper<Test> {

    /**
     * 查询列表
     *
     * @param test
     * @return
     */
    List<Test> selectList(@Param("condition") Test test, @Param("orderBy") String orderBy);

    List<Test> selectAll();
}
