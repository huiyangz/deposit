package com.dcits.deposit.enums;

/** 约定转存方式 */
public enum RenewType {
    /** 保底金额+固定金额 */
    COM("COM"),
    /** 固定金额 */
    LIM("LIM"),
    /** 保底金额 */
    MAX("MAX"),
    /** 实时转账 */
    RAL("RAL"),
    /** 余额比例 */
    RAT("RAT");

    private String value;

    private RenewType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RenewType byValue(String value) {
        for (RenewType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}