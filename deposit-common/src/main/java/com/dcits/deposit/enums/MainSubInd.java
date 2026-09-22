package com.dcits.deposit.enums;

/** 核准件主子标识 */
public enum MainSubInd {
    /** 主 */
    M("M"),
    /** 子 */
    S("S");

    private String value;

    private MainSubInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MainSubInd byValue(String value) {
        for (MainSubInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}