package com.dcits.deposit.enums;

/** 红字处理标志 */
public enum RcrRcdInd {
    /** 贷记红字 */
    RCR("RCR"),
    /** 借记红字 */
    RDR("RDR");

    private String value;

    private RcrRcdInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RcrRcdInd byValue(String value) {
        for (RcrRcdInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}