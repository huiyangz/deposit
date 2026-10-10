package com.dcits.depsit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.depsit.enums.LimitBranchRange;
import com.dcits.depsit.enums.TranBranch;

/**
 * ST102 检查账户机构是否可匹配到限额场景配置 输出 BO。
 *
 * <p>继承 {@link StepResult} 的 {@code succeed}/{@code errorCode}/{@code errorMessage} 状态字段，
 * 不重复声明这三个保留字段。业务字段按源需求「## 输出」表照录 8 个字段的名称、类型与「非必填」标记
 * （REQ-009），不新增源需求未声明的字段。</p>
 *
 * <p>「## 步骤描述」只把 [限额场景编码] 列为返回内容，故本 BO 中仅 {@code limitSceneNo} 由步骤实现赋值：
 * 在账户开立行或某个上级机构命中启用配置时取该配置记录的限额场景编码，全部未命中（含上级机构集合为空）
 * 时保持未赋值（{@code null}）。其余 7 个字段的回显口径源需求未规定（Spec「验收范围与明确不覆盖的事项」
 * 第 4 项），实现不为其补写回显，保持未赋值；其类型与字段名仍按输出表照录供调用方契约使用。</p>
 *
 * <p>「非必填」记的是实体字段本身可空，不表示本步骤可以不产出应有的取值。</p>
 */
public class ST102OutputBO extends StepResult {

    /** 限额场景编码（非必填）；命中启用配置时取该配置记录的值，未命中任何启用配置时为空值 */
    private String limitSceneNo;

    /** 限额机构编码（非必填）；来源实体为限额控制配置（RB_LIMIT_CTRL_CONF），回显口径源需求未规定 */
    private TranBranch limitBranchId;

    /** 限额机构范围（非必填）；来源实体为限额控制配置（RB_LIMIT_CTRL_CONF），回显口径源需求未规定 */
    private LimitBranchRange limitBranchRange;

    /** 启用标志（非必填）；来源实体为限额控制配置（RB_LIMIT_CTRL_CONF），回显口径源需求未规定 */
    private String validFlag;

    /** 账号（非必填）；来源实体为对公存款账户主表（RB_BUS_ACCT），回显口径源需求未规定 */
    private String baseAcctNo;

    /** 账户开立行行号（非必填）；来源实体为对公存款账户主表（RB_BUS_ACCT），回显口径源需求未规定 */
    private TranBranch acctBranch;

    /** 归属机构号（非必填）；来源实体为机构信息表（FM_BRANCH），回显口径源需求未规定 */
    private TranBranch branch;

    /** 归属上级机构号（非必填）；来源实体为机构信息表（FM_BRANCH），回显口径源需求未规定 */
    private TranBranch attachedTo;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public TranBranch getLimitBranchId() {
        return limitBranchId;
    }

    public void setLimitBranchId(TranBranch limitBranchId) {
        this.limitBranchId = limitBranchId;
    }

    public LimitBranchRange getLimitBranchRange() {
        return limitBranchRange;
    }

    public void setLimitBranchRange(LimitBranchRange limitBranchRange) {
        this.limitBranchRange = limitBranchRange;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getBaseAcctNo() {
        return baseAcctNo;
    }

    public void setBaseAcctNo(String baseAcctNo) {
        this.baseAcctNo = baseAcctNo;
    }

    public TranBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(TranBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public TranBranch getBranch() {
        return branch;
    }

    public void setBranch(TranBranch branch) {
        this.branch = branch;
    }

    public TranBranch getAttachedTo() {
        return attachedTo;
    }

    public void setAttachedTo(TranBranch attachedTo) {
        this.attachedTo = attachedTo;
    }
}
