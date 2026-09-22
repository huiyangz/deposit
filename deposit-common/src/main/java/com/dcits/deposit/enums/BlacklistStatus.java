package com.dcits.deposit.enums;

/** 黑名单状态 */
public enum BlacklistStatus {
    /** II */
    VALUE_03("03"),
    /** 已核实-未推送 */
    VALUE_00("00"),
    /** 已核实-已推送 */
    VALUE_01("01"),
    /** 个月无交易未核实 */
    VALUE_02("02");

    private String value;

    private BlacklistStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BlacklistStatus byValue(String value) {
        for (BlacklistStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}