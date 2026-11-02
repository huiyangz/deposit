package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;

/**
 * ST029 登记转账交易流水 步骤输入。
 *
 * <p>字段与正式 Spec「输入」表一致：交易类型、交易币种、交易金额、借贷标志，均为必填，
 * 来源未在需求中指定（由调用方提供）。</p>
 */
public class ST029InputBO {

    /** 交易类型（必填） */
    private TranType tranType;

    /** 交易币种（必填） */
    private Ccy tranCcy;

    /** 交易金额（必填） */
    private BigDecimal tranAmt;

    /** 借贷标志（必填；与子步骤固定登记值的用途关系见 Spec TBD-2） */
    private CrDrInd crDrInd;

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public Ccy getTranCcy() {
        return tranCcy;
    }

    public void setTranCcy(Ccy tranCcy) {
        this.tranCcy = tranCcy;
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
