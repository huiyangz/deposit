package com.dcits.deposit.enums;

/** 代理类型 */
public enum CommissionFlag {
    /** 否 */
    VALUE_0("0"),
    /** 监护代理 */
    VALUE_1("1"),
    /** 普通代理 */
    VALUE_2("2");

    private String value;

    private CommissionFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CommissionFlag byValue(String value) {
        for (CommissionFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}