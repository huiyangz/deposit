package com.dcits.deposit.enums;

/** 开户方式 */
public enum AcctOpenType {
    /** 手工开立 */
    U("U"),
    /** 系统开立 */
    S("S");

    private String value;

    private AcctOpenType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcctOpenType byValue(String value) {
        for (AcctOpenType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}