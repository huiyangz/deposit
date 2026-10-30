package com.dcits.deposit.enums;

/** 账户交易标志 */
public enum AcctTranFlag {
    /** 非账户交易 */
    M("M"),
    /** 账户交易 */
    T("T");

    private String value;

    private AcctTranFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcctTranFlag byValue(String value) {
        for (AcctTranFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}