package com.minisrm.admin.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImportResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private String message;
    
    private int total;
    
    private int successed;
    
    private int failed;

    private ImportError error;
    
    public ImportResult() {
        this(200, "导入成功");
    }
    
    public ImportResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ImportError getError() {
        return error;
    }

    public void setError(ImportError error) {
        this.error = error;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSuccessed() {
        return successed;
    }

    public void setSuccessed(int successed) {
        this.successed = successed;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }



    public static class ImportError extends HashMap<String, List<String>> {

        private static final long serialVersionUID = 1L;

        public void addMessage(String rowIndex, String message) {
            List<String> rowList = new ArrayList<String>();
            if (containsKey(rowIndex)) {
                rowList = get(rowIndex);
            }
            rowList.add(message);
            put(rowIndex, rowList);
        }

        public List<String> getRowMessageList() {
            return null;
        }

        public String getRowMessage(String sperator) {
            return null;
        }
    }

}
