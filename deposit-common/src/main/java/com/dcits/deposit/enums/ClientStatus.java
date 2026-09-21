package com.dcits.deposit.enums;

/** 客户交易状态 */
public enum ClientStatus {
    /** 已注销 */
    C("C"),
    /** 非活动 */
    D("D"),
    /** 冻结 */
    B("B"),
    /** 活动 */
    A("A");

    private String value;

    private ClientStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ClientStatus byValue(String value) {
        for (ClientStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}