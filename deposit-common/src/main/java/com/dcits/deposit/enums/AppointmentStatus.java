package com.dcits.deposit.enums;

/** 客户预约状态 */
public enum AppointmentStatus {
    /** 预约已到期 */
    D("D"),
    /** 预约已撤销 */
    DE("DE"),
    /** 预约已完成 */
    DS("DS"),
    /** 预约成功 */
    S("S");

    private String value;

    private AppointmentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AppointmentStatus byValue(String value) {
        for (AppointmentStatus item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}