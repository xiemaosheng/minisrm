package com.minisrm.admin.controller.tip;

import com.minisrm.admin.exception.BizException;

public class ErrorTip extends Tip {

    public ErrorTip() {
        super.code = 400;
        super.message = "操作失败";
    }

    public ErrorTip(BizException bizException) {
        super();
        this.code = bizException.getCode();
        this.message = bizException.getMessage();
    }

    public ErrorTip(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

}
