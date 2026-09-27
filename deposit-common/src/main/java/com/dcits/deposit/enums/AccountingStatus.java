package com.dcits.deposit.enums;

/** 核算状态 */
public enum AccountingStatus {
    /** 呆滞(手工) */
    DZ("DZ"),
    /** 呆账 */
    DZA("DZA"),
    /** 呆滞 */
    DZI("DZI"),
    /** 非应计(手工) */
    FY("FY"),
    /** 非应计 */
    FYJ("FYJ"),
    /** 终止 */
    TER("TER"),
    /** 核销 */
    WRN("WRN"),
    /** 逾期 */
    YUQ("YUQ"),
    /** 正常 */
    ZHC("ZHC");

    private String value;

    private AccountingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AccountingStatus byValue(String value) {
        for (AccountingStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}