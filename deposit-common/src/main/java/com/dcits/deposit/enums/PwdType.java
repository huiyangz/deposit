package com.dcits.deposit.enums;

/** 密码类型 */
public enum PwdType {
    /** 账户管理密码 */
    MA("MA"),
    /** 账户查询密码 */
    QY("QY"),
    /** 支取密码 */
    WD("WD");

    private String value;

    private PwdType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PwdType byValue(String value) {
        for (PwdType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}