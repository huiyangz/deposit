package com.dcits.deposit.enums;

/** 报价方式 */
public enum BaseQuoteType {
    /** 直接 */
    D("D"),
    /** 间接 */
    I("I");

    private String value;

    private BaseQuoteType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BaseQuoteType byValue(String value) {
        for (BaseQuoteType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}