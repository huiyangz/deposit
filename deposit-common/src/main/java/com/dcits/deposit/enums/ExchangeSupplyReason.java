package com.dcits.deposit.enums;

/** 结售汇补录原因 */
public enum ExchangeSupplyReason {
    /** 应急预案启动后补录 */
    VALUE_1("1"),
    /** 脱机操作 */
    VALUE_2("2"),
    /** 其他 */
    VALUE_4("4"),
    /** 差错业务撤销后补录 */
    VALUE_3("3");

    private String value;

    private ExchangeSupplyReason(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExchangeSupplyReason byValue(String value) {
        for (ExchangeSupplyReason item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}