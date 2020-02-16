package com.minisrm.admin.controller.tip;

public class SuccessTip extends Tip{
	
	public SuccessTip(){
		super.code = 200;
		super.message = "操作成功";
	}
	
	public SuccessTip(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
