package com.dcits.deposit.enums;

/** 冲正和抹账标识 */
public enum WipeAccount {
    /** 抹账 */
    Y("Y"),
    /** 冲正 */
    N("N");

    private String value;

    private WipeAccount(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static WipeAccount byValue(String value) {
        for (WipeAccount item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}