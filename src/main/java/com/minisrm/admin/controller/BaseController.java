package com.minisrm.admin.controller;

public class BaseController {
    
    protected static String REDIRECT = "redirect:";
    protected static String FORWARD = "forward:";
    
    //TODO 使用工具类获取
    public String getIp() {
        return "0.0.0.0";
    }
    
    //TODO 待修改 getUser()
    public Integer getCurrentUserId() {
        return 100000;
    }

}
