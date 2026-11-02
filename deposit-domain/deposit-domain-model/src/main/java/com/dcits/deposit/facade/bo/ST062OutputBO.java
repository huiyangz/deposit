package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.RestraintType;

/**
 * ST062 检查是否存在现金止付限制 输出。
 *
 * <p>继承 {@link StepResult}，不重复声明 succeed/errorCode/errorMessage。
 * 字段来源：正式 Spec ST062「输出」表；现金止付标志为本步骤对外业务结果，
 * 其余 5 个字段为两次查询涉及的字段（均非必填，Spec 未给出「现金止付标志」英文名，
 * 按小驼峰命名为 cashStopFlag）。</p>
 */
public class ST062OutputBO extends StepResult {

    /** 现金止付标志：本步骤业务结果，取值「是」/「否」（需求字面表述） */
                                                       
    private String cashStopFlag;

    /** 现金标志：来源存款限制类型表（RB_RESTRAINT_TYPE），命中判定条件值「N」为不允许现金 */
    private String cashFlag;

    /** 借方贷方控制标志：来源存款限制类型表（RB_RESTRAINT_TYPE） */
    private DrCrCtlFlag drCrCtlFlag;

    /** 账户限制类型：来源对公存款账户限制表（RB_BUS_RESTRAINTS） */
    private RestraintType restraintType;

    /** 限制编号：来源对公存款账户限制表（RB_BUS_RESTRAINTS） */
    private String resSeqNo;

    /** 限制状态：来源对公存款账户限制表（RB_BUS_RESTRAINTS） */
    private RestraintsStatus restraintsStatus;

    public String getCashStopFlag() {
        return cashStopFlag;
    }

    public void setCashStopFlag(String cashStopFlag) {
        this.cashStopFlag = cashStopFlag;
    }

    public String getCashFlag() {
        return cashFlag;
    }

    public void setCashFlag(String cashFlag) {
        this.cashFlag = cashFlag;
    }

    public DrCrCtlFlag getDrCrCtlFlag() {
        return drCrCtlFlag;
    }

    public void setDrCrCtlFlag(DrCrCtlFlag drCrCtlFlag) {
        this.drCrCtlFlag = drCrCtlFlag;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public RestraintsStatus getRestraintsStatus() {
        return restraintsStatus;
    }

    public void setRestraintsStatus(RestraintsStatus restraintsStatus) {
        this.restraintsStatus = restraintsStatus;
    }
}
