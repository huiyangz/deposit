package com.dcits.deposit.enums;

/** 涉案标识 */
public enum CaseInvolvedFlag {
    /** 涉案 */
    Y("Y"),
    /** 不涉案 */
    N("N");

    private String value;

    private CaseInvolvedFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CaseInvolvedFlag byValue(String value) {
        for (CaseInvolvedFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}