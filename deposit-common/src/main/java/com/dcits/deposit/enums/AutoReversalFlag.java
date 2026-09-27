package com.dcits.deposit.enums;

/** 自动冲正标志 */
public enum AutoReversalFlag {
    /** 是 */
    Y("Y"),
    /** 否 */
    N("N");

    private String value;

    private AutoReversalFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AutoReversalFlag byValue(String value) {
        for (AutoReversalFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}