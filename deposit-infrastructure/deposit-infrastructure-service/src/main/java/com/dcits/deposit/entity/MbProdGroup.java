package com.dcits.deposit.entity;

import java.math.BigDecimal;

public class MbProdGroup {
    /** 产品类型 */
    private String prodType;
    /** 产品子类型 */
    private String prodSubType;
    /** 序号 */
    private String seqNo;
    /** 默认产品标志 */
    private String defaultProdFlag;
    /** 账户类别 */
    private String acctClass;
    /** 存益贷产品分层金额 */
    private BigDecimal ratio;
    /** 法人 */
    private String company;
    /** 交易时间戳 */
    private String tranTimestamp;

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdSubType() {
        return prodSubType;
    }

    public void setProdSubType(String prodSubType) {
        this.prodSubType = prodSubType;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getDefaultProdFlag() {
        return defaultProdFlag;
    }

    public void setDefaultProdFlag(String defaultProdFlag) {
        this.defaultProdFlag = defaultProdFlag;
    }

    public String getAcctClass() {
        return acctClass;
    }

    public void setAcctClass(String acctClass) {
        this.acctClass = acctClass;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }
}