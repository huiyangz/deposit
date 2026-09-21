package com.dcits.deposit.enums;

/** 联系人类型 */
public enum LinkmanType {
    /** 企业法人代表 */
    VALUE_01("01"),
    /** 财务主管 */
    VALUE_02("02"),
    /** 财务人员1 */
    VALUE_03("03"),
    /** 财务人员2 */
    VALUE_04("04");

    private String value;

    private LinkmanType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static LinkmanType byValue(String value) {
        for (LinkmanType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}