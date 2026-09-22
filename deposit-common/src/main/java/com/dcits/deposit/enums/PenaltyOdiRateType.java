package com.dcits.deposit.enums;

/** 罚息利率使用方式 */
public enum PenaltyOdiRateType {
    /** 罚息和利息复利的利率同时采用利息复利的利率参数 */
    I("I"),
    /** 罚息和利息复利的利率分别采用各自的利率参数 */
    P("P");

    private String value;

    private PenaltyOdiRateType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PenaltyOdiRateType byValue(String value) {
        for (PenaltyOdiRateType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}