package com.dcits.deposit.enums;

/** 周 */
public enum Weekend1 {
    /** 周六 */
    SAT("SAT"),
    /** 周一 */
    MON("MON"),
    /** 周三 */
    WED("WED"),
    /** 周二 */
    TUE("TUE"),
    /** 周日 */
    SUN("SUN"),
    /** 周五 */
    FRI("FRI"),
    /** 周四 */
    THU("THU");

    private String value;

    private Weekend1(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Weekend1 byValue(String value) {
        for (Weekend1 item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}