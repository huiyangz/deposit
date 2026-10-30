package com.dcits.deposit.enums;

/** 个人活期存款账户类别 */
public enum AcctClass {
    /** 一类账户 */
    VALUE_1("1"),
    /** 二类账户 */
    VALUE_2("2"),
    /** 三类账户 */
    VALUE_3("3");

    private String value;

    private AcctClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcctClass byValue(String value) {
        for (AcctClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}