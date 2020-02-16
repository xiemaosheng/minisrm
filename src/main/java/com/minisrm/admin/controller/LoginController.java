package com.minisrm.admin.controller;

import com.google.code.kaptcha.Constants;
import com.minisrm.admin.common.shiro.ShiroKit;
import com.minisrm.admin.common.shiro.ShiroUser;
import com.minisrm.admin.config.properties.AppProperties;
import com.minisrm.admin.controller.tip.ErrorTip;
import com.minisrm.admin.controller.tip.SuccessTip;
import com.minisrm.admin.controller.tip.Tip;
import com.minisrm.admin.model.Menu;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Properties;

@Controller
public class LoginController extends BaseController {

    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AppProperties appProperties;


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        ShiroUser user = ShiroKit.getUser();

        if (user != null) {
            if (user.getId() == null) {
                return "login";
            }
            List<Menu> menus = user.getMenus();
            model.addAttribute("menus", menus);
            model.addAttribute("userName", user.getName());
            model.addAttribute("userId", user.getId());
            model.addAttribute("userRole", user.getRoleList().get(0));
        } else {
            return "login";
        }

        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        if (ShiroKit.isAuthenticated() || ShiroKit.getUser() != null) {
            return REDIRECT + "/";
        } else {
            model.addAttribute("kaptchaFlag", appProperties.getKaptchaOpen());
            return "login";
        }
    }

    /**
     * 点击登录执行的动作
     */
    @RequestMapping(value = "/dologin")
    @ResponseBody
    public Tip dologin(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //验证验证码是否正确
        if (appProperties.getKaptchaOpen()) {
            String kaptcha = request.getParameter("kaptcha");
            String code = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (StringUtils.isEmpty(kaptcha)) {
                return new ErrorTip(400, "没有填写验证码");
            }
            if (!kaptcha.equals(code)) {
                return new ErrorTip(400, "验证码不对");
            }
        }

        Subject currentUser = ShiroKit.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
        } catch (Exception e) {
            return new ErrorTip(400, "用户名或者密码不正确");
        }


        ShiroUser shiroUser = ShiroKit.getUser();
        request.getSession().setAttribute("shiroUser", shiroUser);
        request.getSession().setAttribute("userName", shiroUser.getName());

        ShiroKit.getSession().setAttribute("sessionFlag", true);

        log.info("用户{}登录成功", ShiroKit.getUser().getId());

        return new SuccessTip();
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) throws Exception {
        Properties headers = new Properties();
        headers.setProperty("Authorization", "Bearer " + ShiroKit.getUser().getToken());
        ShiroKit.getSubject().logout();
        model.addAttribute("kaptchaFlag", appProperties.getKaptchaOpen());
        return "login";
    }

    @RequestMapping(value = "/invalid", method = RequestMethod.GET)
    public String sessionInvalid() {
        return "invalid";
    }

}
