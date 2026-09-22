package com.dcits.deposit.enums;

/** 账户核实状态 */
public enum AcctVerifyResult {
    /** 真实已核实未面核 */
    VALUE_09("09"),
    /** 真实需重核实 */
    VALUE_08("08"),
    /** 在有疑义时销户 */
    VALUE_07("07"),
    /** 虚假 */
    VALUE_03("03"),
    /** 无法核实 */
    VALUE_06("06"),
    /** 匿名 */
    VALUE_05("05"),
    /** 真实已核实已面核 */
    VALUE_02("02"),
    /** 假名 */
    VALUE_04("04"),
    /** 未核实 */
    VALUE_01("01");

    private String value;

    private AcctVerifyResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AcctVerifyResult byValue(String value) {
        for (AcctVerifyResult item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}