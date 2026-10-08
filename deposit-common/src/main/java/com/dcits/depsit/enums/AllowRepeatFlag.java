package com.dcits.depsit.enums;

/** 允许重复增加标志 */
public enum AllowRepeatFlag {
    /** N */
    N("N"),
    /** Y */
    Y("Y");

    private String value;

    private AllowRepeatFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AllowRepeatFlag byValue(String value) {
        for (AllowRepeatFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}