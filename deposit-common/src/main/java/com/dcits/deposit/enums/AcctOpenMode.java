package com.dcits.deposit.enums;

/** 开户模式 */
public enum AcctOpenMode {
    /** 单位批量开卡 */
    BOC("BOC"),
    /** 个人开卡业务批量集中处理 */
    BOI("BOI"),
    /** 单笔开户 */
    SO("SO");

    private String value;

    private AcctOpenMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcctOpenMode byValue(String value) {
        for (AcctOpenMode item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}