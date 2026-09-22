package com.dcits.deposit.enums;

/** 控制状态 */
public enum ControlStatus {
    /** 生效中 */
    A("A"),
    /** 未生效(将来某天开始生效) */
    F("F"),
    /** 已终止 */
    E("E");

    private String value;

    private ControlStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ControlStatus byValue(String value) {
        for (ControlStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}