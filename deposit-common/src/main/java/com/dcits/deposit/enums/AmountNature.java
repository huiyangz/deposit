package com.dcits.deposit.enums;

/** 资金性质 */
public enum AmountNature {
    /** 存放境外银行 */
    A024("A024"),
    /** 收入汇缴资金和业务支出资金账户 */
    A021("A021"),
    /** 其他需要专项管理和使用的资金账户 */
    A023("A023"),
    /** 财政预算外资金账户 */
    A011("A011"),
    /** 境内银行业存款类金融机构存放 */
    A001("A001"),
    /** 境内其他金融机构存放 */
    A007("A007"),
    /** 境内交易及结算类金融机构存放 */
    A005("A005"),
    /** 期货交易保证金账户 */
    A014("A014"),
    /** 境内证券业金融机构存放 */
    A004("A004"),
    /** 金融机构存放同业资金账户 */
    A016("A016"),
    /** 粮、棉、油收购资金账户 */
    A012("A012"),
    /** 境内金融控股公司存放 */
    A003("A003"),
    /** 境内特殊目的载体存放 */
    A008("A008"),
    /** 单位银行卡备用金账户 */
    A018("A018"),
    /** 社会保障基金账户 */
    A020("A020"),
    /** 更新改造资金账户 */
    A010("A010"),
    /** 证券交易结算资金账户 */
    A013("A013"),
    /** 住房基金账户 */
    A019("A019"),
    /** 党、团、工会设在单位的组织机构经费账户 */
    A022("A022"),
    /** 境内银行业非存款类金融机构存放 */
    A006("A006"),
    /** 境内保险业金融机构存放 */
    A002("A002"),
    /** 政策性房地产开发资金账户 */
    A017("A017"),
    /** 信托基金账户 */
    A015("A015"),
    /** 基本建设资金账户 */
    A009("A009");

    private String value;

    private AmountNature(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AmountNature byValue(String value) {
        for (AmountNature item : values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }
}