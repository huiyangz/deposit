package com.dcits.deposit.enums;

/** 月基准 */
public enum MonthBasis {
    /** 按实际天数 */
    ACT("ACT"),
    /** 按30天 */
    D30("D30");

    private String value;

    private MonthBasis(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MonthBasis byValue(String value) {
        for (MonthBasis item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}