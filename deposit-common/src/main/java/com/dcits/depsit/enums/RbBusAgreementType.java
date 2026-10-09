package com.dcits.depsit.enums;

/** 对公存款合约类型 */
public enum RbBusAgreementType {
    /** 协定存款协议 */
    ACC("ACC"),
    /** 协定利率（无留存） */
    BXD("BXD"),
    /** 电票签约 */
    ES("ES"),
    /** 智能存款协议 */
    ID("ID"),
    /** 加多利 */
    JDL("JDL"),
    /** 活期智能存款 */
    NTE("NTE"),
    /** 法人透支协议 */
    ODF("ODF"),
    /** 资金池 */
    PCP("PCP"),
    /** 回单签约 */
    REC("REC"),
    /** 稳得利 */
    WDL("WDL"),
    /** 协定宝 */
    XDB("XDB"),
    /** 协定存款产品 */
    XDCK("XDCK"),
    /** 一户通 */
    YHT("YHT"),
    /** 单位智能通知 */
    ZNT("ZNT"),
    /** 至尊宝 */
    ZZB("ZZB"),
    /** 大额存单 */
    DC("DC"),
    /** 暂不收费 */
    FEE("FEE"),
    /** 周期性强制扣划 */
    PCD("PCD"),
    /** 费用套餐 */
    PKG("PKG"),
    /** 额补足协议 */
    SL("SL"),
    /** 短信 */
    SMS("SMS"),
    /** 微信 */
    W("W");

    private String value;

    private RbBusAgreementType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RbBusAgreementType byValue(String value) {
        for (RbBusAgreementType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}