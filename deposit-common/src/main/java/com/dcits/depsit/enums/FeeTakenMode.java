package com.dcits.depsit.enums;

/** 收费模式 */
public enum FeeTakenMode {
    /** 现金 */
    C("C"),
    /** 暂不收取 */
    N("N"),
    /** 套餐内抵用 */
    P("P"),
    /** 按比例收费 */
    R("R"),
    /** 转账 */
    T("T");

    private String value;

    private FeeTakenMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FeeTakenMode byValue(String value) {
        for (FeeTakenMode item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}