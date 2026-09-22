package com.dcits.deposit.entity;

import java.util.Date;

public class RbPassword {
    /** 密码键值 */
    private String pwdKey;
    /** 密码类型 */
    private String pwdType;
    /** 客户号 */
    private String clientNo;
    /** 密码 */
    private String password;
    /** 密码生效日期 */
    private Date passwordEffectDate;
    /** 密码状态 */
    private String passwordStatus;
    /** 是否已修改标志 */
    private String changeInd;
    /** 累计失败次数 */
    private Integer failureTimes;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 最后修改日期 */
    private Date lastChangeDate;
    /** 法人 */
    private String company;
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

    public String getPwdType() {
        return pwdType;
    }

    public void setPwdType(String pwdType) {
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

    public Date getPasswordEffectDate() {
        return passwordEffectDate;
    }

    public void setPasswordEffectDate(Date passwordEffectDate) {
        this.passwordEffectDate = passwordEffectDate;
    }

    public String getPasswordStatus() {
        return passwordStatus;
    }

    public void setPasswordStatus(String passwordStatus) {
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

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
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