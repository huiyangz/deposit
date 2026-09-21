package com.dcits.deposit.enums;

/** 联网核查结果 */
public enum VerificationResult {
    /** 无法核实 */
    VALUE_06("06"),
    /** 已核实 */
    VALUE_00("00"),
    /** 虚假 */
    VALUE_03("03"),
    /** 假名 */
    VALUE_04("04"),
    /** 未核实 */
    VALUE_01("01"),
    /** 匿名 */
    VALUE_05("05"),
    /** 真实 */
    VALUE_02("02"),
    /** 在有疑义时销户 */
    VALUE_07("07");

    private String value;

    private VerificationResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static VerificationResult byValue(String value) {
        for (VerificationResult item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}