package com.dcits.deposit.entity;

public class RbSignType {
    /** 签约类型 */
    private String signType;
    /** 协议类型描述 */
    private String signTypeDesc;
    /** 允许签约后销户标志 */
    private String agreementCloseAcctFlag;
    /** 协议互斥类型描述 */
    private String excludeType;
    /** 重复签约标志 */
    private String repackFlag;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSignTypeDesc() {
        return signTypeDesc;
    }

    public void setSignTypeDesc(String signTypeDesc) {
        this.signTypeDesc = signTypeDesc;
    }

    public String getAgreementCloseAcctFlag() {
        return agreementCloseAcctFlag;
    }

    public void setAgreementCloseAcctFlag(String agreementCloseAcctFlag) {
        this.agreementCloseAcctFlag = agreementCloseAcctFlag;
    }

    public String getExcludeType() {
        return excludeType;
    }

    public void setExcludeType(String excludeType) {
        this.excludeType = excludeType;
    }

    public String getRepackFlag() {
        return repackFlag;
    }

    public void setRepackFlag(String repackFlag) {
        this.repackFlag = repackFlag;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}