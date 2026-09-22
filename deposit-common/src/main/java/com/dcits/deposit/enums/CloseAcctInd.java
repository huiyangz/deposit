package com.dcits.deposit.enums;

/** 销户标志 */
public enum CloseAcctInd {
    /** 是 */
    Y("Y"),
    /** 否 */
    N("N");

    private String value;

    private CloseAcctInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CloseAcctInd byValue(String value) {
        for (CloseAcctInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}