package com.minisrm.admin.mapper;

import com.minisrm.admin.model.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 查询列表
     *
     * @param role
     * @return
     */
    List<Role> selectList(@Param("condition") Role role, @Param("orderBy") String orderBy);

    Role getRoleById(@Param("userId") Long userId);

    List<Role> selectAll();
}
