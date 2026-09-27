package com.dcits.deposit.enums;

/** 靠档方向 */
public enum GearDaysInd {
    /** 靠上档 */
    C("C"),
    /** 靠下档 */
    F("F");

    private String value;

    private GearDaysInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GearDaysInd byValue(String value) {
        for (GearDaysInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}