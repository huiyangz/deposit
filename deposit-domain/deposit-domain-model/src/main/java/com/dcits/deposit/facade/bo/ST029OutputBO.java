package com.dcits.deposit.facade.bo;

import com.dcits.common.step.StepResult;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;

/**
 * ST029 登记转账交易流水 步骤输出。
 *
 * <p>继承 {@link StepResult} 表达步骤结果；业务字段与正式 Spec「输出」表一致，均为非必填，
 * 来源为【对公存款账户金融交易流水表（RB_BUS_TRAN_JNL）】登记产生的流水数据。</p>
 */
public class ST029OutputBO extends StepResult {

    /** 交易类型（非必填，来源 RB_BUS_TRAN_JNL） */
    private TranType tranType;

    /** 账户币种（非必填，来源 RB_BUS_TRAN_JNL；取值来源见 Spec TBD-4） */
    private AcctCcy acctCcy;

    /** 交易金额（非必填，来源 RB_BUS_TRAN_JNL） */
    private BigDecimal tranAmt;

    /** 借贷标志（非必填，来源 RB_BUS_TRAN_JNL） */
    private CrDrInd crDrInd;

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public BigDecimal getTranAmt() {
        return tranAmt;
    }

    public void setTranAmt(BigDecimal tranAmt) {
        this.tranAmt = tranAmt;
    }

    public CrDrInd getCrDrInd() {
        return crDrInd;
    }

    public void setCrDrInd(CrDrInd crDrInd) {
        this.crDrInd = crDrInd;
    }
}
