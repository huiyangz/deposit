package com.dcits.deposit.enums;

/** 挂销账标志 */
public enum HangWriteOffFlag {
    /** 是 */
    Y("Y"),
    /** 否 */
    N("N");

    private String value;

    private HangWriteOffFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HangWriteOffFlag byValue(String value) {
        for (HangWriteOffFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}