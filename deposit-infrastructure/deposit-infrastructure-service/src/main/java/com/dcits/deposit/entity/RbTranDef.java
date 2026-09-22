package com.dcits.deposit.entity;

public class RbTranDef {
    /** 交易类型 */
    private String tranType;
    /** 交易分类 */
    private String tranClass;
    /** 交易类型描述 */
    private String tranTypeDesc;
    /** 凭证打印交易描述 */
    private String printTranDesc;
    /** 借贷标志 */
    private String crDrInd;
    /** 余额标志 */
    private String balanceFlag;
    /** 现金交易标志 */
    private String cashTranFlag;
    /** 尾箱更新标志 */
    private String updTailboxFlag;
    /** 冻结级别 */
    private String resPriority;
    /** 重新计算余额止付标志 */
    private String recalcAcctStopPayFlag;
    /** 重新计算限制金额标志 */
    private String recalcResAmtFlag;
    /** 可用余额计算类型 */
    private String availbalCalcType;
    /** 对方交易类型 */
    private String othTranType;
    /** 冲正交易标志 */
    private String reversal;
    /** 冲正交易类型 */
    private String reversalTranType;
    /** 交易类型与交易界面对应关系 */
    private String programIdGroup;
    /** 余额类型次序编号 */
    private String balTypePriority;
    /** 更正交易标志 */
    private String correctFlag;
    /** 多种冲正方式标志 */
    private String multiRvsTranTypeFlag;
    /** 渠道类型 */
    private String sourceType;
    /** 是否出厂参数 */
    private String isInitParam;
    /** 交易时间戳 */
    private String tranTimestamp;
    /** 法人 */
    private String company;
    /** 支票标志 */
    private String chequeBookFlag;

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getTranClass() {
        return tranClass;
    }

    public void setTranClass(String tranClass) {
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

    public String getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(String crDrInd) {
        this.crDrInd = crDrInd;
    }

    public String getBalanceFlag() {
        return balanceFlag;
    }

    public void setBalanceFlag(String balanceFlag) {
        this.balanceFlag = balanceFlag;
    }

    public String getCashTranFlag() {
        return cashTranFlag;
    }

    public void setCashTranFlag(String cashTranFlag) {
        this.cashTranFlag = cashTranFlag;
    }

    public String getUpdTailboxFlag() {
        return updTailboxFlag;
    }

    public void setUpdTailboxFlag(String updTailboxFlag) {
        this.updTailboxFlag = updTailboxFlag;
    }

    public String getResPriority() {
        return resPriority;
    }

    public void setResPriority(String resPriority) {
        this.resPriority = resPriority;
    }

    public String getRecalcAcctStopPayFlag() {
        return recalcAcctStopPayFlag;
    }

    public void setRecalcAcctStopPayFlag(String recalcAcctStopPayFlag) {
        this.recalcAcctStopPayFlag = recalcAcctStopPayFlag;
    }

    public String getRecalcResAmtFlag() {
        return recalcResAmtFlag;
    }

    public void setRecalcResAmtFlag(String recalcResAmtFlag) {
        this.recalcResAmtFlag = recalcResAmtFlag;
    }

    public String getAvailbalCalcType() {
        return availbalCalcType;
    }

    public void setAvailbalCalcType(String availbalCalcType) {
        this.availbalCalcType = availbalCalcType;
    }

    public String getOthTranType() {
        return othTranType;
    }

    public void setOthTranType(String othTranType) {
        this.othTranType = othTranType;
    }

    public String getReversal() {
        return reversal;
    }

    public void setReversal(String reversal) {
        this.reversal = reversal;
    }

    public String getReversalTranType() {
        return reversalTranType;
    }

    public void setReversalTranType(String reversalTranType) {
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

    public String getCorrectFlag() {
        return correctFlag;
    }

    public void setCorrectFlag(String correctFlag) {
        this.correctFlag = correctFlag;
    }

    public String getMultiRvsTranTypeFlag() {
        return multiRvsTranTypeFlag;
    }

    public void setMultiRvsTranTypeFlag(String multiRvsTranTypeFlag) {
        this.multiRvsTranTypeFlag = multiRvsTranTypeFlag;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getChequeBookFlag() {
        return chequeBookFlag;
    }

    public void setChequeBookFlag(String chequeBookFlag) {
        this.chequeBookFlag = chequeBookFlag;
    }
}