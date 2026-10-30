package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AgreementClass;
import com.dcits.deposit.enums.AgreementSignEffectStatus;
import com.dcits.deposit.enums.GreementSignStatus;
import com.dcits.deposit.enums.RbBusAgreementType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusAgreementEO;

/*实体表【对公存款协议信息表(RB_BUS_AGREEMENT)】数据服务接口*/
public interface IRbBusAgreementBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAgreementEO中的属性字段组合 **/
    long countByEo(RbBusAgreementEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAgreementEO中的属性字段组合 **/
    int removeByEo(RbBusAgreementEO eo);

    /** remove 根据主键: 协议编号 **/
    int removeByPrimaryKey(String agreementId);

    int create(RbBusAgreementEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusAgreementEO中不为空的属性写入数据库**/
    int createSelective(RbBusAgreementEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAgreementEO中的属性字段组合 **/
    List<RbBusAgreementEO> findByEo(RbBusAgreementEO eo);

    /** find 根据主键: 协议编号 **/
    RbBusAgreementEO findByPrimaryKey(String agreementId);

    /**  根据主键: 协议编号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusAgreementEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusAgreementEO eo);

    /** modify 根据主键: 协议编号 **/
    int modifyByPrimaryKey(RbBusAgreementEO eo);
}