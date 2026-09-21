package com.dcits.deposit.enums;

/** 现钞提取用途说明 */
public enum CashUseRemark {
    /** 其他 */
    VALUE_08("08"),
    /** 境外代表处（办事处）办公经费 */
    VALUE_03("03"),
    /** 对台小额贸易 */
    VALUE_06("06"),
    /** 对台小额商品交易市场 */
    VALUE_07("07"),
    /** 对外劳务合作或对外承包工程 */
    VALUE_02("02"),
    /** 司法和行政执法机关的罚没款、暂扣款和专项收缴款 */
    VALUE_05("05"),
    /** 公务出国 */
    VALUE_04("04"),
    /** 船长借支 */
    VALUE_01("01");

    private String value;

    private CashUseRemark(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CashUseRemark byValue(String value) {
        for (CashUseRemark item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}