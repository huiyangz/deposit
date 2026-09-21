package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AgreementClass;
import com.dcits.deposit.enums.AgreementStatus;
import com.dcits.deposit.enums.AgreementType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAgreementEO;

/*实体表【合同/协议信息表(RB_AGREEMENT)】数据服务接口*/
public interface IRbAgreementBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAgreementEO中的属性字段组合 **/
    long countByEo(RbAgreementEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAgreementEO中的属性字段组合 **/
    int removeByEo(RbAgreementEO eo);

    /** remove 根据主键: 协议编号、客户号 **/
    int removeByPrimaryKey(String agreementId, String clientNo);

    int create(RbAgreementEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAgreementEO中不为空的属性写入数据库**/
    int createSelective(RbAgreementEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAgreementEO中的属性字段组合 **/
    List<RbAgreementEO> findByEo(RbAgreementEO eo);

    /** find 根据主键: 协议编号、客户号 **/
    RbAgreementEO findByPrimaryKey(String agreementId, String clientNo);

    /**  根据主键: 协议编号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAgreementEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAgreementEO eo);

    /** modify 根据主键: 协议编号、客户号 **/
    int modifyByPrimaryKey(RbAgreementEO eo);
}