package com.dcits.deposit.enums;

/** 挂账状态 */
public enum HangStatus {
    /** 部分挂账 */
    B("B"),
    /** 销账 */
    C("C"),
    /** 挂账 */
    H("H"),
    /** 冲正 */
    R("R"),
    /** 已销账 */
    W("W");

    private String value;

    private HangStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HangStatus byValue(String value) {
        for (HangStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}