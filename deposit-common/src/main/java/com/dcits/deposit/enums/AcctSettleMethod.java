package com.dcits.deposit.enums;

/** 子账户结算方式 */
public enum AcctSettleMethod {
    /** 不可互转 */
    VALUE_04("04"),
    /** 不能提现 */
    VALUE_02("02"),
    /** 可以互转 */
    VALUE_03("03"),
    /** 可以提现 */
    VALUE_01("01");

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