package com.dcits.deposit.enums;

/** 账户属性类型 */
public enum NatureProperty {
    /** 核准 */
    A("A"),
    /** 备案 */
    F("F");

    private String value;

    private NatureProperty(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static NatureProperty byValue(String value) {
        for (NatureProperty item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}