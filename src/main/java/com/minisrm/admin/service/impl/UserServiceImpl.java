package com.minisrm.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.minisrm.admin.common.bean.result.Result;
import com.minisrm.admin.common.page.PageModel;
import com.minisrm.admin.common.page.QueryMap;
import com.minisrm.admin.mapper.UserMapper;
import com.minisrm.admin.mapper.UserRoleMapper;
import com.minisrm.admin.model.User;
import com.minisrm.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Result<PageInfo<User>> listByPage(QueryMap<User> queryMap) {
        PageModel page = queryMap.getPage();
        PageHelper.startPage(page);
        User user = queryMap.getEntity();
        List<User> list = new ArrayList<>();
        list = userMapper.selectList(user, page.getOrderBy());
        return new Result<>(new PageInfo<>(list));
    }

    @Override
    public List<User> selectList(User user, String orderBy) {
        return userMapper.selectList(user, orderBy);
    }

    @Override
    public User getLoginUser(String userName, String password) {
        return userMapper.getLoginUser(userName, password);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public Long count(User condition) {
        return userMapper.count(condition);
    }

    @Override
    @Transactional
    public void save(User user) {
        if (userMapper.save(user) > 0) {
            Long userId = user.getId();
            if (null != userId) {
                userRoleMapper.insertUserRole(userId, user.getRoleId());
            }
        }
    }

    @Override
    public void updateStatus(Long userId, Integer status) {
        userMapper.updateStatus(userId, status);
    }

    @Override
    public void deleteById(Long userId) {
        userMapper.deleteById(userId);
    }
}
