package com.dcits.deposit.enums;

/** 利息分类 */
public enum IntClass {
    /** 宽限期利息 */
    GODP("GODP"),
    /** 正常利息 */
    INT("INT"),
    /** 复利 */
    ODI("ODI"),
    /** 复利的复利 */
    ODODI("ODODI"),
    /** 罚息的复利 */
    ODODP("ODODP"),
    /** 罚息 */
    ODP("ODP"),
    /** 超期利息 */
    PDUE("PDUE"),
    /** 违约利息 */
    WYINT("WYINT");

    private String value;

    private IntClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IntClass byValue(String value) {
        for (IntClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}