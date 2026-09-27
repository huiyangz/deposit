package com.dcits.deposit.enums;

/** 尾箱属性 */
public enum TailboxProperty {
    /** 组合尾箱 */
    B("B"),
    /** 现金尾箱 */
    C("C"),
    /** 凭证尾箱 */
    V("V");

    private String value;

    private TailboxProperty(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TailboxProperty byValue(String value) {
        for (TailboxProperty item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}