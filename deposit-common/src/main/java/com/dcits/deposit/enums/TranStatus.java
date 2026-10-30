package com.dcits.deposit.enums;

/** 业务处理状态 */
public enum TranStatus {
    /** 失败 */
    F("F"),
    /** 正常 */
    N("N"),
    /** 未处理 */
    P("P"),
    /** 冲正 */
    R("R"),
    /** 成功 */
    S("S"),
    /** 抹账 */
    W("W"),
    /** 被冲正 */
    X("X");

    private String value;

    private TranStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TranStatus byValue(String value) {
        for (TranStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}