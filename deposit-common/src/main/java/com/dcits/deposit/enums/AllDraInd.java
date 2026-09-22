package com.dcits.deposit.enums;

/** 通兑标志 */
public enum AllDraInd {
    /** 分行间通兑 */
    F("F"),
    /** 指定机构间通兑 */
    D("D"),
    /** 全行通兑 */
    Y("Y"),
    /** 不通兑 */
    N("N");

    private String value;

    private AllDraInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AllDraInd byValue(String value) {
        for (AllDraInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}