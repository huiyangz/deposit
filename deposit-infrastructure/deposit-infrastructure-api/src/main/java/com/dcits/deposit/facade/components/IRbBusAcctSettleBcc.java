package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BankInOut;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.IntCalcAmtType;
import com.dcits.deposit.enums.PayRecInd;
import com.dcits.deposit.enums.SettleAcctClass;
import com.dcits.deposit.enums.SettleBankFlag;
import com.dcits.deposit.enums.SettleMethod;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBusAcctSettleEO;

/*实体表【对公存款账户结算信息表(RB_BUS_ACCT_SETTLE)】数据服务接口*/
public interface IRbBusAcctSettleBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAcctSettleEO中的属性字段组合 **/
    long countByEo(RbBusAcctSettleEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAcctSettleEO中的属性字段组合 **/
    int removeByEo(RbBusAcctSettleEO eo);

    /** remove 根据主键: 账户内部键值、结算编号 **/
    int removeByPrimaryKey(Integer internalKey, String settleNo);

    int create(RbBusAcctSettleEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBusAcctSettleEO中不为空的属性写入数据库**/
    int createSelective(RbBusAcctSettleEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBusAcctSettleEO中的属性字段组合 **/
    List<RbBusAcctSettleEO> findByEo(RbBusAcctSettleEO eo);

    /** find 根据主键: 账户内部键值、结算编号 **/
    RbBusAcctSettleEO findByPrimaryKey(Integer internalKey, String settleNo);

    /**  根据主键: 账户内部键值、结算编号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBusAcctSettleEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBusAcctSettleEO eo);

    /** modify 根据主键: 账户内部键值、结算编号 **/
    int modifyByPrimaryKey(RbBusAcctSettleEO eo);
}