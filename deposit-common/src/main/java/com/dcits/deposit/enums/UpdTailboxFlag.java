package com.dcits.deposit.enums;

/** 尾箱更新标志 */
public enum UpdTailboxFlag {
    /** 付 */
    P("P"),
    /** 收 */
    R("R");

    private String value;

    private UpdTailboxFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static UpdTailboxFlag byValue(String value) {
        for (UpdTailboxFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}