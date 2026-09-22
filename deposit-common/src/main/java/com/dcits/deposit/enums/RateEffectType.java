package com.dcits.deposit.enums;

/** 利率生效方式 */
public enum RateEffectType {
    /** 按产品 */
    A("A"),
    /** 就高 */
    H("H"),
    /** 就低 */
    L("L"),
    /** 按分户/不比较 */
    N("N");

    private String value;

    private RateEffectType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RateEffectType byValue(String value) {
        for (RateEffectType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}