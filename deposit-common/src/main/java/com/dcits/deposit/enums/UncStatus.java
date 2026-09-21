package com.dcits.deposit.enums;

/** 平盘状态 */
public enum UncStatus {
    /** 未平盘 */
    N("N"),
    /** 系统内平盘 */
    P("P"),
    /** 市场平盘 */
    M("M");

    private String value;

    private UncStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UncStatus byValue(String value) {
        for (UncStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}