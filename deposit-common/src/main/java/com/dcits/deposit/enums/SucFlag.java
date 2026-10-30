package com.dcits.deposit.enums;

/** 社会统一信用代码标志 */
public enum SucFlag {
    /** 是 */
    Y("Y"),
    /** 否 */
    N("N");

    private String value;

    private SucFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SucFlag byValue(String value) {
        for (SucFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}