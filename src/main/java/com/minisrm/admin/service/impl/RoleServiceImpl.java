package com.minisrm.admin.service.impl;

import com.minisrm.admin.mapper.RoleMapper;
import com.minisrm.admin.model.Role;
import com.minisrm.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectList(Role role, String orderBy) {
        return roleMapper.selectList(role, orderBy);
    }

    @Override
    public Role getRoleById(Long userId) {
        return roleMapper.getRoleById(userId);
    }

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }
}
