package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BatchStatus;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RbBatchTranDetailsEO {
    /** 批量明细序号 */
    @NotNull
    private String batchSeqNo;
    /** 批次号 */
    @NotNull
    private String batchNo;
    /** 序号 */
    private String seqNo;
    /** 批处理任务ID */
    private String jobRunId;
    /** 渠道流水号 */
    private String channelSeqNo;
    /** 交易参考号 */
    private String reference;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 账号/卡号 */
    private String baseAcctNo;
    /** 产品类型 */
    private String prodType;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 账户序号 */
    private String acctSeqNo;
    /** 账户开立行行号 */
    private AcctBranch acctBranch;
    /** 客户类型 */
    private ClientType clientType;
    /** 账户描述 */
    private String acctDesc;
    /** 凭证类型 */
    private DocType docType;
    /** 凭证前缀编码 */
    private String prefix;
    /** 凭证号 */
    private String voucherNo;
    /** 清算日期 */
    private java.util.Date settlementDate;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 交易机构号 */
    private AcctBranch tranBranch;
    /** 渠道 */
    private SourceType channel;
    /** 交易类型 */
    private TranType tranType;
    /** 交易金额 */
    private BigDecimal tranAmt;
    /** 币种 */
    private AcctCcy ccy;
    /** 服务费收取标志 */
    private IndividualFlag servCharge;
    /** 交易描述 */
    private String tranDesc;
    /** 交易附言 */
    private String tranNote;
    /** 科目代码 */
    private String glCode;
    /** 冻结流水号 */
    private String fhSeqNo;
    /** 摘要 */
    private String narrative;
    /** 对方交易类型 */
    private TranType othTranType;
    /** 对手交易业务流水号 */
    private String othReference;
    /** 对手交易流水号 */
    private String othSeqNo;
    /** 对手科目代码 */
    private String othGlCode;
    /** 交易对手名称 */
    private String othTranName;
    /** 对方账户开户行行号 */
    private AcctBranch othBranch;
    /** 对手账号 */
    private String othBaseAcctNo;
    /** 对手产品编号 */
    private String othProdType;
    /** 对手账户币种 */
    private AcctCcy othAcctCcy;
    /** 对方账户序号 */
    private String othAcctSeqNo;
    /** 对方账户描述 */
    private String othAcctDesc;
    /** 对手银行行号 */
    private String othBankCode;
    /** 对手银行名称 */
    private String othBankName;
    /** 批处理状态 */
    private BatchStatus batchStatus;
    /** 备注1 */
    private String remark1;
    /** 备注2 */
    private String remark2;
    /** 备注3 */
    private String remark3;
    /** 备注4 */
    private String remark4;
    /** 备注5 */
    private String remark5;
    /** 服务状态描述 */
    private String retMsg;
    /** 错误码 */
    private String errorCode;
    /** 错误描述 */
    private String errorDesc;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 交易柜员号 */
    private String userId;
    /** 法人 */
    private Company company;
    /** 摘要码 */
    private String narrativeCode;
    /** 真实对方金融机构名称 */
    private String othRealBankName;
    /** 实际对手机构号 */
    private String othRealBankCode;
    /** 实际对手账号 */
    private String othRealBaseAcctNo;
    /** 实际对手身份证件号码 */
    private String othRealDocumentId;
    /** 实际对手产品编号 */
    private String othRealProdType;
    /** 实际对手证件类型 */
    private DocumentType othRealDocumentType;
    /** 实际对手交易地址 */
    private String othRealTranAddr;
    /** 实际对手交易名称 */
    private String othRealTranName;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 业务处理状态 */
    private TranStatus tranStatus;

    public String getBatchSeqNo() {
        return batchSeqNo;
    }

    public void setBatchSeqNo(String batchSeqNo) {
        this.batchSeqNo = batchSeqNo;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getJobRunId() {
        return jobRunId;
    }

    public void setJobRunId(String jobRunId) {
        this.jobRunId = jobRunId;
    }

    public String getChannelSeqNo() {
        return channelSeqNo;
    }

    public void setChannelSeqNo(String channelSeqNo) {
        this.channelSeqNo = channelSeqNo;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public AcctBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(AcctBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getAcctDesc() {
        return acctDesc;
    }

    public void setAcctDesc(String acctDesc) {
        this.acctDesc = acctDesc;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public java.util.Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(java.util.Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public AcctBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(AcctBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public SourceType getChannel() {
        return channel;
    }

    public void setChannel(SourceType channel) {
        this.channel = channel;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public AcctCcy getCcy() {
        return ccy;
    }

    public void setCcy(AcctCcy ccy) {
        this.ccy = ccy;
    }

    public IndividualFlag getServCharge() {
        return servCharge;
    }

    public void setServCharge(IndividualFlag servCharge) {
        this.servCharge = servCharge;
    }

    public String getTranDesc() {
        return tranDesc;
    }

    public void setTranDesc(String tranDesc) {
        this.tranDesc = tranDesc;
    }

    public String getTranNote() {
        return tranNote;
    }

    public void setTranNote(String tranNote) {
        this.tranNote = tranNote;
    }

    public String getGlCode() {
        return glCode;
    }

    public void setGlCode(String glCode) {
        this.glCode = glCode;
    }

    public String getFhSeqNo() {
        return fhSeqNo;
    }

    public void setFhSeqNo(String fhSeqNo) {
        this.fhSeqNo = fhSeqNo;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public TranType getOthTranType() {
        return othTranType;
    }

    public void setOthTranType(TranType othTranType) {
        this.othTranType = othTranType;
    }

    public String getOthReference() {
        return othReference;
    }

    public void setOthReference(String othReference) {
        this.othReference = othReference;
    }

    public String getOthSeqNo() {
        return othSeqNo;
    }

    public void setOthSeqNo(String othSeqNo) {
        this.othSeqNo = othSeqNo;
    }

    public String getOthGlCode() {
        return othGlCode;
    }

    public void setOthGlCode(String othGlCode) {
        this.othGlCode = othGlCode;
    }

    public String getOthTranName() {
        return othTranName;
    }

    public void setOthTranName(String othTranName) {
        this.othTranName = othTranName;
    }

    public AcctBranch getOthBranch() {
        return othBranch;
    }

    public void setOthBranch(AcctBranch othBranch) {
        this.othBranch = othBranch;
    }

    public String getOthBaseAcctNo() {
        return othBaseAcctNo;
    }

    public void setOthBaseAcctNo(String othBaseAcctNo) {
        this.othBaseAcctNo = othBaseAcctNo;
    }

    public String getOthProdType() {
        return othProdType;
    }

    public void setOthProdType(String othProdType) {
        this.othProdType = othProdType;
    }

    public AcctCcy getOthAcctCcy() {
        return othAcctCcy;
    }

    public void setOthAcctCcy(AcctCcy othAcctCcy) {
        this.othAcctCcy = othAcctCcy;
    }

    public String getOthAcctSeqNo() {
        return othAcctSeqNo;
    }

    public void setOthAcctSeqNo(String othAcctSeqNo) {
        this.othAcctSeqNo = othAcctSeqNo;
    }

    public String getOthAcctDesc() {
        return othAcctDesc;
    }

    public void setOthAcctDesc(String othAcctDesc) {
        this.othAcctDesc = othAcctDesc;
    }

    public String getOthBankCode() {
        return othBankCode;
    }

    public void setOthBankCode(String othBankCode) {
        this.othBankCode = othBankCode;
    }

    public String getOthBankName() {
        return othBankName;
    }

    public void setOthBankName(String othBankName) {
        this.othBankName = othBankName;
    }

    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
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

    public String getNarrativeCode() {
        return narrativeCode;
    }

    public void setNarrativeCode(String narrativeCode) {
        this.narrativeCode = narrativeCode;
    }

    public String getOthRealBankName() {
        return othRealBankName;
    }

    public void setOthRealBankName(String othRealBankName) {
        this.othRealBankName = othRealBankName;
    }

    public String getOthRealBankCode() {
        return othRealBankCode;
    }

    public void setOthRealBankCode(String othRealBankCode) {
        this.othRealBankCode = othRealBankCode;
    }

    public String getOthRealBaseAcctNo() {
        return othRealBaseAcctNo;
    }

    public void setOthRealBaseAcctNo(String othRealBaseAcctNo) {
        this.othRealBaseAcctNo = othRealBaseAcctNo;
    }

    public String getOthRealDocumentId() {
        return othRealDocumentId;
    }

    public void setOthRealDocumentId(String othRealDocumentId) {
        this.othRealDocumentId = othRealDocumentId;
    }

    public String getOthRealProdType() {
        return othRealProdType;
    }

    public void setOthRealProdType(String othRealProdType) {
        this.othRealProdType = othRealProdType;
    }

    public DocumentType getOthRealDocumentType() {
        return othRealDocumentType;
    }

    public void setOthRealDocumentType(DocumentType othRealDocumentType) {
        this.othRealDocumentType = othRealDocumentType;
    }

    public String getOthRealTranAddr() {
        return othRealTranAddr;
    }

    public void setOthRealTranAddr(String othRealTranAddr) {
        this.othRealTranAddr = othRealTranAddr;
    }

    public String getOthRealTranName() {
        return othRealTranName;
    }

    public void setOthRealTranName(String othRealTranName) {
        this.othRealTranName = othRealTranName;
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

    public TranStatus getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(TranStatus tranStatus) {
        this.tranStatus = tranStatus;
    }
}