package com.dcits.deposit.enums;

/** 金额类型 */
public enum IntCalcAmtType {
    /** 余额积数 */
    AGG("AGG"),
    /** 本加息 */
    ALL("ALL"),
    /** 积数累计天数 */
    AND("AND"),
    /** 日均余额 */
    AVG("AVG"),
    /** 余额 */
    BAL("BAL"),
    /** 通知金额（通知存款专用） */
    CALL_AMT("CALL_AMT"),
    /** 通知利率算息金额 */
    CON("CON"),
    /** 抵债资产入账的金额类型 */
    DAMT("DAMT"),
    /** 日均余额(利息靠档金额类型) */
    DAY_AVG("DAY_AVG"),
    /** 发放金额 */
    DDA("DDA"),
    /** 起存金额 */
    DEA("DEA"),
    /** 抵债资产处置的金额类型 */
    DOA("DOA"),
    /** 账户久悬金额 */
    DOS("DOS"),
    /** 贴现溢价 */
    DP("DP"),
    /** 前收息金额 */
    DS("DS"),
    /** 费用 */
    FEE("FEE"),
    /** 逾期费用 */
    FEEP("FEEP"),
    /** 宽限期利息 */
    GINTP("GINTP"),
    /** 宽限期复利 */
    GODIP("GODIP"),
    /** 宽限期罚息 */
    GODPP("GODPP"),
    /** 宽限期本金 */
    GPRD("GPRD"),
    /** 利息 */
    INT("INT"),
    /** 当天到期利息 */
    INTD("INTD"),
    /** 逾期利息 */
    INTP("INTP"),
    /** 额度金额 */
    LIM("LIM"),
    /** 营业外支出/减值损失/拨备金额类型 */
    LOSS("LOSS"),
    /** 月积数 */
    MOA("MOA"),
    /** 月均余额(利息靠档金额类型) */
    MON_AVG("MON_AVG"),
    /** 月均余额 */
    MVG("MVG"),
    /** 净利息 */
    NET("NET"),
    /** 透支金额 */
    OD("OD"),
    /** 透支金额 */
    ODA("ODA"),
    /** 复利 */
    ODI("ODI"),
    /** 当天到期复利 */
    ODID("ODID"),
    /** 逾期复利 */
    ODIP("ODIP"),
    /** 复利的复利 */
    ODODI("ODODI"),
    /** 罚息的复利 */
    ODODP("ODODP"),
    /** 罚息 */
    ODP("ODP"),
    /** 当天到期罚息 */
    ODPD("ODPD"),
    /** 逾期罚息 */
    ODPP("ODPP"),
    /** 未到期本金 */
    OSL("OSL"),
    /** 净本金 */
    PF("PF"),
    /** 逾期本金 */
    PRD("PRD"),
    /** 上日余额 */
    PRE_BAL("PRE_BAL"),
    /** 提前结清手续费 */
    PRF("PRF"),
    /** 本金 */
    PRI("PRI"),
    /** 营业外收入金额类型 */
    REVE("REVE"),
    /** 利息税 */
    TAX("TAX"),
    /** 交易金额（违约金额） */
    TRA("TRA"),
    /** 交易金额（通知存款专用） */
    TRAN_AMT("TRAN_AMT"),
    /** 违约积数（通知存款专用） */
    TRA_AGG("TRA_AGG"),
    /** 未实现利息 */
    UI("UI"),
    /** 非本金 */
    UNI("UNI"),
    /** 通知违约利率算息金额 */
    WY_CON("WY_CON"),
    /** 年均余额 */
    YVG("YVG");

    private String value;

    private IntCalcAmtType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IntCalcAmtType byValue(String value) {
        for (IntCalcAmtType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}