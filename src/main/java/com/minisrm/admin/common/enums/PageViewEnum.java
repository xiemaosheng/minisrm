package com.minisrm.admin.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: 536375
 * @Date: 2018/5/30 16:34
 */
public enum PageViewEnum {
    FORCED("0", "非强制"),
    NO_FORCED("1", "强制"),
    FORBID_BUY("-1", "不允许购买"),;
    private String code;

    private String text;

    private static Map<String, PageViewEnum> map;

    static {
        map = new HashMap<>();
        for (PageViewEnum item : PageViewEnum.values()) {
            map.put(item.getCode(), item);
        }
    }

    PageViewEnum(String code, String text) {
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

    public static PageViewEnum get(String code) {
        return map.get(code);
    }


    public static PageViewEnum[] valuesForAll() {
        return new PageViewEnum[]{FORCED, NO_FORCED, FORBID_BUY};
    }
}
