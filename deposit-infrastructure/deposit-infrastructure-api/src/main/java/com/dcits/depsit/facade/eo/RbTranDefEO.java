package com.dcits.depsit.facade.eo;

import com.dcits.depsit.enums.AvailbalCalcType;
import com.dcits.depsit.enums.BalanceFlag;
import com.dcits.depsit.enums.CrDrInd;
import com.dcits.depsit.enums.OthTranType;
import com.dcits.depsit.enums.RcrRcdInd;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.TranClass;
import com.dcits.depsit.enums.UpdTailboxFlag;
import jakarta.validation.constraints.NotNull;

public class RbTranDefEO {
    /** 借贷标志 */
    private CrDrInd crDrInd;
    /** 交易类型描述 */
    private String tranTypeDesc;
    /** 多种冲正方式标志 */
    private String multiRvsTranTypeFlag;
    /** 余额类型次序编号 */
    private String balTypePriority;
    /** 余额标志 */
    private BalanceFlag balanceFlag;
    /** 对方交易类型 */
    private OthTranType othTranType;
    /** 交易类型与交易界面对应关系 */
    private String programIdGroup;
    /** 现金交易标志 */
    @NotNull
    private String cashTranFlag;
    /** 创建时间戳 */
    @NotNull
    private String createTimestamp;
    /** 是否出厂参数 */
    private String isInitParam;
    /** 冻结级别 */
    private String resPriority;
    /** 交易类型 */
    @NotNull
    private OthTranType tranType;
    /** 可用余额计算类型 */
    private AvailbalCalcType availbalCalcType;
    /** 重新计算余额止付标志 */
    private String recalcAcctStopPayFlag;
    /** 冲正交易类型 */
    private OthTranType reversalTranType;
    /** 渠道类型 */
    private SourceType sourceType;
    /** 最后修改时间戳 */
    @NotNull
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
    private UpdTailboxFlag updTailboxFlag;
    /** 红字处理标志 */
    private RcrRcdInd rcrRcdInd;
    /** 交易分类 */
    private TranClass tranClass;
    /** 凭证打印交易描述 */
    private String printTranDesc;

    public CrDrInd getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(CrDrInd crDrInd) {
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

    public BalanceFlag getBalanceFlag() {
        return balanceFlag;
    }

    public void setBalanceFlag(BalanceFlag balanceFlag) {
        this.balanceFlag = balanceFlag;
    }

    public OthTranType getOthTranType() {
        return othTranType;
    }

    public void setOthTranType(OthTranType othTranType) {
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

    public OthTranType getTranType() {
        return tranType;
    }

    public void setTranType(OthTranType tranType) {
        this.tranType = tranType;
    }

    public AvailbalCalcType getAvailbalCalcType() {
        return availbalCalcType;
    }

    public void setAvailbalCalcType(AvailbalCalcType availbalCalcType) {
        this.availbalCalcType = availbalCalcType;
    }

    public String getRecalcAcctStopPayFlag() {
        return recalcAcctStopPayFlag;
    }

    public void setRecalcAcctStopPayFlag(String recalcAcctStopPayFlag) {
        this.recalcAcctStopPayFlag = recalcAcctStopPayFlag;
    }

    public OthTranType getReversalTranType() {
        return reversalTranType;
    }

    public void setReversalTranType(OthTranType reversalTranType) {
        this.reversalTranType = reversalTranType;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
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

    public UpdTailboxFlag getUpdTailboxFlag() {
        return updTailboxFlag;
    }

    public void setUpdTailboxFlag(UpdTailboxFlag updTailboxFlag) {
        this.updTailboxFlag = updTailboxFlag;
    }

    public RcrRcdInd getRcrRcdInd() {
        return rcrRcdInd;
    }

    public void setRcrRcdInd(RcrRcdInd rcrRcdInd) {
        this.rcrRcdInd = rcrRcdInd;
    }

    public TranClass getTranClass() {
        return tranClass;
    }

    public void setTranClass(TranClass tranClass) {
        this.tranClass = tranClass;
    }

    public String getPrintTranDesc() {
        return printTranDesc;
    }

    public void setPrintTranDesc(String printTranDesc) {
        this.printTranDesc = printTranDesc;
    }
}