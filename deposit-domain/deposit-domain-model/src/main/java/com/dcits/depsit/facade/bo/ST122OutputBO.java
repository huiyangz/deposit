package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;

/**
 * ST122 检查是否存在不收不付限制 的输出 BO。
 *
 * <p>不收不付标志（noRecvNoPayFlag）取值仅为中文常量字符串 "是" / "否"；命中（结果为 "是"）时
 * 回显命中记录的 resSeqNo、restraintType、restraintsStatus，以及该记录所依据的 A-生效 配置的
 * drCrCtlFlag、status；未查询到生效限制或全部不满足时，除 noRecvNoPayFlag 外的业务字段均输出空值（null）。</p>
 */
public class ST122OutputBO extends StepResult {

    /** 不收不付标志（取值："是" / "否"）。 */
    private String noRecvNoPayFlag;

    /** 限制编号（来源：对公存款账户限制表 RB_BUS_RESTRAINTS）。 */
    private String resSeqNo;

    /** 账户限制类型（来源：对公存款账户限制表 RB_BUS_RESTRAINTS）。 */
    private RestraintType restraintType;

    /** 限制状态（来源：对公存款账户限制表 RB_BUS_RESTRAINTS）。 */
    private RestraintsStatus restraintsStatus;

    /** 借方贷方控制标志（来源：存款限制类型表 RB_RESTRAINT_TYPE）。 */
    private DrCrCtlFlag drCrCtlFlag;

    /** 状态（来源：存款限制类型表 RB_RESTRAINT_TYPE）。 */
    private Status status;

    public String getNoRecvNoPayFlag() {
        return noRecvNoPayFlag;
    }

    public void setNoRecvNoPayFlag(String noRecvNoPayFlag) {
        this.noRecvNoPayFlag = noRecvNoPayFlag;
    }

    public String getResSeqNo() {
        return resSeqNo;
    }

    public void setResSeqNo(String resSeqNo) {
        this.resSeqNo = resSeqNo;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }

    public RestraintsStatus getRestraintsStatus() {
        return restraintsStatus;
    }

    public void setRestraintsStatus(RestraintsStatus restraintsStatus) {
        this.restraintsStatus = restraintsStatus;
    }

    public DrCrCtlFlag getDrCrCtlFlag() {
        return drCrCtlFlag;
    }

    public void setDrCrCtlFlag(DrCrCtlFlag drCrCtlFlag) {
        this.drCrCtlFlag = drCrCtlFlag;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
