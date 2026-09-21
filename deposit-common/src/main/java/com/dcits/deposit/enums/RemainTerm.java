package com.dcits.deposit.enums;

/** 账户剩余期限 */
public enum RemainTerm {
    /** 7D */
    B("B"),
    /** 2M */
    D("D"),
    /** 0D */
    A("A"),
    /** 003P */
    R("R"),
    /** 001P */
    Q("Q"),
    /** 999P */
    P("P"),
    /** 6M */
    F("F"),
    /** 1M */
    C("C"),
    /** 3Y */
    I("I"),
    /** 006P */
    S("S"),
    /** 999Y */
    X("X"),
    /** 3M */
    E("E"),
    /** 999Y */
    J("J"),
    /** 1Y */
    G("G"),
    /** 998P */
    T("T"),
    /** 2Y */
    H("H");

    private String value;

    private RemainTerm(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RemainTerm byValue(String value) {
        for (RemainTerm item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}