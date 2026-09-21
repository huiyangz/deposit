package com.dcits.deposit.enums;

/** 批次处理状态 */
public enum BatchStatus {
    /** 待处理(部分成功) */
    W("W"),
    /** 失败 */
    F("F"),
    /** 已验证 */
    V("V"),
    /** 新建 */
    N("N"),
    /** 成功 */
    S("S");

    private String value;

    private BatchStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BatchStatus byValue(String value) {
        for (BatchStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}