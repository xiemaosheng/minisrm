package com.minisrm.admin.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalErrorController implements ErrorController{
    
    private static final String ERROR_PATH = "/error"; 
    
    @RequestMapping(path=ERROR_PATH)
    private String error(HttpServletRequest request, HttpServletResponse response, Model model){
        model.addAttribute("statusCode", response.getStatus());
        model.addAttribute("requestUrl", request.getRequestURL());
        return "/error.html";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
    
}
