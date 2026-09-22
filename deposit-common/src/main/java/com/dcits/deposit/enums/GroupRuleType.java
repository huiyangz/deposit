package com.dcits.deposit.enums;

/** 分组规则 */
public enum GroupRuleType {
    /** 取最大值 */
    VALUE_02("02"),
    /** 取最小值 */
    VALUE_03("03"),
    /** 取平均值 */
    VALUE_04("04"),
    /** 取叠加 */
    VALUE_05("05"),
    /** 取权重 */
    VALUE_06("06");

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