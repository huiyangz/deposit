package com.dcits.deposit.enums;

/** 计息类型 */
public enum IntCalcType {
    /** 贴现式 */
    VALUE_3("3"),
    /** 附息式固定利率 */
    VALUE_2("2"),
    /** 利随本清固定利率 */
    VALUE_4("4"),
    /** 零息式 */
    VALUE_0("0"),
    /** 附息式浮动利率 */
    VALUE_1("1");

    private String value;

    private IntCalcType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IntCalcType byValue(String value) {
        for (IntCalcType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}