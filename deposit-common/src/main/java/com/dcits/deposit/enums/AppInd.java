package com.dcits.deposit.enums;

/** 客户内外部标识 */
public enum AppInd {
    /** 个体客户 */
    I("I"),
    /** 个体或者非个体 */
    B("B"),
    /** 非个体 */
    C("C");

    private String value;

    private AppInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AppInd byValue(String value) {
        for (AppInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}