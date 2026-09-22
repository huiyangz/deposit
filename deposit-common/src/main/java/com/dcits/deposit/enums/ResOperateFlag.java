package com.dcits.deposit.enums;

/** 黑名单限制操作标识 */
public enum ResOperateFlag {
    /** 异常 */
    E("E"),
    /** 控制 */
    C("C");

    private String value;

    private ResOperateFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ResOperateFlag byValue(String value) {
        for (ResOperateFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}