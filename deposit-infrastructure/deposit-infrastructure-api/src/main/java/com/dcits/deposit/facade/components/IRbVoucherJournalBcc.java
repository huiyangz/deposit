package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.CanReasonCode;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.SourceModule;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.VoucherStatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbVoucherJournalEO;

/*实体表【凭证账户流水表(RB_VOUCHER_JOURNAL)】数据服务接口*/
public interface IRbVoucherJournalBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbVoucherJournalEO中的属性字段组合 **/
    long countByEo(RbVoucherJournalEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbVoucherJournalEO中的属性字段组合 **/
    int removeByEo(RbVoucherJournalEO eo);

    /** remove 根据主键: 凭证流水ID、客户号、交易日期 **/
    int removeByPrimaryKey(String voucherJournalId, String clientNo, Date tranDate);

    int create(RbVoucherJournalEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbVoucherJournalEO中不为空的属性写入数据库**/
    int createSelective(RbVoucherJournalEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbVoucherJournalEO中的属性字段组合 **/
    List<RbVoucherJournalEO> findByEo(RbVoucherJournalEO eo);

    /** find 根据主键: 凭证流水ID、客户号、交易日期 **/
    RbVoucherJournalEO findByPrimaryKey(String voucherJournalId, String clientNo, Date tranDate);

    /**  根据主键: 凭证流水ID、客户号、交易日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbVoucherJournalEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbVoucherJournalEO eo);

    /** modify 根据主键: 凭证流水ID、客户号、交易日期 **/
    int modifyByPrimaryKey(RbVoucherJournalEO eo);
}