package com.dcits.deposit.enums;

/** 预约登记的账户类型 */
public enum PrecontractType {
    /** 预约 */
    P("P"),
    /** 非通知存款类型 */
    D("D"),
    /** 购买 */
    G("G"),
    /** 认购 */
    S("S"),
    /** 通知存款类型 */
    C("C"),
    /** 所有 */
    A("A");

    private String value;

    private PrecontractType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PrecontractType byValue(String value) {
        for (PrecontractType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}