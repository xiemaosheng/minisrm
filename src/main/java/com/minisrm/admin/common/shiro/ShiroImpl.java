package com.minisrm.admin.common.shiro;

import com.minisrm.admin.common.bean.sso.UserInfo;
import com.minisrm.admin.common.util.SpringUtil;
import com.minisrm.admin.mapper.MenuMapper;
import com.minisrm.admin.mapper.RoleMapper;
import com.minisrm.admin.mapper.UserMapper;
import com.minisrm.admin.model.Menu;
import com.minisrm.admin.model.Role;
import com.minisrm.admin.model.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * shiro实现
 *
 * @author 520475
 */
@Service
@DependsOn("springUtil")
public class ShiroImpl implements Shiro {

    private Logger logger = LoggerFactory.getLogger(ShiroImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    public static Shiro me() {
        return SpringUtil.getBean(Shiro.class);
    }

    @Override
    public UserInfo loginUser(String username, String password) throws Exception {
        User user = userMapper.getLoginUser(username, password);
        if (ObjectUtils.isEmpty(user)) {
            logger.error("获取用户信息失败: ");
            throw new AuthenticationException("获取用户信息失败");
        }
        return getLoginUser(user);
    }

    public UserInfo getLoginUser(User user) throws Exception {
        Role role = roleMapper.getRoleById(user.getId());
        UserInfo base = new UserInfo();
        if (!ObjectUtils.isEmpty(role)) {
            base.setRoleId(role.getId() + "");
            base.setRoleName(role.getRoleName());
            base.setUserId(user.getId());
            base.setUserName(user.getUserName());
            base.setRoleStatus(1);
            base.setStatus(1);
            base.setWorkerType(user.getWorkerType());
        }
        return base;
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, String credentials, String realmName) {
        Collection<Object> user = new ArrayList<>();
        user.add(shiroUser);
        user.add(shiroUser.getId());
        return new SimpleAuthenticationInfo(user, credentials, realmName);
    }

    public ShiroUser shiroUser(UserInfo user) throws Exception {
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setId(user.getUserId());
        shiroUser.setDeptName(user.getRoleName());
        shiroUser.setName(user.getUserName());
        List<String> roleList = new ArrayList<String>();
        List<String> roleNameList = new ArrayList<String>();
        roleList.add(user.getRoleId());
        roleNameList.add(user.getRoleName());
        shiroUser.setRoleList(roleList);
        shiroUser.setRoleNames(roleNameList);
        shiroUser.setToken(user.getToken());
        shiroUser.setWorkerType(user.getWorkerType());


        List<Menu> menuList = menuMapper.getMenuListById(user.getUserId());

        Map<Long, List<Menu>> menuMap = new HashMap<>();
        Set<String> permissionSet = new HashSet<String>();
        if (!ObjectUtils.isEmpty(menuList)) {
            for (Menu menu : menuList) {
                if (!StringUtils.isEmpty(menu.getUrl())) {
                    permissionSet.add(menu.getUrl());
                }

                if (!ObjectUtils.isEmpty(menu.getPid()) && 0 != menu.getPid()) {
                    if (menuMap.containsKey(menu.getPid())) {
                        List<Menu> tempList = menuMap.get(menu.getPid());
                        tempList.add(menu);
                        menuMap.put(menu.getPid(), tempList);
                    } else {
                        List<Menu> subMenuList = new ArrayList<>();
                        subMenuList.add(menu);
                        menuMap.put(menu.getPid(), subMenuList);
                    }
                }
            }
        }

        List<Menu> list = new ArrayList<>();
        if (!ObjectUtils.isEmpty(menuList)) {
            for (Menu menu : menuList) {
                if (menuMap.containsKey(menu.getId())) {
                    menu.setSubMenuList(menuMap.get(menu.getId()));
                }
                if (menu.getLevel() == 0) {
                    list.add(menu);
                }
            }
        }
        shiroUser.setPermission(permissionSet);
        shiroUser.setMenus(list);
        return shiroUser;
    }

}
