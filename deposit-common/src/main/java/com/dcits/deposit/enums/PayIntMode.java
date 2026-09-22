package com.dcits.deposit.enums;

/** 存款付息方式 */
public enum PayIntMode {
    /** 整存零取按频率支取本金 */
    P6("P6"),
    /** 按比例付息 */
    P2("P2"),
    /** 支取时付息 */
    P5("P5"),
    /** 到期付息 */
    P3("P3"),
    /** 按频率付息 */
    P1("P1"),
    /** 签约结束时付息 */
    P4("P4");

    private String value;

    private PayIntMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PayIntMode byValue(String value) {
        for (PayIntMode item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}