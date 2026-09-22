package com.dcits.deposit.enums;

/** 账户资金用途 */
public enum FundAcctPurpose {
    /** 本金账户 */
    VALUE_2("2"),
    /** 利息账户 */
    VALUE_3("3"),
    /** 本息账户 */
    VALUE_1("1");

    private String value;

    private FundAcctPurpose(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FundAcctPurpose byValue(String value) {
        for (FundAcctPurpose item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}