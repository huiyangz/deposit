package com.dcits.deposit.enums;

/** 余额标志 */
public enum BalanceFlag {
    /** 账面余额 */
    L("L"),
    /** 不校验余额/否 */
    N("N"),
    /** 实际余额 */
    B("B"),
    /** 是 */
    Y("Y");

    private String value;

    private BalanceFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BalanceFlag byValue(String value) {
        for (BalanceFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}