package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AccountingStatus;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.AcctSetType;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctTranFlag;
import com.dcits.deposit.enums.AmtCalcType;
import com.dcits.deposit.enums.ApprIndicator;
import com.dcits.deposit.enums.AutoReversalFlag;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FromRateFlag;
import com.dcits.deposit.enums.IntCalcAmtType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.MediumFlag;
import com.dcits.deposit.enums.MediumType;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.RateType;
import com.dcits.deposit.enums.RcrRcdInd;
import com.dcits.deposit.enums.RemainTerm;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.State;
import com.dcits.deposit.enums.ToId;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranMethod;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.WithdrawalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusTranJnlEO;

/*实体表【对公存款账户金融交易流水表(RB_BUS_TRAN_JNL)】数据服务接口*/
public interface IRbBusTranJnlBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusTranJnlEO中的属性字段组合 **/
    long countByEo(RbBusTranJnlEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusTranJnlEO中的属性字段组合 **/
    int removeByEo(RbBusTranJnlEO eo);

    /** remove 根据主键: 序号、交易日期 **/
    int removeByPrimaryKey(String seqNo, Date tranDate);

    int create(RbBusTranJnlEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusTranJnlEO中不为空的属性写入数据库**/
    int createSelective(RbBusTranJnlEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusTranJnlEO中的属性字段组合 **/
    List<RbBusTranJnlEO> findByEo(RbBusTranJnlEO eo);

    /** find 根据主键: 序号、交易日期 **/
    RbBusTranJnlEO findByPrimaryKey(String seqNo, Date tranDate);

    /**  根据主键: 序号、交易日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusTranJnlEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusTranJnlEO eo);

    /** modify 根据主键: 序号、交易日期 **/
    int modifyByPrimaryKey(RbBusTranJnlEO eo);
}