package com.dcits.deposit.enums;

/** 现钞来源说明 */
public enum CashSourceRemark {
    /** 司法和行政执法机关的罚没款、暂扣款和专项收缴款 */
    VALUE_03("03"),
    /** 销售免 */
    VALUE_06("06"),
    /** 旅游购物商品 */
    VALUE_05("05"),
    /** 机场或港口零星现钞收入 */
    VALUE_02("02"),
    /** 宗教类接收捐赠现钞收入 */
    VALUE_04("04"),
    /** 已提取未使用完现钞 */
    VALUE_01("01");

    private String value;

    private CashSourceRemark(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CashSourceRemark byValue(String value) {
        for (CashSourceRemark item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}