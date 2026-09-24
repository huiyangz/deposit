package com.dcits.deposit.enums;

/** 尾箱细类 */
public enum TailboxSubType {
    /** 机构尾箱 */
    B("B"),
    /** 高柜尾箱 */
    H("H"),
    /** 低柜尾箱 */
    L("L"),
    /** 机具尾箱 */
    U("U");

    private String value;

    private TailboxSubType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TailboxSubType byValue(String value) {
        for (TailboxSubType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}