package com.dcits.deposit.enums;

/** 协议类型 */
public enum AgreementType {
    /** 协定存款协议 */
    ACC("ACC"),
    /** 协定利率（无留存） */
    BXD("BXD"),
    /** 存立得 */
    CLD("CLD"),
    /** 大额存单 */
    DC("DC"),
    /** 贷利省 */
    DLS("DLS"),
    /** 电票签约 */
    ES("ES"),
    /** 暂不收费 */
    FEE("FEE"),
    /** 卡理财协议 */
    FIN("FIN"),
    /** 活期宝 */
    HQB("HQB"),
    /** 智能存款协议 */
    ID("ID"),
    /** 加多利 */
    JDL("JDL"),
    /** 卡贷通 */
    KDT("KDT"),
    /** 卡易贷 */
    KYD("KYD"),
    /** 贷款 */
    LOA("LOA"),
    /** 活期智能存款 */
    NTE("NTE"),
    /** 法人透支协议 */
    ODF("ODF"),
    /** 隐私账户签约 */
    PAS("PAS"),
    /** 周期性强制扣划 */
    PCD("PCD"),
    /** 资金池 */
    PCP("PCP"),
    /** 费用套餐 */
    PKG("PKG"),
    /** 回单签约 */
    REC("REC"),
    /** 额补足协议 */
    SL("SL"),
    /** 短信 */
    SMS("SMS"),
    /** 账户清扫协议 */
    SWP("SWP"),
    /** 稳得利 */
    WDL("WDL"),
    /** 协定宝 */
    XDB("XDB"),
    /** 协定存款产品 */
    XDCK("XDCK"),
    /** 先得利 */
    XDL("XDL"),
    /** 一本万利 */
    YBWL("YBWL"),
    /** 英才贷 */
    YCD("YCD"),
    /** 约定 */
    YD("YD"),
    /** 易贷通 */
    YDT("YDT"),
    /** 一户通 */
    YHT("YHT"),
    /** 周享赢 */
    ZHY("ZHY"),
    /** 单位智能通知 */
    ZNT("ZNT"),
    /** 坐享其盈 */
    ZXY("ZXY"),
    /** 至尊宝 */
    ZZB("ZZB");

    private String value;

    private AgreementType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AgreementType byValue(String value) {
        for (AgreementType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}