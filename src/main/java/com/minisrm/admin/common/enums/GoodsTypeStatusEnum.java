package com.minisrm.admin.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: 536375
 * @Date: 2018/5/29 14:45
 */
public enum GoodsTypeStatusEnum {

    ENABLED("0", "启用"),

    DISABLED("-1", "禁用"),

    ALL("2", "全部");

    private String code;

    private String text;

    private static Map<String, GoodsTypeStatusEnum> map;

    static {
        map = new HashMap<>();
        for (GoodsTypeStatusEnum item : GoodsTypeStatusEnum.values()) {
            map.put(item.getCode(), item);
        }
    }

    private GoodsTypeStatusEnum(String code, String text) {
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

    public static GoodsTypeStatusEnum get(String code) {
        return map.get(code);
    }

    public static GoodsTypeStatusEnum[] valuesForDisplay() {
        return new GoodsTypeStatusEnum[]{ENABLED, DISABLED};
    }

}
