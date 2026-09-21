package com.dcits.deposit.enums;

/** 账户支付状态 */
public enum AcctPaymentStatus {
    /** 冲正成功 */
    VALUE_05("05"),
    /** 记账成功 */
    VALUE_02("02"),
    /** 解冻成功 */
    VALUE_11("11"),
    /** 冻结成功 */
    VALUE_08("08");

    private String value;

    private AcctPaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcctPaymentStatus byValue(String value) {
        for (AcctPaymentStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}