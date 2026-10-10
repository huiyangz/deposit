package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.RestraintsStatus;

/**
 * ST115 检查账户是否存在限制 输出 BO。
 *
 * <p>继承项目已有步骤结果基类 {@link StepResult}，业务字段与正式 Spec「### 输出」表一一对应，
 * 共 5 项（源需求标记均为「非必填」）：</p>
 * <ul>
 *   <li>{@code resSeqNo}、{@code restraintType}、{@code restraintsStatus}：步骤描述第 3 条命中时回显
 *       **升序第一条**命中记录的限制编号、账户限制类型、限制状态；零条命中时三者均为空值，
 *       空值本身即合法结果，不补默认值或枚举默认成员（Spec REQ-005 ~ REQ-007）。</li>
 *   <li>{@code baseAcctNo}、{@code leadAcctFlag}：回显步骤描述第 1 条**按上送 {账号} 查得**的
 *       【账户信息】（对公存款账户主表 {@code RB_BUS_ACCT}）记录的账号与主账户标志，
 *       MUST NOT 取自按「上级账户内部键」回查所得的主账户记录（Spec REQ-008-S03、REQ-008-S04）。
 *       二者按 1a 唯一命中后的成功路径赋值；按 `{账号}` 查无或多条记录的 {@code ER0048} 路径下
 *       无查得记录、无回显来源，保持空值，不以默认值或占位值填补（Spec REQ-010-S01）。</li>
 * </ul>
 *
 * <p>业务失败仅「按 {账号} 查询【账户信息】查不到记录或查到多条记录」→ 错误码 {@code ER0048}
 * （Spec REQ-002、REQ-010）；成功时 {@code succeed=true} 且错误码、错误信息保持 null。
 * 本步骤无实体写入，全路径只读。</p>
 */
public class ST115OutputBO extends StepResult {

    /** 账号：回显步骤描述第 1 条按上送 {账号} 查得的【账户信息】（RB_BUS_ACCT）记录的账号（Spec REQ-008-S03）。 */
    private String baseAcctNo;

    /** 主账户标志：回显步骤描述第 1 条按上送 {账号} 查得的【账户信息】（RB_BUS_ACCT）记录的主账户标志（Spec REQ-008-S04）。 */
    private String leadAcctFlag;

    /** 限制编号：命中记录（多条时升序第一条）的限制编号，零条命中为空值（Spec REQ-005 ~ REQ-007）。 */
    private String resSeqNo;

    /** 账户限制类型：命中记录（多条时升序第一条）的账户限制类型，零条命中为空值（Spec REQ-005 ~ REQ-007）。 */
    private RestraintType restraintType;

    /** 限制状态：命中记录（多条时升序第一条）的限制状态，零条命中为空值（Spec REQ-005 ~ REQ-007）。 */
    private RestraintsStatus restraintsStatus;

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public String getLeadAcctFlag() {
        return leadAcctFlag;
    }

    public void setLeadAcctFlag(String leadAcctFlag) {
        this.leadAcctFlag = leadAcctFlag;
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
}
