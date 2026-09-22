package com.dcits.deposit.enums;

/** 转存类型 */
public enum MovtStatus {
    /** 全部提前支取 */
    F("F"),
    /** 利息支取/到期全部支取 */
    I("I"),
    /** 调整结息 */
    Z("Z"),
    /** 到期部分支取 */
    M("M"),
    /** 逾期支取 */
    D("D"),
    /** 前付息冲正(逆向交易冲正处理) */
    U("U"),
    /** 默认通知存款算法 违约统一按照逾期计算利息 */
    W("W"),
    /** 定活两便 */
    L("L"),
    /** 续存 */
    X("X"),
    /** 一户通 */
    O("O"),
    /** 加多利协议计息 */
    J("J"),
    /** 前付息 */
    H("H"),
    /** 账户补差结息(e.g.一本万利) */
    Y("Y"),
    /** 定期存入 */
    A("A"),
    /** 提前付息(e.g.按频率付息) */
    E("E"),
    /** 一本万利 */
    B("B"),
    /** 反冲前付息 */
    T("T"),
    /** 整整手工结息 */
    S("S"),
    /** 反冲提前付息 */
    G("G"),
    /** 到期全部支取 */
    R("R"),
    /** 强制扣划结息 */
    Q("Q"),
    /** 部分提前支取 */
    P("P"),
    /** 内部账户结息 */
    K("K"),
    /** 复杂通知存款算法 部分违约支取按照通知存款计算利息 */
    V("V");

    private String value;

    private MovtStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MovtStatus byValue(String value) {
        for (MovtStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}