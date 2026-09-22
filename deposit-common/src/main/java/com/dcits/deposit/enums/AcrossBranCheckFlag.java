package com.dcits.deposit.enums;

/** 跨机构检查标志 */
public enum AcrossBranCheckFlag {
    /** 是 */
    Y("Y"),
    /** 否 */
    N("N");

    private String value;

    private AcrossBranCheckFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcrossBranCheckFlag byValue(String value) {
        for (AcrossBranCheckFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}