package com.dcits.deposit.enums;

/** 结售汇类型 */
public enum ExchangeType {
    /** 资本项目 */
    VALUE_03("03"),
    /** 其他 */
    VALUE_07("07"),
    /** 一般贸易 */
    VALUE_01("01"),
    /** 对私 */
    VALUE_04("04"),
    /** 银行自身 */
    VALUE_06("06"),
    /** 外汇交易市场平补 */
    VALUE_05("05"),
    /** 服务贸易 */
    VALUE_02("02");

    private String value;

    private ExchangeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExchangeType byValue(String value) {
        for (ExchangeType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}