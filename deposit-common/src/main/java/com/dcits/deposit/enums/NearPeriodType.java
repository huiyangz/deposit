package com.dcits.deposit.enums;

/** 分段周期类型 */
public enum NearPeriodType {
    /** 季 */
    Q("Q"),
    /** 年 */
    Y("Y"),
    /** 天 */
    D("D"),
    /** 月 */
    M("M");

    private String value;

    private NearPeriodType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static NearPeriodType byValue(String value) {
        for (NearPeriodType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}