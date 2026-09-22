package com.dcits.deposit.facade.eo;

import com.dcits.deposit.enums.AvailbalCalcType;
import com.dcits.deposit.enums.BalanceFlag;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranClass;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.UpdTailboxFlag;
import jakarta.validation.constraints.NotNull;

public class RbTranDefEO {
    /** 交易类型 */
    @NotNull
    private TranType tranType;
    /** 交易分类 */
    private TranClass tranClass;
    /** 交易类型描述 */
    private String tranTypeDesc;
    /** 凭证打印交易描述 */
    private String printTranDesc;
    /** 借贷标志 */
    private CrDrInd crDrInd;
    /** 余额标志 */
    private BalanceFlag balanceFlag;
    /** 现金交易标志 */
    private IndividualFlag cashTranFlag;
    /** 尾箱更新标志 */
    private UpdTailboxFlag updTailboxFlag;
    /** 冻结级别 */
    private String resPriority;
    /** 重新计算余额止付标志 */
    private IndividualFlag recalcAcctStopPayFlag;
    /** 重新计算限制金额标志 */
    private IndividualFlag recalcResAmtFlag;
    /** 可用余额计算类型 */
    private AvailbalCalcType availbalCalcType;
    /** 对方交易类型 */
    private TranType othTranType;
    /** 冲正交易标志 */
    private IndividualFlag reversal;
    /** 冲正交易类型 */
    private TranType reversalTranType;
    /** 交易类型与交易界面对应关系 */
    private String programIdGroup;
    /** 余额类型次序编号 */
    private String balTypePriority;
    /** 更正交易标志 */
    private IndividualFlag correctFlag;
    /** 多种冲正方式标志 */
    private String multiRvsTranTypeFlag;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 是否出厂参数 */
    private String isInitParam;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private Company company;
    /** 支票标志 */
    private IndividualFlag chequeBookFlag;

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public TranClass getTranClass() {
        return tranClass;
    }

    public void setTranClass(TranClass tranClass) {
        this.tranClass = tranClass;
    }

    public String getTranTypeDesc() {
        return tranTypeDesc;
    }

    public void setTranTypeDesc(String tranTypeDesc) {
        this.tranTypeDesc = tranTypeDesc;
    }

    public String getPrintTranDesc() {
        return printTranDesc;
    }

    public void setPrintTranDesc(String printTranDesc) {
        this.printTranDesc = printTranDesc;
    }

    public CrDrInd getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(CrDrInd crDrInd) {
        this.crDrInd = crDrInd;
    }

    public BalanceFlag getBalanceFlag() {
        return balanceFlag;
    }

    public void setBalanceFlag(BalanceFlag balanceFlag) {
        this.balanceFlag = balanceFlag;
    }

    public IndividualFlag getCashTranFlag() {
        return cashTranFlag;
    }

    public void setCashTranFlag(IndividualFlag cashTranFlag) {
        this.cashTranFlag = cashTranFlag;
    }

    public UpdTailboxFlag getUpdTailboxFlag() {
        return updTailboxFlag;
    }

    public void setUpdTailboxFlag(UpdTailboxFlag updTailboxFlag) {
        this.updTailboxFlag = updTailboxFlag;
    }

    public String getResPriority() {
        return resPriority;
    }

    public void setResPriority(String resPriority) {
        this.resPriority = resPriority;
    }

    public IndividualFlag getRecalcAcctStopPayFlag() {
        return recalcAcctStopPayFlag;
    }

    public void setRecalcAcctStopPayFlag(IndividualFlag recalcAcctStopPayFlag) {
        this.recalcAcctStopPayFlag = recalcAcctStopPayFlag;
    }

    public IndividualFlag getRecalcResAmtFlag() {
        return recalcResAmtFlag;
    }

    public void setRecalcResAmtFlag(IndividualFlag recalcResAmtFlag) {
        this.recalcResAmtFlag = recalcResAmtFlag;
    }

    public AvailbalCalcType getAvailbalCalcType() {
        return availbalCalcType;
    }

    public void setAvailbalCalcType(AvailbalCalcType availbalCalcType) {
        this.availbalCalcType = availbalCalcType;
    }

    public TranType getOthTranType() {
        return othTranType;
    }

    public void setOthTranType(TranType othTranType) {
        this.othTranType = othTranType;
    }

    public IndividualFlag getReversal() {
        return reversal;
    }

    public void setReversal(IndividualFlag reversal) {
        this.reversal = reversal;
    }

    public TranType getReversalTranType() {
        return reversalTranType;
    }

    public void setReversalTranType(TranType reversalTranType) {
        this.reversalTranType = reversalTranType;
    }

    public String getProgramIdGroup() {
        return programIdGroup;
    }

    public void setProgramIdGroup(String programIdGroup) {
        this.programIdGroup = programIdGroup;
    }

    public String getBalTypePriority() {
        return balTypePriority;
    }

    public void setBalTypePriority(String balTypePriority) {
        this.balTypePriority = balTypePriority;
    }

    public IndividualFlag getCorrectFlag() {
        return correctFlag;
    }

    public void setCorrectFlag(IndividualFlag correctFlag) {
        this.correctFlag = correctFlag;
    }

    public String getMultiRvsTranTypeFlag() {
        return multiRvsTranTypeFlag;
    }

    public void setMultiRvsTranTypeFlag(String multiRvsTranTypeFlag) {
        this.multiRvsTranTypeFlag = multiRvsTranTypeFlag;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public String getIsInitParam() {
        return isInitParam;
    }

    public void setIsInitParam(String isInitParam) {
        this.isInitParam = isInitParam;
    }

    public String getTranTimestamp() {
        return tranTimestamp;
    }

    public void setTranTimestamp(String tranTimestamp) {
        this.tranTimestamp = tranTimestamp;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public IndividualFlag getChequeBookFlag() {
        return chequeBookFlag;
    }

    public void setChequeBookFlag(IndividualFlag chequeBookFlag) {
        this.chequeBookFlag = chequeBookFlag;
    }
}