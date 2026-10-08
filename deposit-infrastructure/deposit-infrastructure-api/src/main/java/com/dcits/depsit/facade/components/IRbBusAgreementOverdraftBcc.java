package com.dcits.depsit.facade.components;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.AgreementSignEffectStatus;
import com.dcits.depsit.enums.AmortizeTimeType;
import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.enums.FeeTakenMode;
import com.dcits.depsit.enums.FeeType;
import com.dcits.depsit.enums.GreementSignStatus;
import com.dcits.depsit.enums.IsOverMonthSeasonOd;
import com.dcits.depsit.enums.OdMaturityRule;
import com.dcits.depsit.enums.OdMethod;
import com.dcits.depsit.enums.OdMode;
import com.dcits.depsit.enums.OdPayMethod;
import com.dcits.depsit.enums.RbBusAgreementType;
import com.dcits.depsit.enums.RollFreq;
import com.dcits.depsit.enums.TermType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.depsit.facade.eo.RbBusAgreementOverdraftEO;

/*实体表【对公透支签约表(RB_BUS_AGREEMENT_OVERDRAFT)】数据服务接口*/
public interface IRbBusAgreementOverdraftBcc {
    /** count数据库表记录根据入参com.dcits.depsit.facade.eo.RbBusAgreementOverdraftEO中的属性字段组合 **/
    long countByEo(RbBusAgreementOverdraftEO eo);

    /** remove数据库表记录根据入参com.dcits.depsit.facade.eo.RbBusAgreementOverdraftEO中的属性字段组合 **/
    int removeByEo(RbBusAgreementOverdraftEO eo);

    /** remove 根据主键: 协议编号 **/
    int removeByPrimaryKey(String agreementId);

    int create(RbBusAgreementOverdraftEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.depsit.facade.eo.RbBusAgreementOverdraftEO中不为空的属性写入数据库**/
    int createSelective(RbBusAgreementOverdraftEO eo);

    /** find数据库表记录根据入参com.dcits.depsit.facade.eo.RbBusAgreementOverdraftEO中的属性字段组合 **/
    List<RbBusAgreementOverdraftEO> findByEo(RbBusAgreementOverdraftEO eo);

    /** find 根据主键: 协议编号 **/
    RbBusAgreementOverdraftEO findByPrimaryKey(String agreementId);

    /**  根据主键: 协议编号执行更新记录操作，仅更新入参com.dcits.depsit.facade.eo.RbBusAgreementOverdraftEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusAgreementOverdraftEO eo);

    /** modify 根据主键: 协议编号 **/
    int modifyByPrimaryKey(RbBusAgreementOverdraftEO eo);
}