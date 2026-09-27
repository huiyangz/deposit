package com.dcits.deposit.enums;

/** 计息起始日期取值方法 */
public enum EffectDateCalcMethod {
    /** 表示按上一结息日 */
    C("C"),
    /** 计提日期 */
    I("I"),
    /** 到期日 */
    M("M"),
    /** 开户日期 */
    O("O");

    private String value;

    private EffectDateCalcMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EffectDateCalcMethod byValue(String value) {
        for (EffectDateCalcMethod item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}