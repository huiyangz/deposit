package com.dcits.deposit.enums;

/** 分位处理方式 */
public enum CentDealType {
    /** 多付少收（客户） */
    VALUE_0("0"),
    /** 少付多收（客户） */
    VALUE_1("1");

    private String value;

    private CentDealType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CentDealType byValue(String value) {
        for (CentDealType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}