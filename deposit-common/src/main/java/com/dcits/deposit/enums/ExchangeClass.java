package com.dcits.deposit.enums;

/** 结售汇申报类型 */
public enum ExchangeClass {
    /** 结汇申请书 */
    HJ("HJ"),
    /** 购汇申请书 */
    HS("HS");

    private String value;

    private ExchangeClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExchangeClass byValue(String value) {
        for (ExchangeClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}