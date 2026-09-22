package com.dcits.deposit.enums;

/** 密码状态 */
public enum PasswordStatus {
    /** 正常 */
    A("A"),
    /** 锁定 */
    L("L");

    private String value;

    private PasswordStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PasswordStatus byValue(String value) {
        for (PasswordStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}