package com.minisrm.admin.mapper;

import com.minisrm.admin.model.UserRole;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

public interface UserRoleMapper extends BaseMapper<UserRole> {

    int insertUserRole(@Param("userId") Long userId, @Param("roleId")Long roleId);
}
