package com.dcits.deposit.enums;

/** 买卖固定方 */
public enum SellBuyInd {
    /** 结汇 */
    B("B"),
    /** 售汇 */
    S("S"),
    /** 外币兑换 */
    E("E");

    private String value;

    private SellBuyInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SellBuyInd byValue(String value) {
        for (SellBuyInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}