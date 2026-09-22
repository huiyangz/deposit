package com.dcits.deposit.enums;

/** 汇率标志 */
public enum FromRateFlag {
    /** 买入汇率 */
    B("B"),
    /** 卖出汇率 */
    S("S"),
    /** 中间汇率 */
    M("M");

    private String value;

    private FromRateFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FromRateFlag byValue(String value) {
        for (FromRateFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}