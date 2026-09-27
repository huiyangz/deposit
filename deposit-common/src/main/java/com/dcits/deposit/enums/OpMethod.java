package com.dcits.deposit.enums;

/** 操作方式 */
public enum OpMethod {
    /** 手工 */
    O("O"),
    /** 系统自动 */
    B("B");

    private String value;

    private OpMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OpMethod byValue(String value) {
        for (OpMethod item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}