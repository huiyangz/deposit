package com.dcits.deposit.enums;

/** 靠档方式 */
public enum GearAmtMethod {
    /** 差额累进 */
    C("C"),
    /** 全额累进 */
    Q("Q");

    private String value;

    private GearAmtMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GearAmtMethod byValue(String value) {
        for (GearAmtMethod item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}