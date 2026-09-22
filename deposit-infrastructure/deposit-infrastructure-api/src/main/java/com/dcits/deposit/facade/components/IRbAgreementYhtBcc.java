package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctSettleMethod;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SettleInd;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.YhtAcctFlag;
import com.dcits.deposit.enums.YhtAcctOrgSchema;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAgreementYhtEO;

/*实体表【一户通子协议表(RB_AGREEMENT_YHT)】数据服务接口*/
public interface IRbAgreementYhtBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAgreementYhtEO中的属性字段组合 **/
    long countByEo(RbAgreementYhtEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAgreementYhtEO中的属性字段组合 **/
    int removeByEo(RbAgreementYhtEO eo);

    /** remove 根据主键: 协议编号、客户号 **/
    int removeByPrimaryKey(String agreementId, String clientNo);

    int create(RbAgreementYhtEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAgreementYhtEO中不为空的属性写入数据库**/
    int createSelective(RbAgreementYhtEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAgreementYhtEO中的属性字段组合 **/
    List<RbAgreementYhtEO> findByEo(RbAgreementYhtEO eo);

    /** find 根据主键: 协议编号、客户号 **/
    RbAgreementYhtEO findByPrimaryKey(String agreementId, String clientNo);

    /**  根据主键: 协议编号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAgreementYhtEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAgreementYhtEO eo);

    /** modify 根据主键: 协议编号、客户号 **/
    int modifyByPrimaryKey(RbAgreementYhtEO eo);
}