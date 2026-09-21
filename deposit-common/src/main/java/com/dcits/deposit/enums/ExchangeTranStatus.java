package com.dcits.deposit.enums;

/** 结售汇交易状态 */
public enum ExchangeTranStatus {
    /** 成功 */
    Y("Y"),
    /** 被冲正 */
    X("X");

    private String value;

    private ExchangeTranStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExchangeTranStatus byValue(String value) {
        for (ExchangeTranStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}