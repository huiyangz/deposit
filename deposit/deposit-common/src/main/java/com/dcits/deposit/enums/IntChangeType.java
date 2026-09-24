package com.dcits.deposit.enums;

/** 利率启用方式 */
public enum IntChangeType {
    /** 随基准利率变更 */
    A("A"),
    /** 浮动不随基准利率变更 */
    F("F"),
    /** 不变更 */
    N("N"),
    /** 按周期变更 */
    R("R"),
    /** 按计息变更 */
    S("S"),
    /** 随产品 */
    P("P"),
    /** 随账户 */
    Y("Y");

    private String value;

    private IntChangeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IntChangeType byValue(String value) {
        for (IntChangeType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}