package com.dcits.deposit.enums;

/** 总账类型 */
public enum GlType {
    /** 内部 */
    I("I"),
    /** 往账 */
    N("N"),
    /** 零售账户 */
    R("R"),
    /** 来账 */
    V("V");

    private String value;

    private GlType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GlType byValue(String value) {
        for (GlType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}