package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.PasswordStatus;
import com.dcits.deposit.enums.PwdType;
import jakarta.validation.constraints.NotNull;

public class RbBusPasswordEO {
    /** 上日密码错误次数 */
    private Integer prevFailureTimes;
    /** 账户内部键值 */
    @NotNull
    private Integer internalKey;
    /** 密码 */
    @NotNull
    private String password;
    /** 是否已修改标志 */
    @NotNull
    private String changeInd;
    /** 密码状态 */
    @NotNull
    private PasswordStatus passwordStatus;
    /** 最后修改时间戳 */
    @NotNull
    private String lastUpdTimestamp;
    /** 密码生效日期 */
    @NotNull
    private java.util.Date passwordEffectDate;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 当日密码错误次数 */
    private Integer dayFailureTimes;
    /** 累计失败次数 */
    @NotNull
    private Integer failureTimes;
    /** 密码类型 */
    @NotNull
    private PwdType pwdType;
    /** 密码键值 */
    @NotNull
    private String pwdKey;

    public Integer getPrevFailureTimes() {
        return prevFailureTimes;
    }

    public void setPrevFailureTimes(Integer prevFailureTimes) {
        this.prevFailureTimes = prevFailureTimes;
    }

    public Integer getInternalKey() {
        return internalKey;
    }

    public void setInternalKey(Integer internalKey) {
        this.internalKey = internalKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChangeInd() {
        return changeInd;
    }

    public void setChangeInd(String changeInd) {
        this.changeInd = changeInd;
    }

    public PasswordStatus getPasswordStatus() {
        return passwordStatus;
    }

    public void setPasswordStatus(PasswordStatus passwordStatus) {
        this.passwordStatus = passwordStatus;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public java.util.Date getPasswordEffectDate() {
        return passwordEffectDate;
    }

    public void setPasswordEffectDate(java.util.Date passwordEffectDate) {
        this.passwordEffectDate = passwordEffectDate;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Integer getDayFailureTimes() {
        return dayFailureTimes;
    }

    public void setDayFailureTimes(Integer dayFailureTimes) {
        this.dayFailureTimes = dayFailureTimes;
    }

    public Integer getFailureTimes() {
        return failureTimes;
    }

    public void setFailureTimes(Integer failureTimes) {
        this.failureTimes = failureTimes;
    }

    public PwdType getPwdType() {
        return pwdType;
    }

    public void setPwdType(PwdType pwdType) {
        this.pwdType = pwdType;
    }

    public String getPwdKey() {
        return pwdKey;
    }

    public void setPwdKey(String pwdKey) {
        this.pwdKey = pwdKey;
    }
}