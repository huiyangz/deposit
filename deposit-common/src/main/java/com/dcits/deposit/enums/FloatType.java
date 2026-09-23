package com.dcits.deposit.enums;

/** 浮动方式 */
public enum FloatType {
    /** FIXED-固定值 */
    FIXED("FIXED"),
    /** PERCENT-浮动百分比 */
    PERCENT("PERCENT"),
    /** POINT-浮动百分点 */
    POINT("POINT");

    private String value;

    private FloatType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FloatType byValue(String value) {
        for (FloatType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}