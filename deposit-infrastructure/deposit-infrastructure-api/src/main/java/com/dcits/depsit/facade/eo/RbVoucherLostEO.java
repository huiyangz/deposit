package com.dcits.depsit.facade.eo;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.DocType;
import com.dcits.depsit.enums.LostType;
import com.dcits.depsit.enums.RelieveLossType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.VoucherLostStatus;
import jakarta.validation.constraints.NotNull;

public class RbVoucherLostEO {
    /** 账户内部键值 */
    private Integer internalKey;
    /** 解挂日期 */
    private java.util.Date unlostDate;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 解挂机构号 */
    private TranBranch unchainBranch;
    /** 挂失解挂原因 */
    private String reportedLostReason;
    /** 解挂柜员号 */
    private String unlostUserId;
    /** 交易参考号 */
    private String reference;
    /** 交易机构号 */
    private TranBranch tranBranch;
    /** 凭证挂失状态 */
    @NotNull
    private VoucherLostStatus voucherLostStatus;
    /** 凭证号 */
    private String voucherNo;
    /** 账户币种 */
    private AcctCcy acctCcy;
    /** 解挂类型 */
    private RelieveLossType relieveLossType;
    /** 账户名称 */
    private String acctName;
    /** 处理结果信息 */
    private String dealResult;
    /** 凭证前缀编码 */
    private String prefix;
    /** 解挂授权柜员号 */
    private String unchainAuthUserId;
    /** 挂失键编码 */
    @NotNull
    private String lostKey;
    /** 账户序号 */
    private String acctSeqNo;
    /** 交易日期 */
    private java.util.Date tranDate;
    /** 挂失类型 */
    @NotNull
    private LostType lostType;
    /** 账号 */
    private String baseAcctNo;
    /** 挂失编号 */
    @NotNull
    private String lostNo;
    /** 账户冻结开始序号 */
    private String startSeqNo;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 冻结标志 */
    private String resFlag;
    /** 交易柜员号 */
    private String userId;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 产品编号 */
    private String prodNo;
    /** 授权柜员号 */
    private String authUserId;
    /** 自动解挂日期 */
    private java.util.Date autoUnblockDate;
    /** 凭证类型 */
    private DocType docType;

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public java.util.Date getUnlostDate() {
        return unlostDate;
    }

    public void setUnlostDate(java.util.Date unlostDate) {
        this.unlostDate = unlostDate;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public TranBranch getUnchainBranch() {
        return unchainBranch;
    }

    public void setUnchainBranch(TranBranch unchainBranch) {
        this.unchainBranch = unchainBranch;
    }

    public String getReportedLostReason() {
        return reportedLostReason;
    }

    public void setReportedLostReason(String reportedLostReason) {
        this.reportedLostReason = reportedLostReason;
    }

    public String getUnlostUserId() {
        return unlostUserId;
    }

    public void setUnlostUserId(String unlostUserId) {
        this.unlostUserId = unlostUserId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public VoucherLostStatus getVoucherLostStatus() {
        return voucherLostStatus;
    }

    public void setVoucherLostStatus(VoucherLostStatus voucherLostStatus) {
        this.voucherLostStatus = voucherLostStatus;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public RelieveLossType getRelieveLossType() {
        return relieveLossType;
    }

    public void setRelieveLossType(RelieveLossType relieveLossType) {
        this.relieveLossType = relieveLossType;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getUnchainAuthUserId() {
        return unchainAuthUserId;
    }

    public void setUnchainAuthUserId(String unchainAuthUserId) {
        this.unchainAuthUserId = unchainAuthUserId;
    }

    public String getLostKey() {
        return lostKey;
    }

    public void setLostKey(String lostKey) {
        this.lostKey = lostKey;
    }

    public String getAcctSeqNo() {
        return acctSeqNo;
    }

    public void setAcctSeqNo(String acctSeqNo) {
        this.acctSeqNo = acctSeqNo;
    }

    public java.util.Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(java.util.Date tranDate) {
        this.tranDate = tranDate;
    }

    public LostType getLostType() {
        return lostType;
    }

    public void setLostType(LostType lostType) {
        this.lostType = lostType;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getLostNo() {
        return lostNo;
    }

    public void setLostNo(String lostNo) {
        this.lostNo = lostNo;
    }

    public String getStartSeqNo() {
        return startSeqNo;
    }

    public void setStartSeqNo(String startSeqNo) {
        this.startSeqNo = startSeqNo;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getResFlag() {
        return resFlag;
    }

    public void setResFlag(String resFlag) {
        this.resFlag = resFlag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public String getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    public java.util.Date getAutoUnblockDate() {
        return autoUnblockDate;
    }

    public void setAutoUnblockDate(java.util.Date autoUnblockDate) {
        this.autoUnblockDate = autoUnblockDate;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }
}