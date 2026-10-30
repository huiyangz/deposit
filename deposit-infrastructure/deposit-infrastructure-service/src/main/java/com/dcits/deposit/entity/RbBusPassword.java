package com.dcits.deposit.entity;

import java.util.Date;

public class RbBusPassword {
    /** 上日密码错误次数 */
    private Integer prevFailureTimes;
    /** 账户内部键值 */
    private Integer internalKey;
    /** 密码 */
    private String password;
    /** 是否已修改标志 */
    private String changeInd;
    /** 密码状态 */
    private String passwordStatus;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 密码生效日期 */
    private Date passwordEffectDate;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 当日密码错误次数 */
    private Integer dayFailureTimes;
    /** 累计失败次数 */
    private Integer failureTimes;
    /** 密码类型 */
    private String pwdType;
    /** 密码键值 */
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

    public String getPasswordStatus() {
        return passwordStatus;
    }

    public void setPasswordStatus(String passwordStatus) {
        this.passwordStatus = passwordStatus;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public Date getPasswordEffectDate() {
        return passwordEffectDate;
    }

    public void setPasswordEffectDate(Date passwordEffectDate) {
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

    public String getPwdType() {
        return pwdType;
    }

    public void setPwdType(String pwdType) {
        this.pwdType = pwdType;
    }

    public String getPwdKey() {
        return pwdKey;
    }

    public void setPwdKey(String pwdKey) {
        this.pwdKey = pwdKey;
    }
}