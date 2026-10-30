package com.dcits.deposit.enums;

/** 复核标识 */
public enum ApprIndicator {
    /** 本地授权 */
    L("L"),
    /** 远端授权 */
    R("R");

    private String value;

    private ApprIndicator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ApprIndicator byValue(String value) {
        for (ApprIndicator item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}