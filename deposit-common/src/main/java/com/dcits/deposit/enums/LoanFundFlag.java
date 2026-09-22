package com.dcits.deposit.enums;

/** 贷款资金管控标志 */
public enum LoanFundFlag {
    /** 管控 */
    Y("Y"),
    /** 不管控 */
    N("N");

    private String value;

    private LoanFundFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static LoanFundFlag byValue(String value) {
        for (LoanFundFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}