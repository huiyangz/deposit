package com.dcits.deposit.enums;

/** 账户面签标志 */
public enum AcctTellerSignFlag {
    /** 已面签 */
    Y("Y"),
    /** 未面签 */
    N("N");

    private String value;

    private AcctTellerSignFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcctTellerSignFlag byValue(String value) {
        for (AcctTellerSignFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}