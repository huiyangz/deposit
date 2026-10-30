package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctSettleMethod;
import com.dcits.deposit.enums.AgreementSignEffectStatus;
import com.dcits.deposit.enums.GreementSignStatus;
import com.dcits.deposit.enums.SettleInd;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.YhtAcctFlag;
import com.dcits.deposit.enums.YhtAcctOrgSchema;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusAgreementYhtEO;

/*实体表【对公一户通子协议表(RB_BUS_AGREEMENT_YHT)】数据服务接口*/
public interface IRbBusAgreementYhtBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAgreementYhtEO中的属性字段组合 **/
    long countByEo(RbBusAgreementYhtEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAgreementYhtEO中的属性字段组合 **/
    int removeByEo(RbBusAgreementYhtEO eo);

    /** remove 根据主键: 协议编号 **/
    int removeByPrimaryKey(String agreementId);

    int create(RbBusAgreementYhtEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusAgreementYhtEO中不为空的属性写入数据库**/
    int createSelective(RbBusAgreementYhtEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAgreementYhtEO中的属性字段组合 **/
    List<RbBusAgreementYhtEO> findByEo(RbBusAgreementYhtEO eo);

    /** find 根据主键: 协议编号 **/
    RbBusAgreementYhtEO findByPrimaryKey(String agreementId);

    /**  根据主键: 协议编号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusAgreementYhtEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusAgreementYhtEO eo);

    /** modify 根据主键: 协议编号 **/
    int modifyByPrimaryKey(RbBusAgreementYhtEO eo);
}