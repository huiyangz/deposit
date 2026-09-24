package com.dcits.deposit.enums;

/** 牌价类型 */
public enum ToId {
    /** 直接 */
    D("D"),
    /** 间接 */
    I("I");

    private String value;

    private ToId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ToId byValue(String value) {
        for (ToId item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}