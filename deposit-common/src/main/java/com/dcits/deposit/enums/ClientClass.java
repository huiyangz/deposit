package com.dcits.deposit.enums;

/** 客户类别 */
public enum ClientClass {
    /** 个人类 */
    PER("PER"),
    /** 企业类 */
    ERP("ERP"),
    /** 机构类 */
    BRA("BRA");

    private String value;

    private ClientClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ClientClass byValue(String value) {
        for (ClientClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}