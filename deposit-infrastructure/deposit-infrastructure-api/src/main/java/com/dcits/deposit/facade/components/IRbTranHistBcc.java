package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AccountingStatus;
import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctClass;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AcctTranFlag;
import com.dcits.deposit.enums.AmtCalcType;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.ApprIndicator;
import com.dcits.deposit.enums.BalType;
import com.dcits.deposit.enums.BusinessUnit;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.CashSourceRemark;
import com.dcits.deposit.enums.CashUseRemark;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.FinType;
import com.dcits.deposit.enums.FromRateFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.MediumType;
import com.dcits.deposit.enums.OthBranchRegionalismCode;
import com.dcits.deposit.enums.ProfitCenter;
import com.dcits.deposit.enums.QuoteType;
import com.dcits.deposit.enums.RateType;
import com.dcits.deposit.enums.RemainTerm;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TellerTerminalType;
import com.dcits.deposit.enums.TranCategory;
import com.dcits.deposit.enums.TranMethod;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.enums.WithdrawalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbTranHistEO;

/*实体表【金融交易流水表(RB_TRAN_HIST)】数据服务接口*/
public interface IRbTranHistBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranHistEO中的属性字段组合 **/
    long countByEo(RbTranHistEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranHistEO中的属性字段组合 **/
    int removeByEo(RbTranHistEO eo);

    /** remove 根据主键: 序号、客户号、交易日期 **/
    int removeByPrimaryKey(String seqNo, String clientNo, Date tranDate);

    int create(RbTranHistEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbTranHistEO中不为空的属性写入数据库**/
    int createSelective(RbTranHistEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbTranHistEO中的属性字段组合 **/
    List<RbTranHistEO> findByEo(RbTranHistEO eo);

    /** find 根据主键: 序号、客户号、交易日期 **/
    RbTranHistEO findByPrimaryKey(String seqNo, String clientNo, Date tranDate);

    /**  根据主键: 序号、客户号、交易日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbTranHistEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbTranHistEO eo);

    /** modify 根据主键: 序号、客户号、交易日期 **/
    int modifyByPrimaryKey(RbTranHistEO eo);
}