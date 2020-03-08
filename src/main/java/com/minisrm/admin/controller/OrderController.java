package com.minisrm.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.minisrm.admin.common.enums.OrderStatusEnum;
import com.minisrm.admin.common.page.PageBuilder;
import com.minisrm.admin.common.page.PageInfoBT;
import com.minisrm.admin.common.page.QueryMap;
import com.minisrm.admin.common.shiro.ShiroKit;
import com.minisrm.admin.common.shiro.ShiroUser;
import com.minisrm.admin.controller.tip.ErrorTip;
import com.minisrm.admin.controller.tip.SuccessTip;
import com.minisrm.admin.controller.tip.Tip;
import com.minisrm.admin.model.Order;
import com.minisrm.admin.model.User;
import com.minisrm.admin.service.OrderService;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/rec")
public class OrderController extends BaseController {

    private final static String PREFIX = "module/order";

    @Autowired
    private OrderService orderService;

    /**
     * 所有订单页面
     *
     * @return
     */
    @RequestMapping(value = "/order/html/all", method = RequestMethod.GET)
    public String all() {
        return PREFIX + "/order_all";
    }


    /**
     * 所有订单页面
     *
     * @return
     */
    @RequestMapping(value = "/order/html/add", method = RequestMethod.GET)
    public String add(Model model) {
        ShiroUser user = ShiroKit.getUser();
        model.addAttribute("workerType", user.getWorkerType());
        return PREFIX + "/order_add";
    }

    /**
     * 查看订单页面
     *
     * @return
     */
    @RequestMapping(value = "/order/find/{id}", method = RequestMethod.GET)
    public String find(@PathVariable("id") Long id, Model model) {
        Order order = orderService.findBy(id);
        if (ObjectUtils.isEmpty(id)) {
            throw new RuntimeException("订单不存在");
        }

        model.addAttribute("order", order);
        return PREFIX + "/order_find";
    }

    /**
     * 编辑订单页面
     *
     * @return
     */
    @RequestMapping(value = "/order/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model model) {
        Order order = orderService.findBy(id);
        if (ObjectUtils.isEmpty(id)) {
            throw new RuntimeException("订单不存在");
        }

        if ("0".equalsIgnoreCase(order.getCashBackType())) {
            order.setCashBackTypeText("先评后返(上评后返全款)");
        }
        if ("1".equalsIgnoreCase(order.getCashBackType())) {
            order.setCashBackTypeText("先本后佣(下单返本金,留评返佣金)");
        }
        if ("2".equalsIgnoreCase(order.getCashBackType())) {
            order.setCashBackTypeText("PP返款");
        }
        model.addAttribute("order", order);
        return PREFIX + "/order_edit";
    }

    @RequestMapping(value = "/order/all/selectByPage", method = RequestMethod.POST)
    @ResponseBody
    public Object selectByPage(HttpServletRequest request) {
        Order condition = new Order();
        String status = request.getParameter("status");
        if (!StringUtils.isEmpty(status)) {
            condition.setStatus(Long.valueOf(status));
        }
        QueryMap<Order> queryMap = PageBuilder.buildQueryMap();
        queryMap.setEntity(condition);
        PageInfo<Order> pageInfo = orderService.listByPage(queryMap).getData();
        List<Order> orders = pageInfo.getList();
        if (!CollectionUtils.isEmpty(orders)) {
            for (Order order : orders) {
                order.setStatusText(OrderStatusEnum.get(order.getStatus()).getText());
            }
        }
        JSONObject object = JSON.parseObject(JSON.toJSONString(new PageInfoBT<>(pageInfo)));
        return object;
    }

    @RequestMapping(value = "/order/save", method = RequestMethod.POST)
    @ResponseBody
    public Tip save(Order order) {
        if (ObjectUtils.isEmpty(order)) {
            return new ErrorTip(400, "新增失败，数据不能为空");
        }
        order.setStatus(0l);
        orderService.save(order);
        return new SuccessTip();
    }

    @RequestMapping(value = "/order/edit", method = RequestMethod.PUT)
    @ResponseBody
    public Tip edit(Order order) {
        if (ObjectUtils.isEmpty(order) || ObjectUtils.isEmpty(order.getId())) {
            return new ErrorTip(400, "修改失败，数据不能为空");
        }
        orderService.updateByCondition(order);
        return new SuccessTip();
    }

    @RequestMapping(value = "/order/updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Tip updateStatus(Order condition) {
        if (ObjectUtils.isEmpty(condition)) {
            return new ErrorTip(400, "参数为空");
        }

        if (ObjectUtils.isEmpty(condition.getId())) {
            return new ErrorTip(400, "请选择用户");
        }

        orderService.updateStatus(condition.getId(), condition.getStatus());
        return new SuccessTip();
    }

}
