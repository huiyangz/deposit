package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.ApprType;
import com.dcits.deposit.enums.FundSource;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusApprLetterEO;

/*实体表【核准件主表信息(RB_BUS_APPR_LETTER)】数据服务接口*/
public interface IRbBusApprLetterBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusApprLetterEO中的属性字段组合 **/
    long countByEo(RbBusApprLetterEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusApprLetterEO中的属性字段组合 **/
    int removeByEo(RbBusApprLetterEO eo);

    /** remove 根据主键: 核准件编号、客户号 **/
    int removeByPrimaryKey(String apprLetterNo, String clientNo);

    int create(RbBusApprLetterEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusApprLetterEO中不为空的属性写入数据库**/
    int createSelective(RbBusApprLetterEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusApprLetterEO中的属性字段组合 **/
    List<RbBusApprLetterEO> findByEo(RbBusApprLetterEO eo);

    /** find 根据主键: 核准件编号、客户号 **/
    RbBusApprLetterEO findByPrimaryKey(String apprLetterNo, String clientNo);

    /**  根据主键: 核准件编号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusApprLetterEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusApprLetterEO eo);

    /** modify 根据主键: 核准件编号、客户号 **/
    int modifyByPrimaryKey(RbBusApprLetterEO eo);
}