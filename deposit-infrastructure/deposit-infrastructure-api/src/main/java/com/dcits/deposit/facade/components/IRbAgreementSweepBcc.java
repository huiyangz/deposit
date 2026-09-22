package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.AgreementType;
import com.dcits.deposit.enums.AutoRenewRollover;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.OpenNumType;
import com.dcits.deposit.enums.OthAcctSort;
import com.dcits.deposit.enums.ReasonCode;
import com.dcits.deposit.enums.RenewAcctType;
import com.dcits.deposit.enums.RenewType;
import com.dcits.deposit.enums.TermType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAgreementSweepEO;

/*实体表【账户约定转账协议表(RB_AGREEMENT_SWEEP)】数据服务接口*/
public interface IRbAgreementSweepBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAgreementSweepEO中的属性字段组合 **/
    long countByEo(RbAgreementSweepEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAgreementSweepEO中的属性字段组合 **/
    int removeByEo(RbAgreementSweepEO eo);

    /** remove 根据主键: 协议编号、客户号 **/
    int removeByPrimaryKey(String agreementId, String clientNo);

    int create(RbAgreementSweepEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAgreementSweepEO中不为空的属性写入数据库**/
    int createSelective(RbAgreementSweepEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAgreementSweepEO中的属性字段组合 **/
    List<RbAgreementSweepEO> findByEo(RbAgreementSweepEO eo);

    /** find 根据主键: 协议编号、客户号 **/
    RbAgreementSweepEO findByPrimaryKey(String agreementId, String clientNo);

    /**  根据主键: 协议编号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAgreementSweepEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAgreementSweepEO eo);

    /** modify 根据主键: 协议编号、客户号 **/
    int modifyByPrimaryKey(RbAgreementSweepEO eo);
}