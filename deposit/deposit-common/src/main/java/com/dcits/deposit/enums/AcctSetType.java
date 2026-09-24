package com.dcits.deposit.enums;

/** 账套类型 */
public enum AcctSetType {
    /** 综合人民币账套 */
    CBT("CBT"),
    /** 外币折人民币账套 */
    OCT("OCT"),
    /** 综合美元账套 */
    UBT("UBT"),
    /** 原币账套 */
    YBT("YBT");

    private String value;

    private AcctSetType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcctSetType byValue(String value) {
        for (AcctSetType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}