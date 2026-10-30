package com.dcits.deposit.enums;

/** 收费方式 */
public enum ChargeWay {
    /** 日终系统自动收取 */
    A("A"),
    /** 联机人工收取 */
    M("M"),
    /** 不收取 */
    N("N"),
    /** 套餐内抵用 */
    P("P"),
    /** 单独收费 */
    S("S");

    private String value;

    private ChargeWay(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ChargeWay byValue(String value) {
        for (ChargeWay item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}