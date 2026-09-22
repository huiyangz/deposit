package com.dcits.deposit.enums;

/** 申报客户类型 */
public enum ExchangeReportType {
    /** 对私中国居民 */
    D("D"),
    /** 对私中国非居民 */
    F("F"),
    /** 对公用户 */
    C("C");

    private String value;

    private ExchangeReportType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExchangeReportType byValue(String value) {
        for (ExchangeReportType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}