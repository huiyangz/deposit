package com.dcits.deposit.enums;

/** 账户类型 */
public enum AcctType {
    /** 垫款 */
    D("D"),
    /** 普通贷款 */
    M("M"),
    /** 贴现贷款 */
    U("U"),
    /** 储蓄账户 */
    S("S"),
    /** AIO账户 */
    A("A"),
    /** 结算账户 */
    C("C"),
    /** 定期账户 */
    T("T"),
    /** 资产证券化 */
    Z("Z"),
    /** 银团贷款 */
    Y("Y"),
    /** 转让贷款 */
    L("L"),
    /** 委托贷款 */
    E("E");

    private String value;

    private AcctType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcctType byValue(String value) {
        for (AcctType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}