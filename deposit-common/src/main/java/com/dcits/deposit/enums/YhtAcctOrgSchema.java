package com.dcits.deposit.enums;

/** 一户通账户结构模式 */
public enum YhtAcctOrgSchema {
    /** 母实子虚 */
    RV("RV"),
    /** 母虚子实 */
    VR("VR");

    private String value;

    private YhtAcctOrgSchema(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static YhtAcctOrgSchema byValue(String value) {
        for (YhtAcctOrgSchema item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}