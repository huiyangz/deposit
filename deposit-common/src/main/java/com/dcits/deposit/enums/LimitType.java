package com.dcits.deposit.enums;

/** 限额类型 */
public enum LimitType {
    /** 风险抵补类限额 */
    VALUE_1("1"),
    /** 风险收益类限额 */
    VALUE_2("2"),
    /** 资产质量类限额 */
    VALUE_3("3"),
    /** 监管类限额 */
    VALUE_4("4"),
    /** 业务结构类限额 */
    VALUE_5("5"),
    /** 公司业务类限额 */
    VALUE_6("6"),
    /** 金融市场类限额 */
    VALUE_7("7"),
    /** 其他类限额 */
    VALUE_99("99"),
    /** 每天累计笔数限制 */
    ND("ND"),
    /** 每年累计笔数限制 */
    NY("NY"),
    /** 自定义限额 */
    PC("PC"),
    /** 每天累计金额限制 */
    PD("PD"),
    /** 每月累计金额限制 */
    PM("PM"),
    /** 单笔交易 */
    PT("PT"),
    /** 每周限额 */
    PW("PW"),
    /** 每年累计金额限制 */
    PY("PY");

    private String value;

    private LimitType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static LimitType byValue(String value) {
        for (LimitType item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}