package com.dcits.deposit.enums;

/** 账户剩余期限 */
public enum RemainTerm {
    /** 0D */
    A("A"),
    /** 7D */
    B("B"),
    /** 1M */
    C("C"),
    /** 2M */
    D("D"),
    /** 3M */
    E("E"),
    /** 6M */
    F("F"),
    /** 1Y */
    G("G"),
    /** 2Y */
    H("H"),
    /** 3Y */
    I("I"),
    /** 999Y */
    J("J"),
    /** 999P */
    P("P"),
    /** 001P */
    Q("Q"),
    /** 003P */
    R("R"),
    /** 006P */
    S("S"),
    /** 998P */
    T("T"),
    /** 999Y */
    X("X");

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