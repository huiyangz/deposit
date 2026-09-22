package com.dcits.deposit.enums;

/** 靠档方向 */
public enum GearAmtInd {
    /** 靠上档 */
    C("C"),
    /** 靠下档 */
    F("F");

    private String value;

    private GearAmtInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GearAmtInd byValue(String value) {
        for (GearAmtInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}