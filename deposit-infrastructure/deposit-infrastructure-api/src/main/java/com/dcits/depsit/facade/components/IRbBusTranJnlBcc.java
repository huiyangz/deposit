package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.AccountingStatus;
import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.AcctClass;
import com.dcits.depsit.enums.AcctSetType;
import com.dcits.depsit.enums.AcctStatus;
import com.dcits.depsit.enums.AcctTranFlag;
import com.dcits.depsit.enums.AmtCalcType;
import com.dcits.depsit.enums.ApprIndicator;
import com.dcits.depsit.enums.AutoReversalFlag;
import com.dcits.depsit.enums.BalType;
import com.dcits.depsit.enums.CashItem;
import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.enums.ClientType;
import com.dcits.depsit.enums.CrDrInd;
import com.dcits.depsit.enums.DocType;
import com.dcits.depsit.enums.FromRateFlag;
import com.dcits.depsit.enums.IntCalcAmtType;
import com.dcits.depsit.enums.IssCountry;
import com.dcits.depsit.enums.MediumFlag;
import com.dcits.depsit.enums.MediumType;
import com.dcits.depsit.enums.OthTranType;
import com.dcits.depsit.enums.ProfitCenter;
import com.dcits.depsit.enums.RateType;
import com.dcits.depsit.enums.RcrRcdInd;
import com.dcits.depsit.enums.RemainTerm;
import com.dcits.depsit.enums.SourceModule;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.State;
import com.dcits.depsit.enums.ThawDocumentType2;
import com.dcits.depsit.enums.ToId;
import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.enums.TranMethod;
import com.dcits.depsit.enums.TranStatus;
import com.dcits.depsit.enums.WithdrawalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.depsit.facade.eo.RbBusTranJnlEO;

/*实体表【对公存款账户金融交易流水表(RB_BUS_TRAN_JNL)】数据服务接口*/
public interface IRbBusTranJnlBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.RbBusTranJnlEO中的属性字段组合 **/
    long countByEo(RbBusTranJnlEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.RbBusTranJnlEO中的属性字段组合 **/
    int removeByEo(RbBusTranJnlEO eo);

    /** remove 根据主键: 序号、交易日期 **/
    int removeByPrimaryKey(String seqNo, Date tranDate);

    int create(RbBusTranJnlEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.RbBusTranJnlEO中不为空的属性写入数据库**/
    int createSelective(RbBusTranJnlEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.RbBusTranJnlEO中的属性字段组合 **/
    List<RbBusTranJnlEO> findByEo(RbBusTranJnlEO eo);

    /** find 根据主键: 序号、交易日期 **/
    RbBusTranJnlEO findByPrimaryKey(String seqNo, Date tranDate);

    /**  根据主键: 序号、交易日期执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.RbBusTranJnlEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusTranJnlEO eo);

    /** modify 根据主键: 序号、交易日期 **/
    int modifyByPrimaryKey(RbBusTranJnlEO eo);
}