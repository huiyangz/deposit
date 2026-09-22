package com.dcits.deposit.enums;

/** 转入方账户类型 */
public enum OthAcctSort {
    /** 活期 */
    CUR("CUR"),
    /** 整存整取 */
    SAR("SAR");

    private String value;

    private OthAcctSort(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OthAcctSort byValue(String value) {
        for (OthAcctSort item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}