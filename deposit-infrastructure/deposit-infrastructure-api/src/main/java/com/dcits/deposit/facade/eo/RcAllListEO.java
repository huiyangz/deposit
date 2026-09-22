package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.ListCategory;
import com.dcits.deposit.enums.ListOrg;
import com.dcits.deposit.enums.ListType;
import com.dcits.deposit.enums.SourceType;
import jakarta.validation.constraints.NotNull;

public class RcAllListEO {
    /** 黑名单数据类型 */
    private String dataType;
    /** 数据值 */
    private String dataValue;
    /** 名单类型代码 */
    private ListType listType;
    /** 客户号 */
    private String clientNo;
    /** 证件类型 */
    private DocumentType documentType;
    /** 客户名称 */
    private String clientName;
    /** 发证国家 */
    private IssCountry issCountry;
    /** 账户名称 */
    private String acctName;
    /** 我行黑名单标志 */
    private IndividualFlag ourBankFlag;
    /** 生效日期 */
    private java.util.Date effectDate;
    /** 到期日期 */
    private java.util.Date maturityDate;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 登记机构号 */
    private AcctBranch inputBranch;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 摘要 */
    private String narrative;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 法人 */
    private Company company;
    /** 名单种类 */
    private ListCategory listCategory;
    /** 名单送审机构号 */
    private ListOrg listOrg;
    /** 限制编号范围 */
    private String resSeqNos;
    /** 渠道控制编号集合 */
    private String controlNos;
    /** 关联账户核实标志 */
    private IndividualFlag relVerifyFlag;
    /** 黑名单序号 */
    @NotNull
    private String rcSeqNo;
    /** 当前账户限制标志 */
    private IndividualFlag curAcctResFlag;
    /** 其它账户限制标志 */
    private IndividualFlag otherAcctResFlag;
    /** 黑名单状态 */
    private AgreementStatus rcBlackStatus;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;

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

    public ListType getListType() {
        return listType;
    }

    public void setListType(ListType listType) {
        this.listType = listType;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public IssCountry getIssCountry() {
        return issCountry;
    }

    public void setIssCountry(IssCountry issCountry) {
        this.issCountry = issCountry;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public IndividualFlag getOurBankFlag() {
        return ourBankFlag;
    }

    public void setOurBankFlag(IndividualFlag ourBankFlag) {
        this.ourBankFlag = ourBankFlag;
    }

    public java.util.Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(java.util.Date effectDate) {
        this.effectDate = effectDate;
    }

    public java.util.Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(java.util.Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public AcctBranch getInputBranch() {
        return inputBranch;
    }

    public void setInputBranch(AcctBranch inputBranch) {
        this.inputBranch = inputBranch;
    }

    public AcctBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(AcctBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ListCategory getListCategory() {
        return listCategory;
    }

    public void setListCategory(ListCategory listCategory) {
        this.listCategory = listCategory;
    }

    public ListOrg getListOrg() {
        return listOrg;
    }

    public void setListOrg(ListOrg listOrg) {
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

    public IndividualFlag getRelVerifyFlag() {
        return relVerifyFlag;
    }

    public void setRelVerifyFlag(IndividualFlag relVerifyFlag) {
        this.relVerifyFlag = relVerifyFlag;
    }

    public String getRcSeqNo() {
        return rcSeqNo;
    }

    public void setRcSeqNo(String rcSeqNo) {
        this.rcSeqNo = rcSeqNo;
    }

    public IndividualFlag getCurAcctResFlag() {
        return curAcctResFlag;
    }

    public void setCurAcctResFlag(IndividualFlag curAcctResFlag) {
        this.curAcctResFlag = curAcctResFlag;
    }

    public IndividualFlag getOtherAcctResFlag() {
        return otherAcctResFlag;
    }

    public void setOtherAcctResFlag(IndividualFlag otherAcctResFlag) {
        this.otherAcctResFlag = otherAcctResFlag;
    }

    public AgreementStatus getRcBlackStatus() {
        return rcBlackStatus;
    }

    public void setRcBlackStatus(AgreementStatus rcBlackStatus) {
        this.rcBlackStatus = rcBlackStatus;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}