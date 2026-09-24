package com.dcits.deposit.enums;

/** 到账方式 */
public enum TranMethod {
    /** 次日到账 */
    VALUE_2("2"),
    /** 普通到账 */
    VALUE_3("3");

    private String value;

    private TranMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TranMethod byValue(String value) {
        for (TranMethod item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}