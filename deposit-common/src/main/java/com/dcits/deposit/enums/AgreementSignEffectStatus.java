package com.dcits.deposit.enums;

/** 协议签约生效状态 */
public enum AgreementSignEffectStatus {
    /** 生效 */
    A("A"),
    /** 失效 */
    E("E");

    private String value;

    private AgreementSignEffectStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AgreementSignEffectStatus byValue(String value) {
        for (AgreementSignEffectStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}