package com.dcits.deposit.enums;

/** 转存方式 */
public enum AutoRenewRollover {
    /** 已终止 */
    E("E"),
    /** 不转存 */
    N("N"),
    /** 本金自动 */
    W("W"),
    /** 本息自动 */
    O("O"),
    /** 未生效(限制开始日期未到或者在将来的某天限制开始生效) */
    F("F");

    private String value;

    private AutoRenewRollover(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AutoRenewRollover byValue(String value) {
        for (AutoRenewRollover item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}