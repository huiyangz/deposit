package com.dcits.deposit.enums;

/** 账户性质 */
public enum AcctProperty2 {
    /** 投融资类 */
    T("T"),
    /** 结算类 */
    J("J");

    private String value;

    private AcctProperty2(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcctProperty2 byValue(String value) {
        for (AcctProperty2 item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}