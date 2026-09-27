package com.dcits.deposit.enums;

/** 凭证批准状态 */
public enum VoucherApproveStatus {
    /** 已批准 */
    A("A"),
    /** 已录入但未批准 */
    E("E");

    private String value;

    private VoucherApproveStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static VoucherApproveStatus byValue(String value) {
        for (VoucherApproveStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}