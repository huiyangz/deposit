package com.dcits.deposit.enums;

/** 折扣类型 */
public enum DiscType {
    /** 折上折 */
    VALUE_1("1"),
    /** 取最大 */
    VALUE_2("2"),
    /** 取最小 */
    VALUE_3("3"),
    /** 取平均值 */
    VALUE_4("4"),
    /** 取权重 */
    VALUE_6("6");

    private String value;

    private DiscType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DiscType byValue(String value) {
        for (DiscType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}