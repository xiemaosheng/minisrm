package com.minisrm.admin.exception;

public enum BizException {
    
    PARAM_ERROR(500, "参数错误"),
    
    SERVICE_REQ_ERROR(501, "服务请求失败");
    
    private Integer code; 
    
    private String message;
    
    private BizException(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

}
