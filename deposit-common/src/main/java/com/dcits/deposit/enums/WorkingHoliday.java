package com.dcits.deposit.enums;

/** 工作日/假日 */
public enum WorkingHoliday {
    /** 工作日 */
    W("W"),
    /** 假日 */
    H("H");

    private String value;

    private WorkingHoliday(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static WorkingHoliday byValue(String value) {
        for (WorkingHoliday item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}