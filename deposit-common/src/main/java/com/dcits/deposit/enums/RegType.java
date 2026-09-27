package com.dcits.deposit.enums;

/** 登记类型 */
public enum RegType {
    /** 开户/卡 */
    VALUE_1("1"),
    /** 销户/卡 */
    VALUE_2("2"),
    /** 预开户 */
    VALUE_3("3");

    private String value;

    private RegType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RegType byValue(String value) {
        for (RegType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}