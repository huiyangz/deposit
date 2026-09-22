package com.dcits.deposit.enums;

/** 结售汇修改原因 */
public enum ExchangeChangeReason {
    /** 币种录入错误 */
    VALUE_02("02"),
    /** 其他 */
    VALUE_06("06"),
    /** 金额录入错误 */
    VALUE_01("01"),
    /** 资金形态录入错误 */
    VALUE_05("05"),
    /** 资金属性录入错误 */
    VALUE_04("04"),
    /** 姓名录入错误 */
    VALUE_03("03");

    private String value;

    private ExchangeChangeReason(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExchangeChangeReason byValue(String value) {
        for (ExchangeChangeReason item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}