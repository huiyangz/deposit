package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.LimitBranchRange;
import com.dcits.deposit.enums.TranBranch;

/**
 * ST038 检查账户机构是否可匹配到限额场景配置 输出 BO。
 *
 * <p>继承 {@link StepResult}，按正式 Spec「输出」表登记 8 个业务输出字段，均为非必填：
 * limitSceneNo、limitBranchId、limitBranchRange、validFlag、baseAcctNo、acctBranch、branch、attachedTo。</p>
 */
public class ST038OutputBO extends StepResult {

    /** 限额场景编码 */
    private String limitSceneNo;

    /** 限额机构编码 */
    private TranBranch limitBranchId;

    /** 限额机构范围 */
    private LimitBranchRange limitBranchRange;

    /** 启用标志 */
    private String validFlag;

    /** 账号 */
    private String baseAcctNo;

    /** 账户开立行行号 */
    private TranBranch acctBranch;

    /** 归属机构号 */
    private TranBranch branch;

    /** 归属上级机构号 */
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
