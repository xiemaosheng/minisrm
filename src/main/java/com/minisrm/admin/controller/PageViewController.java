package com.minisrm.admin.controller;

import com.minisrm.admin.model.Order;
import com.minisrm.admin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageViewController extends BaseController {
    @Autowired
    private OrderService orderService;

    /**
     * 下单 所有页面 0
     *
     * @return
     */
    @RequestMapping(value = "/make/order/all/html", method = RequestMethod.GET)
    public String all() {
        return "module/order/order_mk_all";
    }

    /**
     * 未下单  对应状态 0
     *
     * @return
     */
    @RequestMapping(value = "/make/order/un/html", method = RequestMethod.GET)
    public String un() {
        return "module/order/order_mk_un";
    }

    /**
     * 待签收 2
     *
     * @return
     */
    @RequestMapping(value = "/make/order/waitSigned/html", method = RequestMethod.GET)
    public String waitSigned() {
        return "module/order/order_mk_waitSigned";
    }

    /**
     * 待上评 3
     *
     * @return
     */
    @RequestMapping(value = "/make/order/waitReview/html", method = RequestMethod.GET)
    public String waitReview() {
        return "module/order/order_mk_waitReview";
    }

    /**
     * 新增订单 0
     *
     * @return
     */
    @RequestMapping(value = "/rec/order/new/html", method = RequestMethod.GET)
    public String add() {
        return "module/order/order_new";
    }

    /**
     * 未分配  先不做
     *
     * @return
     */
    @RequestMapping(value = "/rec/order/unabsorbed/html", method = RequestMethod.GET)
    public String unabsorbed() {
        return "module/order/order_unabsorbed";
    }

    /**
     * 待反馈(已下单) 1
     *
     * @return
     */
    @RequestMapping(value = "/rec/order/waitReply/ordered/html", method = RequestMethod.GET)
    public String waitReplyOrdered() {
        return "module/order/order_waitReply_ordered";
    }

    /**
     * 待反馈(已上评) 4
     *
     * @return
     */
    @RequestMapping(value = "/rec/order/waitReply/reviewed/html", method = RequestMethod.GET)
    public String waitReplyReviewed() {
        return "module/order/order_waitReply_reviewed";
    }

    /**
     * 待收款 5
     *
     * @return
     */
    @RequestMapping(value = "/rec/order/waitPayment/html", method = RequestMethod.GET)
    public String waitPayment() {
        return "module/order/order_waitPayment";
    }

    /**
     * 已收款 6
     *
     * @return
     */
    @RequestMapping(value = "/rec/order/payed/html", method = RequestMethod.GET)
    public String payed() {
        return "module/order/order_payed";
    }


    /**
     * 编辑订单页面
     *
     * @return
     */
    @RequestMapping(value = "/make/order/edit/{id}", method = RequestMethod.GET)
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
        return  "module/order/order_mk_edit";
    }
}
