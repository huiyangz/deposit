package com.dcits.deposit.enums;

/** 允许冲正标志 */
public enum AllowReverseFlag {
    /** 是 */
    Y("Y"),
    /** 否 */
    N("N");

    private String value;

    private AllowReverseFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AllowReverseFlag byValue(String value) {
        for (AllowReverseFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}