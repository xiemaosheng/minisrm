package com.minisrm.admin.service;

import com.minisrm.admin.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> selectList(Role role, String orderBy);

    Role getRoleById(Long userId);

    List<Role> selectAll();
}
