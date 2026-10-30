package com.dcits.deposit.enums;

/** 利息重算方法 */
public enum IntRecalcMethod {
    /** 取历史利率计算 */
    H("H"),
    /** 取历史计提后再按模型计算 */
    I("I"),
    /** 重新按模型计算 */
    N("N");

    private String value;

    private IntRecalcMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IntRecalcMethod byValue(String value) {
        for (IntRecalcMethod item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}