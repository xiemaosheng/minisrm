package com.minisrm.admin.common.shiro;

import com.minisrm.admin.model.Menu;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * user对象
 *
 * @author 520475
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id; // 主键ID
    public String name; // 姓名
    public List<String> roleList; // 角色集
    public String deptName; // 部门名称
    public List<String> roleNames; // 角色名称集

    public Set<String> permission;

    private String token;

    public List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }

    public Set<String> getPermission() {
        return permission;
    }

    public void setPermission(Set<String> permission) {
        this.permission = permission;
    }

}
