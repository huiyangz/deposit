package com.dcits.deposit.enums;

/** 联机交易状态 */
public enum OnlineTranStatus {
    /** 处理中 */
    P("P"),
    /** 失败 */
    R("R"),
    /** 成功 */
    S("S"),
    /** 失败 */
    F("F");

    private String value;

    private OnlineTranStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OnlineTranStatus byValue(String value) {
        for (OnlineTranStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}