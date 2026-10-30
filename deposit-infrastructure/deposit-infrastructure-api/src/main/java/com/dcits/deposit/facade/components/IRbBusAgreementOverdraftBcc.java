package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AgreementSignEffectStatus;
import com.dcits.deposit.enums.AmortizeTimeType;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.FeeTakenMode;
import com.dcits.deposit.enums.FeeType;
import com.dcits.deposit.enums.GreementSignStatus;
import com.dcits.deposit.enums.IsOverMonthSeasonOd;
import com.dcits.deposit.enums.OdMaturityRule;
import com.dcits.deposit.enums.OdMethod;
import com.dcits.deposit.enums.OdMode;
import com.dcits.deposit.enums.OdPayMethod;
import com.dcits.deposit.enums.RbBusAgreementType;
import com.dcits.deposit.enums.RollFreq;
import com.dcits.deposit.enums.TermType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusAgreementOverdraftEO;

/*实体表【对公透支签约表(RB_BUS_AGREEMENT_OVERDRAFT)】数据服务接口*/
public interface IRbBusAgreementOverdraftBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAgreementOverdraftEO中的属性字段组合 **/
    long countByEo(RbBusAgreementOverdraftEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAgreementOverdraftEO中的属性字段组合 **/
    int removeByEo(RbBusAgreementOverdraftEO eo);

    /** remove 根据主键: 协议编号 **/
    int removeByPrimaryKey(String agreementId);

    int create(RbBusAgreementOverdraftEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusAgreementOverdraftEO中不为空的属性写入数据库**/
    int createSelective(RbBusAgreementOverdraftEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAgreementOverdraftEO中的属性字段组合 **/
    List<RbBusAgreementOverdraftEO> findByEo(RbBusAgreementOverdraftEO eo);

    /** find 根据主键: 协议编号 **/
    RbBusAgreementOverdraftEO findByPrimaryKey(String agreementId);

    /**  根据主键: 协议编号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusAgreementOverdraftEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusAgreementOverdraftEO eo);

    /** modify 根据主键: 协议编号 **/
    int modifyByPrimaryKey(RbBusAgreementOverdraftEO eo);
}