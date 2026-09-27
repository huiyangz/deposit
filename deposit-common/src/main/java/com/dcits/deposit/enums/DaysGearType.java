package com.dcits.deposit.enums;

/** 靠档天数计算方式 */
public enum DaysGearType {
    /** 按存期(起息日加存期) */
    A("A"),
    /** 实际天数(起息日开始) */
    B("B"),
    /** 计提天数(上一结息日开始) */
    C("C");

    private String value;

    private DaysGearType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DaysGearType byValue(String value) {
        for (DaysGearType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}