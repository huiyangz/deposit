package com.dcits.deposit.enums;

/** 后续变动日利率取值日类型 */
public enum FollowIntDayType {
    /** 自然日 */
    VALUE_2("2"),
    /** 先自然日后工作日 */
    VALUE_4("4"),
    /** 工作日 */
    VALUE_1("1"),
    /** 先工作日后自然日 */
    VALUE_3("3");

    private String value;

    private FollowIntDayType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FollowIntDayType byValue(String value) {
        for (FollowIntDayType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}