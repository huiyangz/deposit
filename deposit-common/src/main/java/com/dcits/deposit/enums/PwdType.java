package com.dcits.deposit.enums;

/** 密码类型 */
public enum PwdType {
    /** 管理密码 */
    MA("MA"),
    /** 查询密码 */
    QY("QY"),
    /** 交易密码 */
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