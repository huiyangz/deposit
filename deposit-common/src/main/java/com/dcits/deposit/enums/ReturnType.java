package com.dcits.deposit.enums;

/** 退回方式 */
public enum ReturnType {
    /** 转账 */
    VALUE_2("2"),
    /** 现金 */
    VALUE_1("1"),
    /** 销挂账 */
    VALUE_3("3");

    private String value;

    private ReturnType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ReturnType byValue(String value) {
        for (ReturnType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}