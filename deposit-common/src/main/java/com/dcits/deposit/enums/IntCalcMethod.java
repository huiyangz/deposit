package com.dcits.deposit.enums;

/** 利息计算方法 */
public enum IntCalcMethod {
    /** 积数计息 */
    AB("AB"),
    /** 分段计息 */
    EB("EB");

    private String value;

    private IntCalcMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IntCalcMethod byValue(String value) {
        for (IntCalcMethod item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}