package com.dcits.deposit.enums;

/** 状态 */
public enum Status {
    /** 有效 */
    A("A"),
    /** 非活动状态 */
    C("C"),
    /** 删除 */
    D("D"),
    /** 无效 */
    F("F"),
    /** 新增 */
    N("N"),
    /** 未过账 */
    O("O"),
    /** 已过账 */
    P("P"),
    /** 修改 */
    U("U");

    private String value;

    private Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Status byValue(String value) {
        for (Status item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}