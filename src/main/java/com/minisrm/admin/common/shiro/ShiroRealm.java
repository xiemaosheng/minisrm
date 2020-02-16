package com.minisrm.admin.common.shiro;

import com.minisrm.admin.common.bean.sso.UserInfo;
import com.minisrm.admin.mapper.UserMapper;
import com.minisrm.admin.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * shiro 认证实现
 *
 * @author 520475
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        Shiro shiroFactory = ShiroImpl.me();
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        String password = new String(token.getPassword());
        User user = null;
        try {
            user = userMapper.getLoginUser(username, password);
            System.out.println("user:" + username);
//            HttpResult result = HttpUtil.get(ssoProperties.getTokenUrl(username, password));
//            if (result.ok()) {
//                tokenStr = result.getContentString();
//            } else {
//                throw new Exception("请求失败code=" + result.getStatusCode());
//            }
        } catch (Exception e) {
            throw new UnknownAccountException("获取用户Token失败，" + e.getMessage());
        }
//        /*if (tokens == null) {
//
//        }*/
        UserInfo userInfo = null;
        try {
            userInfo = shiroFactory.getLoginUser(user);
        } catch (Exception e) {
            throw new UnknownAccountException("获取用户信息失败，" + e.getMessage());
        }

        SimpleAuthenticationInfo info = null;
        try {
            ShiroUser shiroUser = shiroFactory.shiroUser(userInfo);
            info = shiroFactory.info(shiroUser, password, super.getName());
        } catch (Exception e) {
            throw new UnknownAccountException("登录失败，" + e.getMessage());
        }
        return info;
    }

    /**
     * 权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(shiroUser.getPermission());
        info.addRoles(shiroUser.getRoleNames());
        return info;
    }

}
