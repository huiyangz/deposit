package com.dcits.deposit.enums;

/** 利率分段方式 */
public enum RateLayerRule {
    /** 按金额分档 */
    A("A"),
    /** 不分档 */
    N("N"),
    /** 按期限分档 */
    P("P");

    private String value;

    private RateLayerRule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RateLayerRule byValue(String value) {
        for (RateLayerRule item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}