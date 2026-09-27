package com.dcits.deposit.enums;

/** 协议签约状态 */
public enum GreementSignStatus {
    /** 已签约 */
    Y("Y"),
    /** 未签约 */
    N("N"),
    /** 已解约 */
    C("C");

    private String value;

    private GreementSignStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GreementSignStatus byValue(String value) {
        for (GreementSignStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}