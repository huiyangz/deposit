package com.dcits.deposit.enums;

/** 风险限额编码 */
public enum LimitRef {
    /** 非绑定账户入账限额编码 */
    NOBINDCRLIMIT("NoBindCrLimit"),
    /** 非柜面日限额编码 */
    NOMTLIMIT("NoMTLimit"),
    /** 已用非柜面笔数编码 */
    ALRNOMTLIMIT("AlrNoMTLimit"),
    /** 已用非绑定账户出账限额编码 */
    ALRNOBINDDRLIMITPY("AlrNoBindDrLimitPy"),
    /** 非绑定账户出账限额编码 */
    NOBINDDRLIMIT("NoBindDrLimit"),
    /** 已用非绑定账户入账限额编码 */
    ALRNOBINDCRLIMIT("AlrNoBindCrLimit");

    private String value;

    private LimitRef(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static LimitRef byValue(String value) {
        for (LimitRef item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}