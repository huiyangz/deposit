package com.dcits.deposit.enums;

/** 子账户结算方式 */
public enum AcctSettleMethod {
    /** 可以提现 */
    VALUE_1("1"),
    /** 不能提现 */
    VALUE_2("2"),
    /** 可以互转 */
    VALUE_3("3"),
    /** 不可互转 */
    VALUE_4("4");

    private String value;

    private AcctSettleMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcctSettleMethod byValue(String value) {
        for (AcctSettleMethod item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}