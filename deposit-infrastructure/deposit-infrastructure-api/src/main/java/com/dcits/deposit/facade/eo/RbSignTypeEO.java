package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SignType;
import jakarta.validation.constraints.NotNull;

public class RbSignTypeEO {
    /** 签约类型 */
    @NotNull
    private SignType signType;
    /** 协议类型描述 */
    private String signTypeDesc;
    /** 允许签约后销户标志 */
    private IndividualFlag agreementCloseAcctFlag;
    /** 协议互斥类型描述 */
    private String excludeType;
    /** 重复签约标志 */
    private IndividualFlag repackFlag;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;

    public SignType getSignType() {
        return signType;
    }

    public void setSignType(SignType signType) {
        this.signType = signType;
    }

    public String getSignTypeDesc() {
        return signTypeDesc;
    }

    public void setSignTypeDesc(String signTypeDesc) {
        this.signTypeDesc = signTypeDesc;
    }

    public IndividualFlag getAgreementCloseAcctFlag() {
        return agreementCloseAcctFlag;
    }

    public void setAgreementCloseAcctFlag(IndividualFlag agreementCloseAcctFlag) {
        this.agreementCloseAcctFlag = agreementCloseAcctFlag;
    }

    public String getExcludeType() {
        return excludeType;
    }

    public void setExcludeType(String excludeType) {
        this.excludeType = excludeType;
    }

    public IndividualFlag getRepackFlag() {
        return repackFlag;
    }

    public void setRepackFlag(IndividualFlag repackFlag) {
        this.repackFlag = repackFlag;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}