package com.dcits.deposit.enums;

/** 分组规则 */
public enum GroupRuleType {
    /** 取最大值 */
    VALUE_2("2"),
    /** 取最小值 */
    VALUE_3("3"),
    /** 取平均值 */
    VALUE_4("4"),
    /** 取叠加 */
    VALUE_5("5"),
    /** 取权重 */
    VALUE_6("6");

    private String value;

    private GroupRuleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GroupRuleType byValue(String value) {
        for (GroupRuleType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}