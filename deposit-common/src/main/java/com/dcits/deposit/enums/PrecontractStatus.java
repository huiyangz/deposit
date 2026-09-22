package com.dcits.deposit.enums;

/** 期次产品预约状态 */
public enum PrecontractStatus {
    /** 开户 */
    O("O"),
    /** 违约 */
    D("D"),
    /** 认购 */
    S("S"),
    /** 已取消 */
    C("C"),
    /** 已预约 */
    A("A"),
    /** 已完成 */
    B("B"),
    /** 撤销 */
    R("R"),
    /** 预约 */
    P("P");

    private String value;

    private PrecontractStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PrecontractStatus byValue(String value) {
        for (PrecontractStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}