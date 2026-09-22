package com.dcits.deposit.enums;

/** 限额累计类型 */
public enum SumType {
    /** 滑动窗口 */
    VALUE_2("2"),
    /** 自然周期 */
    VALUE_1("1"),
    /** 指定日期范围 */
    VALUE_3("3"),
    /** 指定时间范围 */
    VALUE_4("4"),
    /** 指定日期+时间范围 */
    VALUE_5("5");

    private String value;

    private SumType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SumType byValue(String value) {
        for (SumType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}