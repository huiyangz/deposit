package com.dcits.deposit.enums;

/** 借贷方控制标志 */
public enum DrCrCtlFlag {
    /** 禁止借贷方 */
    A("A"),
    /** 禁止贷方 */
    C("C"),
    /** 禁止借方 */
    D("D");

    private String value;

    private DrCrCtlFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DrCrCtlFlag byValue(String value) {
        for (DrCrCtlFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}