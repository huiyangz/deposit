package com.dcits.deposit.enums;

/** 视同本人标志 */
public enum IsSelf {
    /** 视同本人 */
    Y("Y"),
    /** 不视同本人 */
    N("N");

    private String value;

    private IsSelf(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IsSelf byValue(String value) {
        for (IsSelf item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}