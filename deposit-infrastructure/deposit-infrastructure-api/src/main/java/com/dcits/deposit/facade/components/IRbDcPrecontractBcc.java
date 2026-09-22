package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNature;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CycleFreq;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.IntCalcType;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.enums.PayIntMode;
import com.dcits.deposit.enums.PrecontractStatus;
import com.dcits.deposit.enums.PrecontractType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.StageLimitClass;
import com.dcits.deposit.enums.StageProdClass;
import com.dcits.deposit.enums.WithdrawalType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbDcPrecontractEO;

/*实体表【大额存单登记表(RB_DC_PRECONTRACT)】数据服务接口*/
public interface IRbDcPrecontractBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbDcPrecontractEO中的属性字段组合 **/
    long countByEo(RbDcPrecontractEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbDcPrecontractEO中的属性字段组合 **/
    int removeByEo(RbDcPrecontractEO eo);

    /** remove 根据主键: 预约编号、客户号 **/
    int removeByPrimaryKey(String precontractNo, String clientNo);

    int create(RbDcPrecontractEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbDcPrecontractEO中不为空的属性写入数据库**/
    int createSelective(RbDcPrecontractEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbDcPrecontractEO中的属性字段组合 **/
    List<RbDcPrecontractEO> findByEo(RbDcPrecontractEO eo);

    /** find 根据主键: 预约编号、客户号 **/
    RbDcPrecontractEO findByPrimaryKey(String precontractNo, String clientNo);

    /**  根据主键: 预约编号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbDcPrecontractEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbDcPrecontractEO eo);

    /** modify 根据主键: 预约编号、客户号 **/
    int modifyByPrimaryKey(RbDcPrecontractEO eo);
}