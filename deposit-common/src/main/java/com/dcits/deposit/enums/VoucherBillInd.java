package com.dcits.deposit.enums;

/** 凭证票据标识 */
public enum VoucherBillInd {
    /** 票据 */
    C("C"),
    /** 凭证 */
    V("V");

    private String value;

    private VoucherBillInd(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static VoucherBillInd byValue(String value) {
        for (VoucherBillInd item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}