package com.dcits.deposit.enums;

/** 摊销状态 */
public enum AmortizeStatus {
    /** 活动 */
    A("A"),
    /** 正常关闭 */
    C("C"),
    /** 全部退费 */
    F("F"),
    /** 预建立 */
    P("P"),
    /** 已冲销 */
    R("R"),
    /** 未摊销退费 */
    U("U");

    private String value;

    private AmortizeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AmortizeStatus byValue(String value) {
        for (AmortizeStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}