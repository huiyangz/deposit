package com.dcits.deposit.enums;

/** 凭证挂失状态 */
public enum VoucherLostStatus {
    /** 失效 */
    E("E"),
    /** 生效 */
    A("A");

    private String value;

    private VoucherLostStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static VoucherLostStatus byValue(String value) {
        for (VoucherLostStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}