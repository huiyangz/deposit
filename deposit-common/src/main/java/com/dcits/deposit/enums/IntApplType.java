package com.dcits.deposit.enums;

/** 利率启用方式 */
public enum IntApplType {
    /** 随基准利率变更 */
    A("A"),
    /** 浮动不随基准利率变更 */
    F("F"),
    /** 不变更 */
    N("N"),
    /** 按周期变更 */
    R("R"),
    /** 按计息变更 */
    S("S");

    private String value;

    private IntApplType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IntApplType byValue(String value) {
        for (IntApplType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}