package com.minisrm.admin.common.enums;

/**
 * @Description:
 * @Auther: 536375
 * @Date: 2018/5/19 14:12
 */
public enum OperatorEnum {
    /**
     * 编辑
     */
    EDIT(0),
    /**
     * 删除
     */
    DELETE(1),
    /**
     * 导入
     */
    IMPORT(2),
    /**
     * 新增
     */
    SAVE(3);

    private int operator;

    OperatorEnum(int operator) {
        this.operator = operator;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }
}
