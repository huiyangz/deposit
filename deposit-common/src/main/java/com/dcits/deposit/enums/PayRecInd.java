package com.dcits.deposit.enums;

/** 收付标志 */
public enum PayRecInd {
    /** 付 */
    VALUE_1("1"),
    /** 收 */
    VALUE_2("2"),
    /** 收 */
    R("R"),
    /** 付 */
    P("P");

    private String value;

    private PayRecInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PayRecInd byValue(String value) {
        for (PayRecInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}