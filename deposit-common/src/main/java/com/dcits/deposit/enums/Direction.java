package com.dcits.deposit.enums;

/** 交易方向 */
public enum Direction {
    /** 转出 */
    VALUE_0("0"),
    /** 转入 */
    VALUE_1("1");

    private String value;

    private Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Direction byValue(String value) {
        for (Direction item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}