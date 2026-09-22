package com.dcits.deposit.enums;

/** 结汇资金形态 */
public enum ExchangeAmountType {
    /** 账户资金 */
    VALUE_1("1"),
    /** 外币现钞 */
    VALUE_0("0");

    private String value;

    private ExchangeAmountType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExchangeAmountType byValue(String value) {
        for (ExchangeAmountType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}