package com.minisrm.admin.common.web;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 */
@ControllerAdvice
public class GlobalWebExceptionHandler {

    private Logger log = Logger.getLogger(this.getClass());

//    /**
//     * 用户未登录
//     *
//     * @author fengshuonan
//     */
//    @ExceptionHandler(AuthenticationException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ResponseBody
//    public Tip unAuth(AuthenticationException e) {
//        log.info("用户未登陆：", e);
//        return new ErrorTip(501, "用户未登陆");
//    }
//
//    /**
//     * 账号密码错误
//     *
//     * @author fengshuonan
//     */
//    @ExceptionHandler(CredentialsException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ResponseBody
//    public Tip credentials(CredentialsException e) {
//        log.info("账号密码错误");
//        return new ErrorTip(502, "账号密码错误");
//    }
//
//    @ExceptionHandler(UnknownAccountException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ResponseBody
//    public Tip credentials(UnknownAccountException e) {
//        String errmsg = e.getMessage();
//        log.info(errmsg);
//        return new ErrorTip(509, errmsg);
//    }
//
//    /**
//     * 验证码错误
//     *
//     * @author fengshuonan
//     */
//    @ExceptionHandler(InvalidKaptchaException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public Tip credentials(InvalidKaptchaException e) {
//        log.info("验证码错误");
//        return new ErrorTip(503, "验证码错误");
//    }
//
//    /**
//     * 无权访问该资源
//     *
//     * @author fengshuonan
//     */
//    @ExceptionHandler(UndeclaredThrowableException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ResponseBody
//    public ErrorTip credentials(UndeclaredThrowableException e) {
//        log.info("权限异常!", e);
//        return new ErrorTip(403, "无权访问该资源");
//    }
//
//    /**
//     * 拦截未知的运行时异常
//     *
//     * @author fengshuonan
//     */
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public ErrorTip notFount(RuntimeException e) {
//        log.info("运行时异常:", e);
//        return new ErrorTip(500, "未知的运行时异常");
//    }
//
//    /**
//     * session失效的异常拦截
//     *
//     * @author stylefeng
//     * @Date 2017/6/7 21:02
//     */
//    @ExceptionHandler(InvalidSessionException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String sessionTimeout(InvalidSessionException e, Model model, HttpServletRequest request, HttpServletResponse response) {
//        model.addAttribute("tips", "请重新登录");
//        assertAjax(request, response);
//        return "/login.html";
//    }
//
//    /**
//     * session异常
//     *
//     * @author stylefeng
//     * @Date 2017/6/7 21:02
//     */
//    @ExceptionHandler(UnknownSessionException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String sessionTimeout(UnknownSessionException e, Model model, HttpServletRequest request, HttpServletResponse response) {
//        model.addAttribute("tips", "请重新登录");
//        assertAjax(request, response);
//        return "/login.html";
//    }
//
//    private void assertAjax(HttpServletRequest request, HttpServletResponse response) {
//        if (request.getHeader("x-requested-with") != null
//                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
//            //如果是ajax请求响应头会有，x-requested-with
//            response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
//        }
//    }

}
