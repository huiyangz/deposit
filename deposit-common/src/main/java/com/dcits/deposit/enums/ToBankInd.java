package com.dcits.deposit.enums;

/** 转入账号他行标志 */
public enum ToBankInd {
    /** 是 */
    Y("Y"),
    /** 否 */
    N("N");

    private String value;

    private ToBankInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ToBankInd byValue(String value) {
        for (ToBankInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}