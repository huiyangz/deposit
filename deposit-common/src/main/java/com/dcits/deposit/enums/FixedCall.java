package com.dcits.deposit.enums;

/** 定期账户类型 */
public enum FixedCall {
    /** 整存整取 */
    F("F"),
    /** 定活两便 */
    D("D"),
    /** 通知存款 */
    C("C"),
    /** 协议存款 */
    A("A"),
    /** 定期一本通 */
    B("B"),
    /** 大额存单 */
    M("M"),
    /** 零存整取 */
    L("L"),
    /** 教育储蓄 */
    E("E");

    private String value;

    private FixedCall(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FixedCall byValue(String value) {
        for (FixedCall item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}