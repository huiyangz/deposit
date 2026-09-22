package com.dcits.deposit.enums;

/** 透支模式 */
public enum OdMode {
    /** 法透贷 */
    VALUE_0("0"),
    /** 余额透 */
    VALUE_1("1");

    private String value;

    private OdMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OdMode byValue(String value) {
        for (OdMode item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}