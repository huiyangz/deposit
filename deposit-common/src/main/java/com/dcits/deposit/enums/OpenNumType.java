package com.dcits.deposit.enums;

/** 智能存款开立笔数类型 */
public enum OpenNumType {
    /** 单笔开立 */
    VALUE_0("0"),
    /** 多笔开立 */
    VALUE_1("1");

    private String value;

    private OpenNumType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OpenNumType byValue(String value) {
        for (OpenNumType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}