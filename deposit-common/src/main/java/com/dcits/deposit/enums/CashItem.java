package com.dcits.deposit.enums;

/** 现金项目 */
public enum CashItem {
    /** 商品销售收入 */
    VALUE_1("1"),
    /** 服务业收入 */
    VALUE_2("2"),
    /** 行政税费收入 */
    VALUE_3("3"),
    /** 城乡个体经营收入 */
    VALUE_4("4"),
    /** 储蓄存款收入 */
    VALUE_5("5"),
    /** 其他金融性公司收入 */
    VALUE_6("6"),
    /** 居民归还贷款收入 */
    VALUE_7("7"),
    /** 汇兑收入 */
    VALUE_8("8"),
    /** 有价证券及其他投资性收入 */
    VALUE_9("9"),
    /** 其他收入 */
    VALUE_10("10"),
    /** 其他收入-兑换外币收入 */
    VALUE_11("11"),
    /** 工资及对个人其他支出 */
    VALUE_20("20"),
    /** 产品采购支出 */
    VALUE_25("25"),
    /** 农副产品采购支出 */
    VALUE_26("26"),
    /** 行政企业管理和经营费支出 */
    VALUE_27("27"),
    /** 城乡个体经营支出 */
    VALUE_28("28"),
    /** 储蓄存款支出 */
    VALUE_29("29"),
    /** 其他金融性公司支出 */
    VALUE_30("30"),
    /** 居民提取贷款支出 */
    VALUE_31("31"),
    /** 汇兑支出 */
    VALUE_32("32"),
    /** 有价证券及其他投资性支出 */
    VALUE_33("33"),
    /** 其他支出 */
    VALUE_34("34"),
    /** 其他支出-兑换外币支出 */
    VALUE_35("35"),
    /** 工矿及其他产品采购支出 */
    VALUE_47("47");

    private String value;

    private CashItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CashItem byValue(String value) {
        for (CashItem item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}