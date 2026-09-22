package com.dcits.deposit.enums;

/** 可用余额计算类型 */
public enum AvailbalCalcType {
    /** 重算限制 */
    VALUE_1("1"),
    /** 重算透支 */
    VALUE_2("2"),
    /** 不重算 */
    VALUE_0("0"),
    /** 重算冻结 */
    VALUE_3("3");

    private String value;

    private AvailbalCalcType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AvailbalCalcType byValue(String value) {
        for (AvailbalCalcType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}