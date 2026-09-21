package com.dcits.deposit.enums;

/** 票据种类 */
public enum BillBusiType {
    /** 全国银行汇票 */
    CT("CT"),
    /** 三省一市汇票 */
    BE("BE"),
    /** 银行承兑汇票 */
    AD("AD"),
    /** 本票 */
    PN("PN");

    private String value;

    private BillBusiType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BillBusiType byValue(String value) {
        for (BillBusiType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}