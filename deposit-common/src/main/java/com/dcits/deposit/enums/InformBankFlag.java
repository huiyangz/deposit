package com.dcits.deposit.enums;

/** 通知人行标志 */
public enum InformBankFlag {
    /** 是 */
    Y("Y"),
    /** 否 */
    N("N");

    private String value;

    private InformBankFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static InformBankFlag byValue(String value) {
        for (InformBankFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}