package com.dcits.deposit.enums;

/** 票据状态 */
public enum BillStatus {
    /** 已复核 */
    VALUE_01("01"),
    /** 已兑付 */
    VALUE_07("07"),
    /** 录入 */
    VALUE_00("00"),
    /** 已申请未用退回 */
    VALUE_10("10"),
    /** 已打印 */
    VALUE_03("03"),
    /** 已过期 */
    VALUE_09("09"),
    /** 已移存 */
    VALUE_05("05"),
    /** 已签章核对 */
    VALUE_04("04"),
    /** 已签发删除 */
    VALUE_06("06"),
    /** 已退回 */
    VALUE_08("08"),
    /** 已挂失 */
    VALUE_02("02");

    private String value;

    private BillStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BillStatus byValue(String value) {
        for (BillStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}