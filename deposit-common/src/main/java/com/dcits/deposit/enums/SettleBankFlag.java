package com.dcits.deposit.enums;

/** 结算账户行内外标识 */
public enum SettleBankFlag {
    /** 行内 */
    I("I"),
    /** 行外 */
    O("O");

    private String value;

    private SettleBankFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SettleBankFlag byValue(String value) {
        for (SettleBankFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}