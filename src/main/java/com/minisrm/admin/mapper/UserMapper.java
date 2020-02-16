package com.minisrm.admin.mapper;

import com.minisrm.admin.model.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询列表
     *
     * @param user
     * @return
     */
    List<User> selectList(@Param("condition") User user, @Param("orderBy") String orderBy);

    User getLoginUser(@Param("userName") String userName, @Param("password") String password);

    List<User> selectAll();

    Long count(@Param("condition") User user);

    int save(@Param("condition") User user);

    void updateStatus(@Param("userId") Long userId, @Param("status") Integer status);

    void deleteById(@Param("userId") Long userId);
}
