package com.dcits.deposit.enums;

/** 柜员绑定关系 */
public enum TellerBindType {
    /** 长期制 */
    O("O"),
    /** 串包制 */
    Y("Y");

    private String value;

    private TellerBindType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TellerBindType byValue(String value) {
        for (TellerBindType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}