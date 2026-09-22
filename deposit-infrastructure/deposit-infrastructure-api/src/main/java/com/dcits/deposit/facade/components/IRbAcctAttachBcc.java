package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctOpenMode;
import com.dcits.deposit.enums.AcctOpenType;
import com.dcits.deposit.enums.AcctProperty2;
import com.dcits.deposit.enums.AcctRiskLevel;
import com.dcits.deposit.enums.AcctTellerSignFlag;
import com.dcits.deposit.enums.AcctVerifyResult;
import com.dcits.deposit.enums.AgreementDepositType;
import com.dcits.deposit.enums.AmountNature;
import com.dcits.deposit.enums.AnnualStatus;
import com.dcits.deposit.enums.BalanceWay;
import com.dcits.deposit.enums.BalUpdType;
import com.dcits.deposit.enums.BlacklistStatus;
import com.dcits.deposit.enums.CaseInvolvedFlag;
import com.dcits.deposit.enums.CheckCertificateType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DepositNature;
import com.dcits.deposit.enums.FarmerFlag;
import com.dcits.deposit.enums.HangWriteOffFlag;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.LoanFundFlag;
import com.dcits.deposit.enums.ManageType;
import com.dcits.deposit.enums.MsgStatus;
import com.dcits.deposit.enums.ProdClass;
import com.dcits.deposit.enums.SimpleAcct;
import com.dcits.deposit.enums.SpecialProdClass;
import com.dcits.deposit.enums.StageLimitClass;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.Treatment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAcctAttachEO;

/*实体表【账户辅助信息表(RB_ACCT_ATTACH)】数据服务接口*/
public interface IRbAcctAttachBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctAttachEO中的属性字段组合 **/
    long countByEo(RbAcctAttachEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctAttachEO中的属性字段组合 **/
    int removeByEo(RbAcctAttachEO eo);

    /** remove 根据主键: 账户内部键值、客户号 **/
    int removeByPrimaryKey(Integer internalKey, String clientNo);

    int create(RbAcctAttachEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAcctAttachEO中不为空的属性写入数据库**/
    int createSelective(RbAcctAttachEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctAttachEO中的属性字段组合 **/
    List<RbAcctAttachEO> findByEo(RbAcctAttachEO eo);

    /** find 根据主键: 账户内部键值、客户号 **/
    RbAcctAttachEO findByPrimaryKey(Integer internalKey, String clientNo);

    /**  根据主键: 账户内部键值、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAcctAttachEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAcctAttachEO eo);

    /** modify 根据主键: 账户内部键值、客户号 **/
    int modifyByPrimaryKey(RbAcctAttachEO eo);
}