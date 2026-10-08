package com.dcits.depsit.enums;

/** 凭证挂失状态 */
public enum VoucherLostStatus {
    /** 挂失取消 */
    CAN("CAN"),
    /** 使用 */
    USE("USE");

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