package com.dcits.deposit.enums;

/** 牌价类型 */
public enum QuoteType {
    /** 直接 */
    D("D"),
    /** 间接 */
    I("I");

    private String value;

    private QuoteType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static QuoteType byValue(String value) {
        for (QuoteType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}