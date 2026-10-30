package com.dcits.deposit.enums;

/** 产品基础事件 */
public enum EventDefault {
    /** 计提 */
    ACR("ACR"),
    /** 计提调整 */
    ADJ("ADJ"),
    /** 签约 */
    AGRE("AGRE"),
    /** 通知存款按预约支取 */
    ARR("ARR"),
    /** 利息资本化 */
    CAP("CAP"),
    /** 销户 */
    CLOSE("CLOSE"),
    /** 承诺 */
    COM("COM"),
    /** 贷记入账 */
    CRET("CRET"),
    /** 结息 */
    CYCLE("CYCLE"),
    /** 借记扣账 */
    DEBT("DEBT"),
    /** 发放 */
    DRW("DRW"),
    /** 到期 */
    DUE("DUE"),
    /** 终止 */
    END("END"),
    /** 通知存款违约支取 */
    FAD("FAD"),
    /** 宽限期回收 */
    GREC("GREC"),
    /** 预算利息 */
    INQ("INQ"),
    /** 利率变更 */
    IRC("IRC"),
    /** 发放到期 */
    MAT("MAT"),
    /** 到期支取/回收 */
    MRT("MRT"),
    /** 教育储蓄到期支取（无证明） */
    MRTC("MRTC"),
    /** 开户 */
    OPEN("OPEN"),
    /** 支取不结息 */
    PCP("PCP"),
    /** 提前支取/回收 */
    PRE("PRE"),
    /** 提前支取（违约） */
    PREA("PREA"),
    /** 教育储蓄提前支取（无证明） */
    PREC("PREC"),
    /** 逾期支取/回收 */
    PSD("PSD"),
    /** 回收 */
    REC("REC"),
    /** 转存 */
    RENEW("RENEW"),
    /** 核销 */
    WRO("WRO");

    private String value;

    private EventDefault(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EventDefault byValue(String value) {
        for (EventDefault item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}