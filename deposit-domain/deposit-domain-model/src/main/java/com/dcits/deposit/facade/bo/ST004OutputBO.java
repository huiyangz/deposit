package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.HierarchyCode;
import com.dcits.deposit.enums.TranBranch;

/**
 * ST004 检查账户通兑信息 输出。
 *
 * <p>继承工程步骤结果基类 {@link StepResult}：检查结果「通过」以 {@code succeed=true} 且
 * {@code errorCode}/{@code errorMessage} 为 null 表示；业务失败以 {@code succeed=false} 及错误码
 * {@code ER0071}/{@code ER0072}/{@code ER0073} 表示（Spec「步骤结果框架」）。不重复声明基类
 * {@code succeed}/{@code errorCode}/{@code errorMessage} 字段。
 *
 * <p>业务字段来自 Spec「输出」表：「开户机构的管辖分行」「交易机构的管辖分行」类型为
 * {@code java.lang.String}，取值承载约定待确认（Spec 待确认事项第 8 项 TBD-8）；
 * {@code acctBranch}/{@code allDraInd}/{@code allDraIntBranch} 来源为对公存款账户主表（RB_BUS_ACCT），
 * {@code hierarchyCode}/{@code attachedTo} 来源为机构信息表（FM_BRANCH）。
 */
public class ST004OutputBO extends StepResult {

    /** 开户机构的管辖分行（步骤 8 赋值结果，java.lang.String） */
    private String acctManageBranch;

    /** 交易机构的管辖分行（步骤 9 赋值结果，java.lang.String） */
    private String tranManageBranch;

    /** 账户开立行行号（来源：对公存款账户主表 RB_BUS_ACCT） */
    private TranBranch acctBranch;

    /** 通兑标志（来源：对公存款账户主表 RB_BUS_ACCT） */
    private AllDraInd allDraInd;

    /** 通兑机构编号（来源：对公存款账户主表 RB_BUS_ACCT） */
    private TranBranch allDraIntBranch;

    /** 机构层级代码（来源：机构信息表 FM_BRANCH） */
    private HierarchyCode hierarchyCode;

    /** 归属上级机构号（来源：机构信息表 FM_BRANCH） */
    private TranBranch attachedTo;

    public String getAcctManageBranch() {
        return acctManageBranch;
    }

    public void setAcctManageBranch(String acctManageBranch) {
        this.acctManageBranch = acctManageBranch;
    }

    public String getTranManageBranch() {
        return tranManageBranch;
    }

    public void setTranManageBranch(String tranManageBranch) {
        this.tranManageBranch = tranManageBranch;
    }

    public TranBranch getAcctBranch() {
        return acctBranch;
    }

    public void setAcctBranch(TranBranch acctBranch) {
        this.acctBranch = acctBranch;
    }

    public AllDraInd getAllDraInd() {
        return allDraInd;
    }

    public void setAllDraInd(AllDraInd allDraInd) {
        this.allDraInd = allDraInd;
    }

    public TranBranch getAllDraIntBranch() {
        return allDraIntBranch;
    }

    public void setAllDraIntBranch(TranBranch allDraIntBranch) {
        this.allDraIntBranch = allDraIntBranch;
    }

    public HierarchyCode getHierarchyCode() {
        return hierarchyCode;
    }

    public void setHierarchyCode(HierarchyCode hierarchyCode) {
        this.hierarchyCode = hierarchyCode;
    }

    public TranBranch getAttachedTo() {
        return attachedTo;
    }

    public void setAttachedTo(TranBranch attachedTo) {
        this.attachedTo = attachedTo;
    }
}
