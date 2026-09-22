package com.dcits.deposit.enums;

/** 结售汇撤销原因 */
public enum ExchangeCancelReason {
    /** 国家/地区录入错误 */
    VALUE_03("03"),
    /** 业务类型录入错误 */
    VALUE_04("04"),
    /** 证件号码录入错误 */
    VALUE_02("02"),
    /** 证件类型录入错误 */
    VALUE_01("01"),
    /** 其他 */
    VALUE_06("06"),
    /** 现钞业务未实际发生 */
    VALUE_05("05");

    private String value;

    private ExchangeCancelReason(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ExchangeCancelReason byValue(String value) {
        for (ExchangeCancelReason item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}