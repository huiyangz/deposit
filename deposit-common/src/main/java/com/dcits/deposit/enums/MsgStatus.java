package com.dcits.deposit.enums;

/** 短信签约状态 */
public enum MsgStatus {
    /** 未签约 */
    N("N"),
    /** 已签约 */
    Y("Y"),
    /** 已解约 */
    C("C");

    private String value;

    private MsgStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MsgStatus byValue(String value) {
        for (MsgStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}