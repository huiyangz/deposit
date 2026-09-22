package com.dcits.deposit.enums;

/** 基础利率类型 */
public enum BaseRateType {
    /** sofr利率 */
    SOFR("SOFR"),
    /** 普通利率 */
    NORMAL("NORMAL");

    private String value;

    private BaseRateType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BaseRateType byValue(String value) {
        for (BaseRateType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}