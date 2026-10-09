package com.dcits.depsit.enums;

/** 透支方式 */
public enum OdMethod {
    /** 正常还款 */
    VALUE_1("1"),
    /** 随借随还 */
    VALUE_2("2");

    private String value;

    private OdMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OdMethod byValue(String value) {
        for (OdMethod item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}