package com.dcits.deposit.enums;

/** 账户结算模式 */
public enum SettleInd {
    /** 允许借贷 */
    A("A"),
    /** 允许贷 */
    C("C"),
    /** 允许借 */
    D("D"),
    /** 不允许借贷 */
    X("X");

    private String value;

    private SettleInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SettleInd byValue(String value) {
        for (SettleInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}