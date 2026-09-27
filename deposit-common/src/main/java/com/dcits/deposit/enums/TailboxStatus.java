package com.dcits.deposit.enums;

/** 尾箱状态 */
public enum TailboxStatus {
    /** 已封存 */
    D("D"),
    /** 未使用 */
    N("N"),
    /** 已删除 */
    X("X"),
    /** 已使用 */
    Y("Y");

    private String value;

    private TailboxStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TailboxStatus byValue(String value) {
        for (TailboxStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}