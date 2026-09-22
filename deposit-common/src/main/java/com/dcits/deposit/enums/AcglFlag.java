package com.dcits.deposit.enums;

/** 记账种类 */
public enum AcglFlag {
    /** 科目间记账 */
    G("G"),
    /** 账户客户记账 */
    B("B"),
    /** 账户转账 */
    A("A");

    private String value;

    private AcglFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcglFlag byValue(String value) {
        for (AcglFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}