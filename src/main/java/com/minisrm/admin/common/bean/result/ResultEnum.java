package com.minisrm.admin.common.bean.result;

/**
 * 公用错误码类
 * 0: 表示成功
 * >0: 表示已知异常
 * <0: 表示未知异常
 *
 * @author 513416
 * @create 2018-03-08 14:55
 **/
public enum ResultEnum implements CodeInterface {

    SUCCESS("0", "success"),
    UNKNOWN_EXCEPTION("-100", "未知异常"),
    SQL_EXCEPTION("1000", "SQL异常"),
    NULL_DATA("2000", "数据为空"),
    EMPTY_REQ_BODY("3000", "请求参数为空"),
    INVALID_FIELD("4000"),
    REQUEST_EXCEPTION("9999"),
    ;

    private String resultCode;
    private String resultMsg;

    ResultEnum(String resultCode) {
        this.resultCode = resultCode;
    }

    ResultEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    @Override
    public String getCode() {
        return this.getResultCode();
    }

    @Override
    public String getMsg() {
        return this.getResultMsg();
    }
}
