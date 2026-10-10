package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.RestraintType;

/**
 * ST111 检查客户是否存在限制 —— 输出 BO。
 *
 * <p>按 Spec「### 输出」表声明 3 个业务字段，均为「非必填」，来源实体为客户限制表
 * （{@code RB_CLIENT_RESTRAINTS}）：{@code resSeqNo} 承载限制编号、{@code restraintType}
 * 以 {@link RestraintType} 承载账户限制类型、{@code restraintsStatus} 以
 * {@link RestraintsStatus} 承载限制状态。命中路径下三者取自子步骤 1 确定的回显记录
 * （恰好一条时取该条、多于一条时取限制编号升序第一条）；查询结果为空时三者均为空值，
 * 不以常量占位（REQ-002、REQ-004）。</p>
 *
 * <p>本类 MUST NOT 额外声明需求「## 输出」表之外的业务字段（REQ-004-S03）；步骤的
 * 成功／失败状态由继承自 {@link StepResult} 的 {@code succeed}／{@code errorCode}／
 * {@code errorMessage} 承载，本类不重复声明这三个保留字段。</p>
 */
public class ST111OutputBO extends StepResult {

    /** 限制编号 */
    private String resSeqNo;

    /** 账户限制类型 */
    private RestraintType restraintType;

    /** 限制状态 */
    private RestraintsStatus restraintsStatus;

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
}
