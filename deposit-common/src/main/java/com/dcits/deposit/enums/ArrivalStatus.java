package com.dcits.deposit.enums;

/** 到账状态 */
public enum ArrivalStatus {
    /** 转账 */
    W("W"),
    /** 取消 */
    C("C");

    private String value;

    private ArrivalStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ArrivalStatus byValue(String value) {
        for (ArrivalStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}