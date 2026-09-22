package com.dcits.deposit.enums;

/** 税种 */
public enum TaxType {
    /** 代扣代缴企业所得税 */
    VALUE_18("18");

    private String value;

    private TaxType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TaxType byValue(String value) {
        for (TaxType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}