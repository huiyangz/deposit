package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import java.util.Date;

/**
 * ST101 获取限额场景编码的输出 BO。
 *
 * <p>字段名、类型与「非必填」标记照录正式 Spec「### 输出」表（REQ-011）：输出表 11 行中
 * limitSceneNo 与 tempLimitFlag 各出现两行（分属限额控制配置与限额控制客户自定义配置两个来源实体），
 * 按字段名照录为同一字段，不产生同名字段。</p>
 *
 * <p>取值映射（REQ-011）：limitSceneNo＝本步骤返回的 [限额场景编码]（返回场景编码路径为入参值，
 * 返回为空路径为空值 null）；allowCustomFlag／onlyCustom＝子步骤1 命中配置记录的
 * $允许自定义标识$／$仅检查客户自定义标志$；effectDate／expireDate／tempLimitFlag＝[自定义限额] 记录的
 * $生效日期$／$失效日期$／判定所用的 $临时限额标志$。</p>
 *
 * <p>tempLimitValidTerm、baseAcctNo、clientNo 的取值来源源需求正文未赋予依据，本 BO 只照录字段契约，
 * 不为其赋值。结果载体继承项目既有 {@link StepResult}。</p>
 */
public class ST101OutputBO extends StepResult {

    /** 限额场景编码（非必填；返回的 [限额场景编码]，返回为空路径下未赋值） */
    private String limitSceneNo;

    /** 允许自定义标识（非必填；子步骤1 命中配置记录的 $允许自定义标识$） */
    private String allowCustomFlag;

    /** 仅检查客户自定义标志（非必填；子步骤1 命中配置记录的 $仅检查客户自定义标志$） */
    private String onlyCustom;

    /** 临时限额标志（非必填；[自定义限额] 记录判定所用的 $临时限额标志$） */
    private String tempLimitFlag;

    /** 临时限额有效期（非必填；源需求正文未赋予取值来源，不赋值） */
    private String tempLimitValidTerm;

    /** 生效日期（非必填；[自定义限额] 记录的 $生效日期$） */
    private Date effectDate;

    /** 失效日期（非必填；[自定义限额] 记录的 $失效日期$） */
    private Date expireDate;

    /** 账号（非必填；源需求正文未赋予取值来源，不赋值） */
    private String baseAcctNo;

    /** 客户号（非必填；源需求正文未赋予取值来源，不赋值） */
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
