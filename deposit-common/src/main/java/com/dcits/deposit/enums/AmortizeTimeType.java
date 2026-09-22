package com.dcits.deposit.enums;

/** 摊销时间类型 */
public enum AmortizeTimeType {
    /** 期初 */
    F("F"),
    /** 周期内固定日期 */
    D("D"),
    /** 期末 */
    L("L");

    private String value;

    private AmortizeTimeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AmortizeTimeType byValue(String value) {
        for (AmortizeTimeType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}