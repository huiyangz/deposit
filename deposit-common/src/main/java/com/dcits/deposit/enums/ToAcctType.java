package com.dcits.deposit.enums;

/** 存款账户类型（内部） */
public enum ToAcctType {
    /** AIO账户 */
    A("A"),
    /** 定期账户 */
    T("T"),
    /** 储蓄账户 */
    S("S"),
    /** 结算账户 */
    C("C");

    private String value;

    private ToAcctType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ToAcctType byValue(String value) {
        for (ToAcctType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}