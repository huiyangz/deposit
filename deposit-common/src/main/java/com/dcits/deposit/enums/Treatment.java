package com.dcits.deposit.enums;

/** 处置方式 */
public enum Treatment {
    /** 报告公安机关 */
    VALUE_03("03"),
    /** 关闭手机银行 */
    VALUE_07("07"),
    /** 未做处理 */
    VALUE_01("01"),
    /** 中止交易 */
    VALUE_05("05"),
    /** 关闭ATM转账 */
    VALUE_09("09"),
    /** 报告反洗钱部门 */
    VALUE_02("02"),
    /** 报告人民银行 */
    VALUE_04("04"),
    /** 关闭网银 */
    VALUE_06("06"),
    /** 关闭ATM取现 */
    VALUE_08("08"),
    /** 其他 */
    VALUE_10("10");

    private String value;

    private Treatment(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Treatment byValue(String value) {
        for (Treatment item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}