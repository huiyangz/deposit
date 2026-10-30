package com.dcits.deposit.enums;

/** 欠费状态 */
public enum OsdStatus {
    /** 正常 */
    A("A"),
    /** 免收 */
    B("B"),
    /** 欠费/未收讫 */
    C("C"),
    /** 欠费/部分收讫 */
    D("D");

    private String value;

    private OsdStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OsdStatus byValue(String value) {
        for (OsdStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}