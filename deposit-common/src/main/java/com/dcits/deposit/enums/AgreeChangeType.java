package com.dcits.deposit.enums;

/** 协议变动方式 */
public enum AgreeChangeType {
    /** 基准利率浮动 */
    B("B"),
    /** 行内利率浮动 */
    A("A"),
    /** 执行利率浮动 */
    R("R");

    private String value;

    private AgreeChangeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AgreeChangeType byValue(String value) {
        for (AgreeChangeType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}