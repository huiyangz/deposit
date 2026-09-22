package com.dcits.deposit.enums;

/** 计提利息匹配规则 */
public enum IntMatchRule {
    /** 直接生效(e.g. 活期) */
    DEFAULT("DEFAULT"),
    /** 同时生效(e.g. 幸福存) */
    DEPEND("DEPEND"),
    /** 协定 */
    LAYER("LAYER"),
    /** 唯一生效(e.g. 整整) */
    PERIOD("PERIOD");

    private String value;

    private IntMatchRule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IntMatchRule byValue(String value) {
        for (IntMatchRule item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}