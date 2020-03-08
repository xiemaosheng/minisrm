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
        list = userMapper.selectList(user,
                (page.getPageNum() - 1) * page.getPageSize(),
                page.getPageSize(), page.getOrderBy());
        Long count = userMapper.countTotal(user);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        pageInfo.setTotal(count);
        return new Result<>(pageInfo);
    }

    @Override
    public List<User> selectList(User user, int offset, int limit, String orderBy) {
        return userMapper.selectList(user, offset, limit, orderBy);
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
    public Long countTotal(User condition) {
        return userMapper.countTotal(condition);
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
