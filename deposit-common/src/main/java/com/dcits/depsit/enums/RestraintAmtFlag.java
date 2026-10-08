package com.dcits.depsit.enums;

/** 指定限制金额标志 */
public enum RestraintAmtFlag {
    /** N */
    N("N"),
    /** Y */
    Y("Y");

    private String value;

    private RestraintAmtFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RestraintAmtFlag byValue(String value) {
        for (RestraintAmtFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}