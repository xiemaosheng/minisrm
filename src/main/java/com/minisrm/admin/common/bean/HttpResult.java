package com.minisrm.admin.common.bean;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;

/**
 * http请求结果
 * @author 520475
 * @since 2017年12月11日
 */
public class HttpResult {
    
    /**
     * 返回码，-1为失败
     */
    private int statusCode = -1;
    
    /**
     * 返回头信息
     */
    private Header[] headers;
    
    /**
     * 返回数据体
     */
    private byte[] body;
    
    public HttpResult(){}
    
    public HttpResult(int statusCode, Header[] headers, byte[] body){
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
    }
    
    public boolean ok() {
        return this.statusCode == 200;
    }
    
    public String getContentString() {
        return getContentString("UTF-8");
    }
    
    public String getContentString(String charset) {
        try {
            return new String(body, charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

}
