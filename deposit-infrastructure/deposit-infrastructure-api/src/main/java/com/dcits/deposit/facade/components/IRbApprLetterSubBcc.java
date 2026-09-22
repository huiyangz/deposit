package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.MainSubInd;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbApprLetterSubEO;

/*实体表【核准件子表信息(RB_APPR_LETTER_SUB)】数据服务接口*/
public interface IRbApprLetterSubBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbApprLetterSubEO中的属性字段组合 **/
    long countByEo(RbApprLetterSubEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbApprLetterSubEO中的属性字段组合 **/
    int removeByEo(RbApprLetterSubEO eo);

    /** remove 根据主键: 核准件编号、核准件主子标志、币种、客户号 **/
    int removeByPrimaryKey(String apprLetterNo, String mainSubInd, String ccy, String clientNo);

    int create(RbApprLetterSubEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbApprLetterSubEO中不为空的属性写入数据库**/
    int createSelective(RbApprLetterSubEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbApprLetterSubEO中的属性字段组合 **/
    List<RbApprLetterSubEO> findByEo(RbApprLetterSubEO eo);

    /** find 根据主键: 核准件编号、核准件主子标志、币种、客户号 **/
    RbApprLetterSubEO findByPrimaryKey(String apprLetterNo, String mainSubInd, String ccy, String clientNo);

    /**  根据主键: 核准件编号、核准件主子标志、币种、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbApprLetterSubEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbApprLetterSubEO eo);

    /** modify 根据主键: 核准件编号、核准件主子标志、币种、客户号 **/
    int modifyByPrimaryKey(RbApprLetterSubEO eo);
}