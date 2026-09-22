package com.dcits.deposit.enums;

/** 控制分类 */
public enum ControlClass {
    /** 停止金额类交易 */
    SA("SA"),
    /** 不允许现金存入 */
    MD("MD"),
    /** 停止支取交易 */
    SW("SW"),
    /** 停止存入交易 */
    SD("SD"),
    /** 停止金融类交易 */
    SF("SF"),
    /** 不允许现金支取 */
    MW("MW");

    private String value;

    private ControlClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ControlClass byValue(String value) {
        for (ControlClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}