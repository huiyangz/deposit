package com.dcits.deposit.enums;

/** 账套 */
public enum BusinessUnit {
    /** 综合人民币账套 */
    CBT("CBT"),
    /** 原币账套 */
    YBT("YBT"),
    /** 综合美元账套 */
    UBT("UBT"),
    /** 外币折人民币 */
    OCT("OCT");

    private String value;

    private BusinessUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BusinessUnit byValue(String value) {
        for (BusinessUnit item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}