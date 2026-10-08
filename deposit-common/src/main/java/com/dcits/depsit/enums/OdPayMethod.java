package com.dcits.depsit.enums;

/** 透支还款方式 */
public enum OdPayMethod {
    /** 到期自动还本 */
    VALUE_0("0"),
    /** 提前自动还本及结清 */
    VALUE_1("1");

    private String value;

    private OdPayMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OdPayMethod byValue(String value) {
        for (OdPayMethod item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}