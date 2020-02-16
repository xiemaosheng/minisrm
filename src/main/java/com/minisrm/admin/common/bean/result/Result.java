package com.minisrm.admin.common.bean.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 出参对象
 *
 * @author 513416
 * @create 2018-01-19 16:34
 **/
public class Result<T> implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(Result.class);

    private static final long serialVersionUID = 4694973520095978119L;

    private String code;
    private String message;
    private T data;
    private Boolean status;

    public Result() {
        super();
    }

    public Result(T data) {
        this(ResultEnum.SUCCESS.getResultCode(), ResultEnum.SUCCESS.getResultMsg(), data, true);
    }

    public Result(CodeInterface codeInterface) {
        this(codeInterface.getCode(), codeInterface.getMsg(), null, null);
    }

    public Result(CodeInterface codeInterface, T data) {
        this(codeInterface.getCode(), codeInterface.getMsg(), data, null);
    }

    public Result(Throwable e) {
        this(ResultEnum.UNKNOWN_EXCEPTION.getResultCode(), e.toString(), null, null);
    }

    public Result(CodeInterface codeInterface, Throwable e) {
        this(codeInterface.getCode(), codeInterface.getMsg(), null, null);
        log.error("返回异常：", e);
    }

	/*public Result(String code, String msg) {
		this(code, msg, null, null);
	}*/

    public Result(CodeInterface codeInterface, String msg) {
        this(codeInterface.getCode(), msg, null, null);
    }

    public Result(String code, String message, T data, Boolean status) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.status = status;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}