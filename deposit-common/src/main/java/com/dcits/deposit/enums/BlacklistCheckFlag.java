package com.dcits.deposit.enums;

/** 名单检查标志 */
public enum BlacklistCheckFlag {
    /** 是 */
    Y("Y"),
    /** 否 */
    N("N");

    private String value;

    private BlacklistCheckFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BlacklistCheckFlag byValue(String value) {
        for (BlacklistCheckFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}