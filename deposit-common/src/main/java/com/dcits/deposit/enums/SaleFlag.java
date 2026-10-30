package com.dcits.deposit.enums;

/** 出售类凭证标志 */
public enum SaleFlag {
    /** 凭证出售 */
    VALUE_1("1"),
    /** 凭证付出 */
    VALUE_2("2");

    private String value;

    private SaleFlag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SaleFlag byValue(String value) {
        for (SaleFlag item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}