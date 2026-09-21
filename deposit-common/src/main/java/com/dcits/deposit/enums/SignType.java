package com.dcits.deposit.enums;

/** 签约类型 */
public enum SignType {
    /** 理财(渠道整合) */
    VALUE_01("01"),
    /** 普惠宝(渠道整合) */
    VALUE_02("02"),
    /** 基金(渠道整合) */
    VALUE_03("03"),
    /** 电子国债(渠道整合) */
    VALUE_04("04"),
    /** 手机号转账(渠道整合) */
    VALUE_05("05"),
    /** 协议签约(渠道整合) */
    VALUE_06("06"),
    /** 云闪付(渠道整合) */
    VALUE_07("07"),
    /** 短信通(渠道整合) */
    VALUE_08("08"),
    /** 坐享其盈(渠道整合) */
    VALUE_09("09"),
    /** 易贷通(渠道整合) */
    VALUE_10("10"),
    /** 卡易贷(渠道整合) */
    VALUE_11("11"),
    /** 贷立省(渠道整合) */
    VALUE_12("12"),
    /** 代发工资(渠道整合) */
    VALUE_13("13"),
    /** 微信动账通知(渠道整合) */
    VALUE_14("14"),
    /** 财税库银(渠道整合) */
    VALUE_15("15"),
    /** 个人社保代缴费(渠道整合) */
    VALUE_16("16"),
    /** 协定存款协议 */
    ACC("ACC"),
    /** 日均余额靠档 */
    AVGBAL("AVGBAL"),
    /** 活期智能B产品 */
    BXD("BXD"),
    /** 存抵贷 */
    CDD("CDD"),
    /** 卡贷通 */
    CDT("CDT"),
    /** 统一签约 */
    COMMONAGREEMENT("COMMONAGREEMENT"),
    /** 存益贷 */
    DBC("DBC"),
    /** 企业网上银行签约类型 */
    EIB("EIB"),
    /** 电子汇票签约类型 */
    ES("ES"),
    /** 暂不收费签约 */
    FEE("FEE"),
    /** 卡理财签约 */
    FIN("FIN"),
    /** 智能存款 */
    ID("ID"),
    /** 加多利B */
    JDB("JDB"),
    /** 加多利 */
    JDL("JDL"),
    /** 灵活盈签约 */
    LHY("LHY"),
    /** 贷款协议 */
    LOA("LOA"),
    /** 新现金管理签约类型 */
    NCM("NCM"),
    /** 活期智能存款 */
    NTE("NTE"),
    /** 法人透支签约 */
    ODF("ODF"),
    /** 隐私账户签约 */
    PAS("PAS"),
    /** 周期性强制扣划 */
    PCD("PCD"),
    /** 费用套餐签约 */
    PKG("PKG"),
    /** 收取已到期费用套餐签约的套餐 */
    PKGC("PKGC"),
    /** 更新费用套餐签约 */
    PKGD("PKGD"),
    /** 回单签约 */
    REC("REC"),
    /** 小额免密签约 */
    SANP("SANP"),
    /** 金额补足签约(特殊贷款产品-卡易贷、卡贷通、英才贷) */
    SL("SL"),
    /** 短信协议 */
    SMS("SMS"),
    /** 账户清扫协议 */
    SWP("SWP"),
    /** 稳得利 */
    WDL("WDL"),
    /** 协定宝 */
    XDB("XDB"),
    /** 协定存款协议 */
    XDCK("XDCK"),
    /** 现金管理签约类型 */
    XGA("XGA"),
    /** 约定转存 */
    YD("YD"),
    /** 一户通协议 */
    YHT("YHT"),
    /** 直销银行签约类型 */
    ZXA("ZXA"),
    /** 坐享其盈 */
    ZXY("ZXY"),
    /** 智尊宝 */
    ZZB("ZZB");

    private String value;

    private SignType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SignType byValue(String value) {
        for (SignType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}