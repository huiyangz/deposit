package com.dcits.deposit.enums;

/** 结售汇资金属性 */
public enum ExchangeAmountNature {
    /** 缴纳境外国籍组织会费 */
    VALUE_11("11"),
    /** 货物贸易 */
    VALUE_1("1"),
    /** 职工薪酬 */
    VALUE_7("7"),
    /** 旅游 */
    VALUE_3("3"),
    /** 咨询服务 */
    VALUE_6("6"),
    /** 运输 */
    VALUE_2("2"),
    /** 证券投资 */
    VALUE_14("14"),
    /** 赡家款 */
    VALUE_8("8"),
    /** 直接投资 */
    VALUE_13("13"),
    /** 其他经常转移 */
    VALUE_10("10"),
    /** 金融和保险服务 */
    VALUE_4("4"),
    /** 投资收益 */
    VALUE_9("9"),
    /** 资本账户 */
    VALUE_12("12"),
    /** 专有权利使用费和特许费 */
    VALUE_5("5"),
    /** 国内外汇贷款 */
    VALUE_15("15"),
    /** 其他 */
    VALUE_16("16");

    private String value;

    private ExchangeAmountNature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExchangeAmountNature byValue(String value) {
        for (ExchangeAmountNature item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}