package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.MoveType;
import com.dcits.deposit.enums.PayRecInd;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.TbCashJournalEO;

/*实体表【尾箱现金更新流水表(TB_CASH_JOURNAL)】数据服务接口*/
public interface ITbCashJournalBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.TbCashJournalEO中的属性字段组合 **/
    long countByEo(TbCashJournalEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.TbCashJournalEO中的属性字段组合 **/
    int removeByEo(TbCashJournalEO eo);

    /** remove 根据主键: 流水号、交易日期 **/
    int removeByPrimaryKey(String journalId, Date tranDate);

    int create(TbCashJournalEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.TbCashJournalEO中不为空的属性写入数据库**/
    int createSelective(TbCashJournalEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.TbCashJournalEO中的属性字段组合 **/
    List<TbCashJournalEO> findByEo(TbCashJournalEO eo);

    /** find 根据主键: 流水号、交易日期 **/
    TbCashJournalEO findByPrimaryKey(String journalId, Date tranDate);

    /**  根据主键: 流水号、交易日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.TbCashJournalEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(TbCashJournalEO eo);

    /** modify 根据主键: 流水号、交易日期 **/
    int modifyByPrimaryKey(TbCashJournalEO eo);
}