package com.dcits.deposit.enums;

/** 协议分类 */
public enum AgreementClass {
    /** 分层 */
    LAYER("LAYER"),
    /** 不分层 */
    DEFAULT("DEFAULT");

    private String value;

    private AgreementClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AgreementClass byValue(String value) {
        for (AgreementClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}