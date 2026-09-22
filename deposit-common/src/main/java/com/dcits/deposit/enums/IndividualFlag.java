package com.dcits.deposit.enums;

/** 通用标志 */
public enum IndividualFlag {
    /** 是 */
    Y("Y"),
    /** 否 */
    N("N");

    private String value;

    private IndividualFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IndividualFlag byValue(String value) {
        for (IndividualFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}