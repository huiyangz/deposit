package com.dcits.deposit.enums;

/** 适用范围 */
public enum ApplyInd {
    /** 公司 */
    E("E"),
    /** 个人 */
    I("I"),
    /** 个人和公司 */
    B("B");

    private String value;

    private ApplyInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ApplyInd byValue(String value) {
        for (ApplyInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}