package com.dcits.deposit.enums;

/** 余额更新类型 */
public enum BalUpdType {
    /** 实时更新 */
    R("R"),
    /** 定时更新但不检查余额 */
    N("N"),
    /** 定时更新且检查余额 */
    T("T");

    private String value;

    private BalUpdType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BalUpdType byValue(String value) {
        for (BalUpdType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}