package com.minisrm.admin.exception;

/**
 * 业务异常类
 *
 * @author 513416
 * @create 2018-01-25 17:12
 **/
public class ResultBizException extends Exception {

    /**
     * 状态码
     */
    private String code;

    public ResultBizException() {
    }

    public ResultBizException(String msg) {
        super(msg);
    }

    public ResultBizException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public ResultBizException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultBizException(Throwable cause) {
        super(cause);
    }

    public ResultBizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getCode() {
        return code;
    }
}
