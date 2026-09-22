package com.dcits.deposit.enums;

/** 计息标识 */
public enum IntIndFlag {
    /** 否 */
    N("N"),
    /** 是(负利率计息) */
    F("F"),
    /** 是(正利率计息) */
    Y("Y");

    private String value;

    private IntIndFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IntIndFlag byValue(String value) {
        for (IntIndFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}