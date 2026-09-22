package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AmtType;
import com.dcits.deposit.enums.BankInOut;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.PayRecInd;
import com.dcits.deposit.enums.SettleAcctClass;
import com.dcits.deposit.enums.SettleBankFlag;
import com.dcits.deposit.enums.SettleMethod;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbAcctSettleEO;

/*实体表【账户结算信息表(RB_ACCT_SETTLE)】数据服务接口*/
public interface IRbAcctSettleBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctSettleEO中的属性字段组合 **/
    long countByEo(RbAcctSettleEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctSettleEO中的属性字段组合 **/
    int removeByEo(RbAcctSettleEO eo);

    /** remove 根据主键: 账户内部键值、结算编号、客户号 **/
    int removeByPrimaryKey(Integer internalKey, String settleNo, String clientNo);

    int create(RbAcctSettleEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbAcctSettleEO中不为空的属性写入数据库**/
    int createSelective(RbAcctSettleEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbAcctSettleEO中的属性字段组合 **/
    List<RbAcctSettleEO> findByEo(RbAcctSettleEO eo);

    /** find 根据主键: 账户内部键值、结算编号、客户号 **/
    RbAcctSettleEO findByPrimaryKey(Integer internalKey, String settleNo, String clientNo);

    /**  根据主键: 账户内部键值、结算编号、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbAcctSettleEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbAcctSettleEO eo);

    /** modify 根据主键: 账户内部键值、结算编号、客户号 **/
    int modifyByPrimaryKey(RbAcctSettleEO eo);
}