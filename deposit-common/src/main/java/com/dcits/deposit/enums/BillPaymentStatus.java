package com.dcits.deposit.enums;

/** 票据兑付状态 */
public enum BillPaymentStatus {
    /** 法院执行 */
    VALUE_19("19"),
    /** 已逾期退回 */
    VALUE_16("16"),
    /** 已申请未退回 */
    VALUE_14("14"),
    /** 已全额兑付 */
    VALUE_12("12"),
    /** 已未用退回 */
    VALUE_15("15"),
    /** 未兑付 */
    VALUE_11("11"),
    /** 已部分兑付 */
    VALUE_13("13"),
    /** 逾期兑付 */
    VALUE_18("18"),
    /** 正常兑付 */
    VALUE_17("17");

    private String value;

    private BillPaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BillPaymentStatus byValue(String value) {
        for (BillPaymentStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}