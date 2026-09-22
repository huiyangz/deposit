package com.dcits.deposit.enums;

/** 转存账户类型 */
public enum RenewAcctType {
    /** 已有定期主账户 */
    VALUE_1("1"),
    /** 新开定期账户 */
    VALUE_0("0");

    private String value;

    private RenewAcctType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RenewAcctType byValue(String value) {
        for (RenewAcctType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}