package com.dcits.deposit.enums;

/** 存款类型 */
public enum DepositType {
    /** 往来 */
    C("C"),
    /** 储蓄 */
    S("S"),
    /** 定期 */
    T("T");

    private String value;

    private DepositType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DepositType byValue(String value) {
        for (DepositType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}