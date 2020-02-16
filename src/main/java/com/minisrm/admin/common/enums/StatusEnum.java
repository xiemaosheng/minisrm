package com.minisrm.admin.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum StatusEnum {

    DELETED("-1", "删除"),

    ENABLED("1", "启用"),

    DISABLED("0", "禁用"),

    ALL("2", "全部");

    private String code;

    private String text;

    private static Map<String, StatusEnum> map;

    static {
        map = new HashMap<>();
        for (StatusEnum item : StatusEnum.values()) {
            map.put(item.getCode(), item);
        }
    }

    private StatusEnum(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static StatusEnum get(String code) {
        return map.get(code);
    }

    public static StatusEnum[] valuesForDisplay() {
        return new StatusEnum[]{ENABLED, DISABLED};
    }

    public static StatusEnum[] valuesForProduct() {
        return new StatusEnum[]{DISABLED, ALL};
    }

}
