package com.minisrm.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.minisrm.admin.common.page.PageBuilder;
import com.minisrm.admin.common.page.PageInfoBT;
import com.minisrm.admin.common.page.QueryMap;
import com.minisrm.admin.controller.tip.ErrorTip;
import com.minisrm.admin.controller.tip.SuccessTip;
import com.minisrm.admin.controller.tip.Tip;
import com.minisrm.admin.model.Role;
import com.minisrm.admin.model.User;
import com.minisrm.admin.service.RoleService;
import com.minisrm.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    private final static String PREFIX = "module/admin";

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/html/index", method = RequestMethod.GET)
    public String index() {
        return PREFIX + "/admin_list";
    }

    @RequestMapping(value = "/html/add", method = RequestMethod.GET)
    public String addPage(Model model) {
        List<Role> roles = roleService.selectAll();
        model.addAttribute("roleList", roles);
        return PREFIX + "/admin_add";
    }

    @RequestMapping(value = "/html/edit", method = RequestMethod.GET)
    public String editPage(Model model) {
        List<Role> roles = roleService.selectAll();
        model.addAttribute("roleList", roles);
        return PREFIX + "/admin_edit";
    }

    @RequestMapping(value = "/list/selectByPage", method = RequestMethod.POST)
    @ResponseBody
    public Object selectByPage(User condition) {
        QueryMap<User> queryMap = PageBuilder.buildQueryMap();
        queryMap.setEntity(condition);
        PageInfo<User> pageInfo = userService.listByPage(queryMap).getData();
        JSONObject object = JSON.parseObject(JSON.toJSONString(new PageInfoBT<>(pageInfo)));
        return object;
    }

    @RequestMapping(value = "/list/save", method = RequestMethod.POST)
    @ResponseBody
    public Tip save(User condition) {
        condition.setCreateTime(new Date());
        condition.setUpdateTime(new Date());
        condition.setUserStatus(1);
        userService.save(condition);
        return new SuccessTip();
    }

    @RequestMapping(value = "/list/edit", method = RequestMethod.POST)
    @ResponseBody
    public Tip edit(User condition) {
        condition.setUpdateTime(new Date());
        return new SuccessTip();
    }

    @RequestMapping(value = "/list/user/updateUserStatus", method = RequestMethod.POST)
    @ResponseBody
    public Tip updateUserStatus(User condition) {
        if (ObjectUtils.isEmpty(condition)) {
            return new ErrorTip(400, "参数为空");
        }

        if (ObjectUtils.isEmpty(condition.getId())) {
            return new ErrorTip(400, "请选择用户");
        }

        userService.updateStatus(condition.getId(), condition.getUserStatus());

        return new SuccessTip();
    }

    @RequestMapping(value = "/list/user/delete", method = RequestMethod.POST)
    @ResponseBody
    public Tip delete(User condition) {
        if (ObjectUtils.isEmpty(condition)) {
            return new ErrorTip(400, "参数为空");
        }

        if (ObjectUtils.isEmpty(condition.getId())) {
            return new ErrorTip(400, "请选择用户");
        }
        userService.deleteById(condition.getId());
        return new SuccessTip();
    }
}
