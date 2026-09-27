package com.dcits.deposit.enums;

/** 账户标志 */
public enum YhtAcctFlag {
    /** 主账户 */
    A("A"),
    /** 节点账户 */
    B("B"),
    /** 叶子账户 */
    C("C");

    private String value;

    private YhtAcctFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static YhtAcctFlag byValue(String value) {
        for (YhtAcctFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}