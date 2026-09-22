package com.dcits.deposit.enums;

/** 假日类型 */
public enum HolidayType {
    /** 标准假日 */
    S("S"),
    /** 非标准假日 */
    N("N");

    private String value;

    private HolidayType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HolidayType byValue(String value) {
        for (HolidayType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}