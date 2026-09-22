package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.PasswordStatus;
import com.dcits.deposit.enums.PwdType;
import jakarta.validation.constraints.NotNull;

public class RbPasswordEO {
    /** 密码键值 */
    @NotNull
    private String pwdKey;
    /** 密码类型 */
    @NotNull
    private PwdType pwdType;
    /** 客户号 */
    @NotNull
    private String clientNo;
    /** 密码 */
    private String password;
    /** 密码生效日期 */
    private java.util.Date passwordEffectDate;
    /** 密码状态 */
    private PasswordStatus passwordStatus;
    /** 是否已修改标志 */
    private String changeInd;
    /** 累计失败次数 */
    private Integer failureTimes;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private java.util.Date lastChangeDate;
    /** 法人 */
    private Company company;
    /** 上日密码错误次数 */
    private Integer prevFailureTimes;
    /** 当日密码错误次数 */
    private Integer dayFailureTimes;
    /** DAC值防篡改加密 */
    private String dacValue;
    /** 创建时间戳 */
    private String createTimestamp;

    public String getPwdKey() {
        return pwdKey;
    }

    public void setPwdKey(String pwdKey) {
        this.pwdKey = pwdKey;
    }

    public PwdType getPwdType() {
        return pwdType;
    }

    public void setPwdType(PwdType pwdType) {
        this.pwdType = pwdType;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.util.Date getPasswordEffectDate() {
        return passwordEffectDate;
    }

    public void setPasswordEffectDate(java.util.Date passwordEffectDate) {
        this.passwordEffectDate = passwordEffectDate;
    }

    public PasswordStatus getPasswordStatus() {
        return passwordStatus;
    }

    public void setPasswordStatus(PasswordStatus passwordStatus) {
        this.passwordStatus = passwordStatus;
    }

    public String getChangeInd() {
        return changeInd;
    }

    public void setChangeInd(String changeInd) {
        this.changeInd = changeInd;
    }

    public Integer getFailureTimes() {
        return failureTimes;
    }

    public void setFailureTimes(Integer failureTimes) {
        this.failureTimes = failureTimes;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public java.util.Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(java.util.Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getPrevFailureTimes() {
        return prevFailureTimes;
    }

    public void setPrevFailureTimes(Integer prevFailureTimes) {
        this.prevFailureTimes = prevFailureTimes;
    }

    public Integer getDayFailureTimes() {
        return dayFailureTimes;
    }

    public void setDayFailureTimes(Integer dayFailureTimes) {
        this.dayFailureTimes = dayFailureTimes;
    }

    public String getDacValue() {
        return dacValue;
    }

    public void setDacValue(String dacValue) {
        this.dacValue = dacValue;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}