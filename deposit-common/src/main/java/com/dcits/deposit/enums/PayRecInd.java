package com.dcits.deposit.enums;

/** 收付标志 */
public enum PayRecInd {
    /** 收 */
    VALUE_02("02"),
    /** 付 */
    VALUE_01("01");

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