package com.dcits.deposit.enums;

/** 限额折算方式 */
public enum LimitConvert {
    /** 折算 */
    VALUE_2("2"),
    /** 原币种 */
    VALUE_1("1");

    private String value;

    private LimitConvert(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static LimitConvert byValue(String value) {
        for (LimitConvert item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}