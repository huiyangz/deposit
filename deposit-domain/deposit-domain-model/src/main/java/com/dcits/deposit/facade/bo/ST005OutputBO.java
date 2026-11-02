package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;
import java.util.Date;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranStatus;

/**
 * ST005 检查支取账户限额 步骤输出。
 *
 * <p>业务字段来自正式 Spec 输出表，均非必填。输出表登记 11 项，其中 limitSumAmt、否 各登记
 * 两次（一组通用、一组来源限额累计信息表 RB_LIMIT_SUM_INFO），需求未声明其与
 * ST042/ST039 产出的对应关系及是否重复，本 BO 按唯一字段各保留一份，各字段赋值来源见
 * Spec 待确认事项 TBD-11，确认前保持为 null。</p>
 */
public class ST005OutputBO extends StepResult {

    /** 业务处理状态 */
    private TranStatus tranStatus;

    /** 限额累计金额 */
    private BigDecimal limitSumAmt;

    /** 限额累计笔数（字段名"否"） */
    private Integer 否;

    /** 限额检查结果 */
    private String 限额检查结果;

    /** 限额机构编码，来源限额控制配置（RB_LIMIT_CTRL_CONF），对应组件内步骤 ST038 返回的限额机构编码 */
    private TranBranch limitBranchId;

    /** 限额场景编码，来源限额累计信息表（RB_LIMIT_SUM_INFO） */
    private String limitSceneNo;

    /** 限额检查对象值，来源限额累计信息表（RB_LIMIT_SUM_INFO） */
    private String checkObjVal;

    /** 生效日期，来源限额累计信息表（RB_LIMIT_SUM_INFO） */
    private Date effectDate;

    /** 失效日期，来源限额累计信息表（RB_LIMIT_SUM_INFO） */
    private Date expireDate;

    public TranStatus getTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(TranStatus tranStatus) {
        this.tranStatus = tranStatus;
    }

    public BigDecimal getLimitSumAmt() {
        return limitSumAmt;
    }

    public void setLimitSumAmt(BigDecimal limitSumAmt) {
        this.limitSumAmt = limitSumAmt;
    }

    public Integer get否() {
        return 否;
    }

    public void set否(Integer 否) {
        this.否 = 否;
    }

    public String get限额检查结果() {
        return 限额检查结果;
    }

    public void set限额检查结果(String 限额检查结果) {
        this.限额检查结果 = 限额检查结果;
    }

    public TranBranch getLimitBranchId() {
        return limitBranchId;
    }

    public void setLimitBranchId(TranBranch limitBranchId) {
        this.limitBranchId = limitBranchId;
    }

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public String getCheckObjVal() {
        return checkObjVal;
    }

    public void setCheckObjVal(String checkObjVal) {
        this.checkObjVal = checkObjVal;
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
}
