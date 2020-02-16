package com.minisrm.admin.common.shiro;

import com.minisrm.admin.common.bean.sso.UserInfo;
import com.minisrm.admin.model.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

/**
 * shiro接口
 *
 * @author 520475
 */
public interface Shiro {

    UserInfo loginUser(String username, String password) throws Exception;

    ShiroUser shiroUser(UserInfo user) throws Exception;

    UserInfo getLoginUser(User user) throws Exception;

    SimpleAuthenticationInfo info(ShiroUser shiroUser, String credentials, String name) throws Exception;

}
