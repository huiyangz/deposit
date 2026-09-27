package com.dcits.deposit.enums;

/** 代办人关系 */
public enum CommissionRelation {
    /** 亲子关系 */
    VALUE_0("0"),
    /** 夫妻关系 */
    VALUE_1("1"),
    /** 兄弟姐妹 */
    VALUE_2("2"),
    /** 其他 */
    VALUE_3("3");

    private String value;

    private CommissionRelation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CommissionRelation byValue(String value) {
        for (CommissionRelation item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}