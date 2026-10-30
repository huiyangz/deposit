package com.dcits.deposit.enums;

/** 货币币种 */
public enum Ccy {
    /** 澳大利亚元 */
    AUD("AUD"),
    /** 加元 */
    CAD("CAD"),
    /** 瑞士法郎 */
    CHF("CHF"),
    /** 人民币元 */
    CNY("CNY"),
    /** 欧元 */
    EUR("EUR"),
    /** 英镑 */
    GBP("GBP"),
    /** 香港元 */
    HKD("HKD"),
    /** 日元 */
    JPY("JPY"),
    /** 韩元 */
    KRW("KRW"),
    /** 俄罗斯卢布 */
    RUB("RUB"),
    /** 新加坡元 */
    SGD("SGD"),
    /** 美元 */
    USD("USD");

    private String value;

    private Ccy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Ccy byValue(String value) {
        for (Ccy item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}