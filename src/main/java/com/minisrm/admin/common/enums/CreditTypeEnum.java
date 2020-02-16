package com.minisrm.admin.common.enums;

/**
 * @Description:
 * @Auther: 536375
 * @Date: 2018/5/22 10:59
 */
public enum CreditTypeEnum {
    SC("SC", "现金分期"),
    SF("SF", "商城消费分期"),
    SP("SP", "场景现金分期"),
    SQ("SQ", "常规取现分期"),
    SS("SS", "消费分期");

    private String type;

    private String text;


    CreditTypeEnum(String type) {
        this.type = type;
    }

    CreditTypeEnum(String type, String text) {
        this.type = type;
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static CreditTypeEnum[] valuesForCreditType() {
        return new CreditTypeEnum[]{SC, SF, SP, SQ, SS};
    }
}
