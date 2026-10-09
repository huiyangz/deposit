package com.dcits.depsit.entity;

public class RbTranDef {
    /** 借贷标志 */
    private String crDrInd;
    /** 交易类型描述 */
    private String tranTypeDesc;
    /** 多种冲正方式标志 */
    private String multiRvsTranTypeFlag;
    /** 余额类型次序编号 */
    private String balTypePriority;
    /** 余额标志 */
    private String balanceFlag;
    /** 对方交易类型 */
    private String othTranType;
    /** 交易类型与交易界面对应关系 */
    private String programIdGroup;
    /** 现金交易标志 */
    private String cashTranFlag;
    /** 创建时间戳 */
    private String createTimestamp;
    /** 是否出厂参数 */
    private String isInitParam;
    /** 冻结级别 */
    private String resPriority;
    /** 交易类型 */
    private String tranType;
    /** 可用余额计算类型 */
    private String availbalCalcType;
    /** 重新计算余额止付标志 */
    private String recalcAcctStopPayFlag;
    /** 冲正交易类型 */
    private String reversalTranType;
    /** 渠道类型 */
    private String sourceType;
    /** 最后修改时间戳 */
    private String lastUpdTimestamp;
    /** 重新计算限制金额标志 */
    private String recalcResAmtFlag;
    /** 冲正交易标志 */
    private String reversal;
    /** 支票标志 */
    private String chequeBookFlag;
    /** 更正交易标志 */
    private String correctFlag;
    /** 尾箱更新标志 */
    private String updTailboxFlag;
    /** 红字处理标志 */
    private String rcrRcdInd;
    /** 交易分类 */
    private String tranClass;
    /** 凭证打印交易描述 */
    private String printTranDesc;

    public String getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(String crDrInd) {
        this.crDrInd = crDrInd;
    }

    public String getTranTypeDesc() {
        return tranTypeDesc;
    }

    public void setTranTypeDesc(String tranTypeDesc) {
        this.tranTypeDesc = tranTypeDesc;
    }

    public String getMultiRvsTranTypeFlag() {
        return multiRvsTranTypeFlag;
    }

    public void setMultiRvsTranTypeFlag(String multiRvsTranTypeFlag) {
        this.multiRvsTranTypeFlag = multiRvsTranTypeFlag;
    }

    public String getBalTypePriority() {
        return balTypePriority;
    }

    public void setBalTypePriority(String balTypePriority) {
        this.balTypePriority = balTypePriority;
    }

    public String getBalanceFlag() {
        return balanceFlag;
    }

    public void setBalanceFlag(String balanceFlag) {
        this.balanceFlag = balanceFlag;
    }

    public String getOthTranType() {
        return othTranType;
    }

    public void setOthTranType(String othTranType) {
        this.othTranType = othTranType;
    }

    public String getProgramIdGroup() {
        return programIdGroup;
    }

    public void setProgramIdGroup(String programIdGroup) {
        this.programIdGroup = programIdGroup;
    }

    public String getCashTranFlag() {
        return cashTranFlag;
    }

    public void setCashTranFlag(String cashTranFlag) {
        this.cashTranFlag = cashTranFlag;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getIsInitParam() {
        return isInitParam;
    }

    public void setIsInitParam(String isInitParam) {
        this.isInitParam = isInitParam;
    }

    public String getResPriority() {
        return resPriority;
    }

    public void setResPriority(String resPriority) {
        this.resPriority = resPriority;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getAvailbalCalcType() {
        return availbalCalcType;
    }

    public void setAvailbalCalcType(String availbalCalcType) {
        this.availbalCalcType = availbalCalcType;
    }

    public String getRecalcAcctStopPayFlag() {
        return recalcAcctStopPayFlag;
    }

    public void setRecalcAcctStopPayFlag(String recalcAcctStopPayFlag) {
        this.recalcAcctStopPayFlag = recalcAcctStopPayFlag;
    }

    public String getReversalTranType() {
        return reversalTranType;
    }

    public void setReversalTranType(String reversalTranType) {
        this.reversalTranType = reversalTranType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getLastUpdTimestamp() {
        return lastUpdTimestamp;
    }

    public void setLastUpdTimestamp(String lastUpdTimestamp) {
        this.lastUpdTimestamp = lastUpdTimestamp;
    }

    public String getRecalcResAmtFlag() {
        return recalcResAmtFlag;
    }

    public void setRecalcResAmtFlag(String recalcResAmtFlag) {
        this.recalcResAmtFlag = recalcResAmtFlag;
    }

    public String getReversal() {
        return reversal;
    }

    public void setReversal(String reversal) {
        this.reversal = reversal;
    }

    public String getChequeBookFlag() {
        return chequeBookFlag;
    }

    public void setChequeBookFlag(String chequeBookFlag) {
        this.chequeBookFlag = chequeBookFlag;
    }

    public String getCorrectFlag() {
        return correctFlag;
    }

    public void setCorrectFlag(String correctFlag) {
        this.correctFlag = correctFlag;
    }

    public String getUpdTailboxFlag() {
        return updTailboxFlag;
    }

    public void setUpdTailboxFlag(String updTailboxFlag) {
        this.updTailboxFlag = updTailboxFlag;
    }

    public String getRcrRcdInd() {
        return rcrRcdInd;
    }

    public void setRcrRcdInd(String rcrRcdInd) {
        this.rcrRcdInd = rcrRcdInd;
    }

    public String getTranClass() {
        return tranClass;
    }

    public void setTranClass(String tranClass) {
        this.tranClass = tranClass;
    }

    public String getPrintTranDesc() {
        return printTranDesc;
    }

    public void setPrintTranDesc(String printTranDesc) {
        this.printTranDesc = printTranDesc;
    }
}