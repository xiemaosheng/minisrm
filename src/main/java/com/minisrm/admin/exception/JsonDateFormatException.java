package com.minisrm.admin.exception;

/**
 * json日期格式化异常
 * @author 520475
 * @since 2018年3月30日
 */
public class JsonDateFormatException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public JsonDateFormatException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public JsonDateFormatException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public JsonDateFormatException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
    
}
