package com.dcits.deposit.enums;

/** 余额方向 */
public enum BalanceWay {
    /** 借方 */
    D("D"),
    /** 实际 */
    A("A"),
    /** 双向不轧差 */
    B("B"),
    /** 贷方 */
    C("C");

    private String value;

    private BalanceWay(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BalanceWay byValue(String value) {
        for (BalanceWay item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}