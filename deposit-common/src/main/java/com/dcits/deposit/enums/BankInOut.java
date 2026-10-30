package com.dcits.deposit.enums;

/** 行内行外标识 */
public enum BankInOut {
    /** 行内 */
    I("I"),
    /** 行外 */
    O("O");

    private String value;

    private BankInOut(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BankInOut byValue(String value) {
        for (BankInOut item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}