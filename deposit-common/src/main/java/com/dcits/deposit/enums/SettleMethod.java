package com.dcits.deposit.enums;

/** 结算方法 */
public enum SettleMethod {
    /** 内部户 */
    I("I"),
    /** 往账 */
    N("N"),
    /** 结算账户 */
    R("R"),
    /** 来账 */
    V("V");

    private String value;

    private SettleMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SettleMethod byValue(String value) {
        for (SettleMethod item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}