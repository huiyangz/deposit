package com.dcits.deposit.enums;

/** 核准件类型 */
public enum ApprType {
    /** 无限额 */
    VALUE_11("11"),
    /** 余额限额 */
    VALUE_12("12"),
    /** 贷方流入限额 */
    VALUE_13("13");

    private String value;

    private ApprType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ApprType byValue(String value) {
        for (ApprType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}