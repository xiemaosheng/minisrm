package com.minisrm.admin.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: 536375
 * @Date: 2018/5/31 17:14
 */
public enum AddSeriesEnum {
    TEST_01("TEST_01", "安心宝"),
    TEST_02("TEST_02", "阳光伴侣"),
    TEST_03("TEST_03", "意外保障"),
    TEST_04("TEST_04", "全面保"),
    TEST_05("TEST_05", "碎碎屏安"),
    TEST_06("TEST_06", "百宝箱");
    private String code;

    private String text;

    private static Map<String, AddSeriesEnum> map;

    static {
        map = new HashMap<>();
        for (AddSeriesEnum item : AddSeriesEnum.values()) {
            map.put(item.getCode(), item);
        }
    }

    AddSeriesEnum(String code, String text) {
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

    public static AddSeriesEnum get(String code) {
        return map.get(code);
    }

    public static AddSeriesEnum[] valuesForAddedSeries() {
        return new AddSeriesEnum[]{TEST_01, TEST_02, TEST_03, TEST_03, TEST_04, TEST_05, TEST_06};
    }
}
