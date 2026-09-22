package com.dcits.deposit.enums;

/** 客户标识 */
public enum ClientIndicator {
    /** 银行员工客户 */
    S("S"),
    /** 普通客户 */
    N("N"),
    /** 潜在客户 */
    M("M"),
    /** VIP客户 */
    V("V");

    private String value;

    private ClientIndicator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ClientIndicator byValue(String value) {
        for (ClientIndicator item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}