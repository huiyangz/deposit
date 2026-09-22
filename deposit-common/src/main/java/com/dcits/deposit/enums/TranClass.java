package com.dcits.deposit.enums;

/** 交易类型分类 */
public enum TranClass {
    /** 现金类 */
    VALUE_1("1"),
    /** 转账类 */
    VALUE_2("2"),
    /** 理财/投资类 */
    VALUE_3("3"),
    /** 消费/缴费 */
    VALUE_4("4"),
    /** 其他 */
    VALUE_6("6"),
    /** 代发类 */
    VALUE_7("7"),
    /** 贷款类 */
    VALUE_8("8"),
    /** 支票类 */
    VALUE_9("9");

    private String value;

    private TranClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TranClass byValue(String value) {
        for (TranClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}