package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;

import java.util.Date;

/**
 * ST037 获取限额场景编码 输出 BO。
 *
 * <p>继承 {@link StepResult}。业务字段对应正式 Spec「输出」表：限额控制配置来源
 * （limitSceneNo、allowCustomFlag、onlyCustom、tempLimitFlag、tempLimitValidTerm）、
 * 限额控制客户自定义配置来源（limitSceneNo、tempLimitFlag、effectDate、expireDate）、
 * 以及回显 baseAcctNo、clientNo。字段归属差异见 Spec 待确认事项 1。</p>
 */
public class ST037OutputBO extends StepResult {

    /** 限额场景编码（来源限额控制配置 / 限额控制客户自定义配置） */
    private String limitSceneNo;

    /** 允许自定义标识 */
    private String allowCustomFlag;

    /** 仅检查客户自定义标志 */
    private String onlyCustom;

    /** 临时限额标志 */
    private String tempLimitFlag;

    /** 临时限额有效期 */
    private String tempLimitValidTerm;

    /** 生效日期 */
    private Date effectDate;

    /** 失效日期 */
    private Date expireDate;

    /** 账号 */
    private String baseAcctNo;

    /** 客户号 */
    private String clientNo;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public String getAllowCustomFlag() {
        return allowCustomFlag;
    }

    public void setAllowCustomFlag(String allowCustomFlag) {
        this.allowCustomFlag = allowCustomFlag;
    }

    public String getOnlyCustom() {
        return onlyCustom;
    }

    public void setOnlyCustom(String onlyCustom) {
        this.onlyCustom = onlyCustom;
    }

    public String getTempLimitFlag() {
        return tempLimitFlag;
    }

    public void setTempLimitFlag(String tempLimitFlag) {
        this.tempLimitFlag = tempLimitFlag;
    }

    public String getTempLimitValidTerm() {
        return tempLimitValidTerm;
    }

    public void setTempLimitValidTerm(String tempLimitValidTerm) {
        this.tempLimitValidTerm = tempLimitValidTerm;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }
}
