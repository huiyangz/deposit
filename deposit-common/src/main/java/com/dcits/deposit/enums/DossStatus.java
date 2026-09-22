package com.dcits.deposit.enums;

/** 久悬状态 */
public enum DossStatus {
    /** 已激活 */
    A("A"),
    /** 已销户 */
    C("C"),
    /** 冒名销户已支取 */
    SD("SD"),
    /** 不动 */
    D("D"),
    /** 冒名销户 */
    CS("CS"),
    /** 久悬 */
    S("S"),
    /** 转营业外 */
    O("O");

    private String value;

    private DossStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DossStatus byValue(String value) {
        for (DossStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}