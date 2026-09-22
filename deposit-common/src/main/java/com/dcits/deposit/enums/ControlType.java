package com.dcits.deposit.enums;

/** 控制类型 */
public enum ControlType {
    /** 放款交易 */
    DRW("DRW"),
    /** 网上银行渠道控制 */
    VALUE_01("01"),
    /** 网关支付渠道控制 */
    VALUE_03("03"),
    /** ATM/CRS渠道控制 */
    VALUE_06("06"),
    /** 还款交易 */
    REC("REC"),
    /** 减损性控制 */
    VALUE_3("3"),
    /** POS机渠道控制 */
    VALUE_05("05"),
    /** 预防性控制 */
    VALUE_1("1"),
    /** 手机银行渠道控制 */
    VALUE_02("02"),
    /** 全部 */
    ALL("ALL"),
    /** 识别性控制 */
    VALUE_2("2"),
    /** 暂停非柜面 */
    VALUE_00("00"),
    /** 快捷支付渠道控制 */
    VALUE_04("04");

    private String value;

    private ControlType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ControlType byValue(String value) {
        for (ControlType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}