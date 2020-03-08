package com.minisrm.admin.service;

import com.github.pagehelper.PageInfo;
import com.minisrm.admin.common.bean.result.Result;
import com.minisrm.admin.common.page.QueryMap;
import com.minisrm.admin.model.User;

import java.util.List;

public interface UserService {

    Result<PageInfo<User>> listByPage(QueryMap<User> queryMap);

    void save(User user);

    List<User> selectList(User user, int offset, int limit, String orderBy);

    User getLoginUser(String userName, String password);

    List<User> selectAll();

    Long countTotal(User condition);

    void updateStatus(Long userId, Integer status);

    void deleteById(Long userId);
}
