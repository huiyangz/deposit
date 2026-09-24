package com.dcits.deposit.enums;

/** 介质标志 */
public enum MediumFlag {
    /** 有介质 */
    Y("Y"),
    /** 无介质 */
    N("N");

    private String value;

    private MediumFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MediumFlag byValue(String value) {
        for (MediumFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}