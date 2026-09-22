package com.dcits.deposit.enums;

/** 自贸区属性 */
public enum FtaNature {
    /** 商业自由区 */
    VALUE_01("01"),
    /** 工业自由区 */
    VALUE_02("02");

    private String value;

    private FtaNature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FtaNature byValue(String value) {
        for (FtaNature item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}