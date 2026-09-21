package com.dcits.deposit.entity;

import java.util.Date;

public class RcAllList {
    /** 黑名单数据类型 */
    private String dataType;
    /** 数据值 */
    private String dataValue;
    /** 名单类型代码 */
    private String listType;
    /** 客户号 */
    private String clientNo;
    /** 证件类型 */
    private String documentType;
    /** 客户名称 */
    private String clientName;
    /** 发证国家 */
    private String issCountry;
    /** 账户名称 */
    private String acctName;
    /** 我行黑名单标志 */
    private String ourBankFlag;
    /** 生效日期 */
    private Date effectDate;
    /** 到期日期 */
    private Date maturityDate;
    /** 交易日期 */
    private Date tranDate;
    /** 登记机构号 */
    private String inputBranch;
    /** 交易机构号 */
    private String tranBranch;
    /** 渠道类型 */
    private String sourceType;
    /** 摘要 */
    private String narrative;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 法人 */
    private String company;
    /** 名单种类 */
    private String listCategory;
    /** 名单送审机构号 */
    private String listOrg;
    /** 限制编号范围 */
    private String resSeqNos;
    /** 渠道控制编号集合 */
    private String controlNos;
    /** 关联账户核实标志 */
    private String relVerifyFlag;
    /** 黑名单序号 */
    private String rcSeqNo;
    /** 当前账户限制标志 */
    private String curAcctResFlag;
    /** 其它账户限制标志 */
    private String otherAcctResFlag;
    /** 黑名单状态 */
    private String rcBlackStatus;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(String issCountry) {
        this.issCountry = issCountry;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getOurBankFlag() {
        return ourBankFlag;
    }

    public void setOurBankFlag(String ourBankFlag) {
        this.ourBankFlag = ourBankFlag;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }

    public String getInputBranch() {
        return inputBranch;
    }

    public void setInputBranch(String inputBranch) {
        this.inputBranch = inputBranch;
    }

    public String getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(String tranBranch) {
        this.tranBranch = tranBranch;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getListCategory() {
        return listCategory;
    }

    public void setListCategory(String listCategory) {
        this.listCategory = listCategory;
    }

    public String getListOrg() {
        return listOrg;
    }

    public void setListOrg(String listOrg) {
        this.listOrg = listOrg;
    }

    public String getResSeqNos() {
        return resSeqNos;
    }

    public void setResSeqNos(String resSeqNos) {
        this.resSeqNos = resSeqNos;
    }

    public String getControlNos() {
        return controlNos;
    }

    public void setControlNos(String controlNos) {
        this.controlNos = controlNos;
    }

    public String getRelVerifyFlag() {
        return relVerifyFlag;
    }

    public void setRelVerifyFlag(String relVerifyFlag) {
        this.relVerifyFlag = relVerifyFlag;
    }

    public String getRcSeqNo() {
        return rcSeqNo;
    }

    public void setRcSeqNo(String rcSeqNo) {
        this.rcSeqNo = rcSeqNo;
    }

    public String getCurAcctResFlag() {
        return curAcctResFlag;
    }

    public void setCurAcctResFlag(String curAcctResFlag) {
        this.curAcctResFlag = curAcctResFlag;
    }

    public String getOtherAcctResFlag() {
        return otherAcctResFlag;
    }

    public void setOtherAcctResFlag(String otherAcctResFlag) {
        this.otherAcctResFlag = otherAcctResFlag;
    }

    public String getRcBlackStatus() {
        return rcBlackStatus;
    }

    public void setRcBlackStatus(String rcBlackStatus) {
        this.rcBlackStatus = rcBlackStatus;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}