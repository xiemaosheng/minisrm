package com.minisrm.admin.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 产品类枚举数据
 * @Auther: 536375
 * @Date: 2018/5/9 10:24
 */
public enum ProductEnum {

    /**
     * 客户类型枚举 1：学生线下产品   2：非学生产品   3：特殊产品(还款方式前低后高)  4：零息产品  5：学生产品线上   6：交叉贷非学生  7：交叉贷学生  9-线上合作产品
     */
    PROD_TYPE_1("1", "学生线下产品"),

    PROD_TYPE_2("2", "非学生产品"),

    PROD_TYPE_3("3", "特殊产品(还款方式前低后高)"),

    PROD_TYPE_4("4", "零息产品"),

    PROD_TYPE_5("5", "学生产品线上"),

    PROD_TYPE_6("6", "交叉贷非学生"),

    PROD_TYPE_7("7", "交叉贷学生"),

    /**
     * 还款期数
     */
    PAYMENT_NUM_3("3", "3"),
    PAYMENT_NUM_6("6", "6"),
    PAYMENT_NUM_9("9", "9"),
    PAYMENT_NUM_12("12", "12"),
    PAYMENT_NUM_15("15", "15"),
    PAYMENT_NUM_18("18", "18"),
    PAYMENT_NUM_24("24", "24"),

    /**
     * 最低贷本
     */
    CREDIT_FROM_1("1000", "1000"),
    CREDIT_FROM_2("3501", "3501"),


    /**
     * 最高贷本
     */
    CREDIT_TO_1("3500", "3500"),
    CREDIT_TO_2("4000", "4000"),
    CREDIT_TO_3("6000", "6000"),
    CREDIT_TO_4("8000", "8000"),
    CREDIT_TO_5("9000", "9000");


    private String code;

    private String text;

    private static Map<String, ProductEnum> map;

    static {
        map = new HashMap<>();
        for (ProductEnum item : ProductEnum.values()) {
            map.put(item.getCode(), item);
        }
    }

    ProductEnum(String code, String text) {
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

    public static ProductEnum get(String code) {
        return map.get(code);
    }

    public static ProductEnum[] valuesForProdType() {
        return new ProductEnum[]{PROD_TYPE_2, PROD_TYPE_3,PROD_TYPE_6};
    }

    public static ProductEnum[] valuesForPaymentNum() {
        return new ProductEnum[]{PAYMENT_NUM_3, PAYMENT_NUM_6,PAYMENT_NUM_9,PAYMENT_NUM_12,PAYMENT_NUM_15,PAYMENT_NUM_18,PAYMENT_NUM_24};
    }

    public static ProductEnum[] valuesForCreditFrom() {
        return new ProductEnum[]{CREDIT_FROM_1, CREDIT_FROM_2};
    }

    public static ProductEnum[] valuesForCreditTo() {
        return new ProductEnum[]{CREDIT_TO_1, CREDIT_TO_2,CREDIT_TO_3,CREDIT_TO_4,CREDIT_TO_5};
    }
}
