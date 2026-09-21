package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CommissionFlag;
import com.dcits.deposit.enums.CommissionRelation;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbCommissionRegisterEO;

/*实体表【代办人登记表(RB_COMMISSION_REGISTER)】数据服务接口*/
public interface IRbCommissionRegisterBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbCommissionRegisterEO中的属性字段组合 **/
    long countByEo(RbCommissionRegisterEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbCommissionRegisterEO中的属性字段组合 **/
    int removeByEo(RbCommissionRegisterEO eo);

    /** remove 根据主键: 渠道流水号、客户号 **/
    int removeByPrimaryKey(String channelSeqNo, String clientNo);

    int create(RbCommissionRegisterEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbCommissionRegisterEO中不为空的属性写入数据库**/
    int createSelective(RbCommissionRegisterEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbCommissionRegisterEO中的属性字段组合 **/
    List<RbCommissionRegisterEO> findByEo(RbCommissionRegisterEO eo);

    /** find 根据主键: 渠道流水号、客户号 **/
    RbCommissionRegisterEO findByPrimaryKey(String channelSeqNo, String clientNo);

    /**  根据主键: 渠道流水号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbCommissionRegisterEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbCommissionRegisterEO eo);

    /** modify 根据主键: 渠道流水号、客户号 **/
    int modifyByPrimaryKey(RbCommissionRegisterEO eo);
}