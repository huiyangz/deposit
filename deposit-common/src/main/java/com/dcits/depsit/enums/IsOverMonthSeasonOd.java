package com.dcits.depsit.enums;

/** 靠档跨月季标识 */
public enum IsOverMonthSeasonOd {
    /** 跨月 */
    M("M"),
    /** 不跨月/季 */
    N("N"),
    /** 跨季 */
    Q("Q");

    private String value;

    private IsOverMonthSeasonOd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IsOverMonthSeasonOd byValue(String value) {
        for (IsOverMonthSeasonOd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}