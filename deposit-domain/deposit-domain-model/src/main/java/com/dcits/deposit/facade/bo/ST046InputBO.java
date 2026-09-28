package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;
import java.util.Date;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AllDepInd;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.CheckCertificateType;
import com.dcits.deposit.enums.FarmerFlag;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.ManageType;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.SimpleAcct;
import com.dcits.deposit.enums.TranBranch;

/**
 * ST046 登记账户信息 输入BO
 */
public class ST046InputBO {
    /**允许账户转久悬标志*/
    private String allowSuspendFlag;
    /**监管账户标志*/
    private String manageFlag;
    /**监管原因*/
    private String manageContent;
    /**监管账户类型*/
    private ManageType manageType;
    /**年检标志*/
    private String annualFlag;
    /**简易账户标志*/
    private SimpleAcct simpleAcct;
    /**农户标志*/
    private FarmerFlag farmerFlag;
    /**允许出售支票标志*/
    private String isSellCheque;
    /**归属条线名称*/
    private String lineOwnerShip;
    /**客户经理名称*/
    private String acctExecName;
    /**客户经理工号*/
    private String acctExecCode;
    /**推介人名称*/
    private String promoterName;
    /**推介人编号*/
    private String promoterCode;
    /**查证金额*/
    private BigDecimal checkCertificateAmt;
    /**客户号*/
    private String clientNo;
    /**账号*/
    private String baseAcctNo;
    /**账户币种*/
    private AcctCcy acctCcy;
    /**产品编号*/
    private String prodNo;
    /**交易机构号*/
    private TranBranch tranBranch;
    /**账户开户日期*/
    private Date acctOpenDate;
    /**生效日期*/
    private Date effectDate;
    /**存款账户类型*/
    private RbAcctType rbAcctType;
    /**账户状态*/
    private AcctStatus acctStatus;
    /**通存标识*/
    private AllDepInd allDepInd;
    /**通兑标识*/
    private AllDraInd allDraInd;
    /**账户属性*/
    private AcctNatureNo acctNatureNo;
    /**计息标志*/
    private IntIndFlag intIndFlag;
    /**开户许可证编号*/
    private String acctLicenseNo;
    /**核准件编号*/
    private String apprLetterNo;
    /**查证类型*/
    private CheckCertificateType checkCertificateType;

    public String getAllowSuspendFlag() {
        return allowSuspendFlag;
    }

    public void setAllowSuspendFlag(String allowSuspendFlag) {
        this.allowSuspendFlag = allowSuspendFlag;
    }

    public String getManageFlag() {
        return manageFlag;
    }

    public void setManageFlag(String manageFlag) {
        this.manageFlag = manageFlag;
    }

    public String getManageContent() {
        return manageContent;
    }

    public void setManageContent(String manageContent) {
        this.manageContent = manageContent;
    }

    public ManageType getManageType() {
        return manageType;
    }

    public void setManageType(ManageType manageType) {
        this.manageType = manageType;
    }

    public String getAnnualFlag() {
        return annualFlag;
    }

    public void setAnnualFlag(String annualFlag) {
        this.annualFlag = annualFlag;
    }

    public SimpleAcct getSimpleAcct() {
        return simpleAcct;
    }

    public void setSimpleAcct(SimpleAcct simpleAcct) {
        this.simpleAcct = simpleAcct;
    }

    public FarmerFlag getFarmerFlag() {
        return farmerFlag;
    }

    public void setFarmerFlag(FarmerFlag farmerFlag) {
        this.farmerFlag = farmerFlag;
    }

    public String getIsSellCheque() {
        return isSellCheque;
    }

    public void setIsSellCheque(String isSellCheque) {
        this.isSellCheque = isSellCheque;
    }

    public String getLineOwnerShip() {
        return lineOwnerShip;
    }

    public void setLineOwnerShip(String lineOwnerShip) {
        this.lineOwnerShip = lineOwnerShip;
    }

    public String getAcctExecName() {
        return acctExecName;
    }

    public void setAcctExecName(String acctExecName) {
        this.acctExecName = acctExecName;
    }

    public String getAcctExecCode() {
        return acctExecCode;
    }

    public void setAcctExecCode(String acctExecCode) {
        this.acctExecCode = acctExecCode;
    }

    public String getPromoterName() {
        return promoterName;
    }

    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName;
    }

    public String getPromoterCode() {
        return promoterCode;
    }

    public void setPromoterCode(String promoterCode) {
        this.promoterCode = promoterCode;
    }

    public BigDecimal getCheckCertificateAmt() {
        return checkCertificateAmt;
    }

    public void setCheckCertificateAmt(BigDecimal checkCertificateAmt) {
        this.checkCertificateAmt = checkCertificateAmt;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getProdNo() {
        return prodNo;
    }

    public void setProdNo(String prodNo) {
        this.prodNo = prodNo;
    }

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public Date getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(Date acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public RbAcctType getRbAcctType() {
        return rbAcctType;
    }

    public void setRbAcctType(RbAcctType rbAcctType) {
        this.rbAcctType = rbAcctType;
    }

    public AcctStatus getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(AcctStatus acctStatus) {
        this.acctStatus = acctStatus;
    }

    public AllDepInd getAllDepInd() {
        return allDepInd;
    }

    public void setAllDepInd(AllDepInd allDepInd) {
        this.allDepInd = allDepInd;
    }

    public AllDraInd getAllDraInd() {
        return allDraInd;
    }

    public void setAllDraInd(AllDraInd allDraInd) {
        this.allDraInd = allDraInd;
    }

    public AcctNatureNo getAcctNatureNo() {
        return acctNatureNo;
    }

    public void setAcctNatureNo(AcctNatureNo acctNatureNo) {
        this.acctNatureNo = acctNatureNo;
    }

    public IntIndFlag getIntIndFlag() {
        return intIndFlag;
    }

    public void setIntIndFlag(IntIndFlag intIndFlag) {
        this.intIndFlag = intIndFlag;
    }

    public String getAcctLicenseNo() {
        return acctLicenseNo;
    }

    public void setAcctLicenseNo(String acctLicenseNo) {
        this.acctLicenseNo = acctLicenseNo;
    }

    public String getApprLetterNo() {
        return apprLetterNo;
    }

    public void setApprLetterNo(String apprLetterNo) {
        this.apprLetterNo = apprLetterNo;
    }

    public CheckCertificateType getCheckCertificateType() {
        return checkCertificateType;
    }

    public void setCheckCertificateType(CheckCertificateType checkCertificateType) {
        this.checkCertificateType = checkCertificateType;
    }
}
