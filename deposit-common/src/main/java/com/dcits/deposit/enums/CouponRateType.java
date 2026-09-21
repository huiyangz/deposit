package com.dcits.deposit.enums;

/** 优惠汇率使用场景 */
public enum CouponRateType {
    /** 售汇 */
    S("S"),
    /** 结汇+售汇 */
    A("A"),
    /** 结汇 */
    B("B");

    private String value;

    private CouponRateType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CouponRateType byValue(String value) {
        for (CouponRateType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}