package com.dcits.deposit.enums;

/** 多法人检查标志 */
public enum MultiCorpCheckFlag {
    /** 是 */
    Y("Y"),
    /** 否 */
    N("N");

    private String value;

    private MultiCorpCheckFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MultiCorpCheckFlag byValue(String value) {
        for (MultiCorpCheckFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}