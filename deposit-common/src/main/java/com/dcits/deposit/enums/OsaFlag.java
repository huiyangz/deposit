package com.dcits.deposit.enums;

/** 离岸标记 */
public enum OsaFlag {
    /** inland(本地) */
    Y("Y"),
    /** offshore(离岸) */
    N("N");

    private String value;

    private OsaFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OsaFlag byValue(String value) {
        for (OsaFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}