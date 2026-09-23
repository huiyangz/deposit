package com.dcits.deposit.enums;

/** 结算账户分类 */
public enum SettleAcctClass {
    /** 代垫还款账户 */
    ADA("ADA"),
    /** 约定转账协议账户 */
    AGT("AGT"),
    /** 自动结清自动扣款账户 */
    AUS("AUS"),
    /** 自动扣款账户 */
    AUT("AUT"),
    /** 全部本金转存利息入账账户 */
    CON("CON"),
    /** 部分本金转存账户 */
    COP("COP"),
    /** 资金归集账户 */
    FDU("FDU"),
    /** 利息入账账户 */
    INT("INT"),
    /** 票据池保证金账户 */
    MAR("MAR"),
    /** 付款账户 */
    PAY("PAY"),
    /** 本金入账账户 */
    PRI("PRI"),
    /** 收款账户 */
    REC("REC"),
    /** 关联账户 */
    REL("REL"),
    /** 资金来源账户 */
    SOR("SOR"),
    /** 贴息账户 */
    SSI("SSI"),
    /** 第三方账户 */
    TPP("TPP"),
    /** 定期自动转活期账户 */
    TRA("TRA"),
    /** 折扣账户 */
    UI("UI"),
    /** 理赔账户 */
    WCA("WCA"),
    /** 委托存款账户 */
    WTR("WTR"),
    /** 委托结算账户 */
    WTS("WTS");

    private String value;

    private SettleAcctClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SettleAcctClass byValue(String value) {
        for (SettleAcctClass item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}