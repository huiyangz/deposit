package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.ArrivalStatus;
import com.dcits.deposit.enums.BankInOut;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranMethod;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusDelayTransferDtlEO;

/*实体表【对公存款延时转账明细表(RB_BUS_DELAY_TRANSFER_DTL)】数据服务接口*/
public interface IRbBusDelayTransferDtlBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusDelayTransferDtlEO中的属性字段组合 **/
    long countByEo(RbBusDelayTransferDtlEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusDelayTransferDtlEO中的属性字段组合 **/
    int removeByEo(RbBusDelayTransferDtlEO eo);

    /** remove 根据主键: 序号、交易日期 **/
    int removeByPrimaryKey(String seqNo, Date tranDate);

    int create(RbBusDelayTransferDtlEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusDelayTransferDtlEO中不为空的属性写入数据库**/
    int createSelective(RbBusDelayTransferDtlEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusDelayTransferDtlEO中的属性字段组合 **/
    List<RbBusDelayTransferDtlEO> findByEo(RbBusDelayTransferDtlEO eo);

    /** find 根据主键: 序号、交易日期 **/
    RbBusDelayTransferDtlEO findByPrimaryKey(String seqNo, Date tranDate);

    /**  根据主键: 序号、交易日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusDelayTransferDtlEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusDelayTransferDtlEO eo);

    /** modify 根据主键: 序号、交易日期 **/
    int modifyByPrimaryKey(RbBusDelayTransferDtlEO eo);
}