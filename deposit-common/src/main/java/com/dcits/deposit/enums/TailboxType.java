package com.dcits.deposit.enums;

/** 尾箱类型 */
public enum TailboxType {
    /** 机构尾箱 */
    B("B"),
    /** 金库尾箱 */
    G("G"),
    /** 柜员尾箱 */
    T("T");

    private String value;

    private TailboxType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TailboxType byValue(String value) {
        for (TailboxType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}