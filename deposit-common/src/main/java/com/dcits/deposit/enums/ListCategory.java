package com.dcits.deposit.enums;

/** 名单种类 */
public enum ListCategory {
    /** 人行黑名单 */
    VALUE_01("01"),
    /** 行内白名单 */
    VALUE_12("12"),
    /** 人行灰名单 */
    VALUE_02("02"),
    /** 特殊名单 */
    VALUE_10("10"),
    /** 行内黑名单 */
    VALUE_11("11");

    private String value;

    private ListCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ListCategory byValue(String value) {
        for (ListCategory item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}