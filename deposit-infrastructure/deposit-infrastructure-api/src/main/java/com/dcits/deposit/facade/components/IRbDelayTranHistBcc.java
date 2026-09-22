package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.ArrivalStatus;
import com.dcits.deposit.enums.BankInOut;
import com.dcits.deposit.enums.CashItem;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranMethod;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbDelayTranHistEO;

/*实体表【24小时转账流水表(RB_DELAY_TRAN_HIST)】数据服务接口*/
public interface IRbDelayTranHistBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbDelayTranHistEO中的属性字段组合 **/
    long countByEo(RbDelayTranHistEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbDelayTranHistEO中的属性字段组合 **/
    int removeByEo(RbDelayTranHistEO eo);

    /** remove 根据主键: 序号、客户号、交易日期 **/
    int removeByPrimaryKey(String seqNo, String clientNo, Date tranDate);

    int create(RbDelayTranHistEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbDelayTranHistEO中不为空的属性写入数据库**/
    int createSelective(RbDelayTranHistEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbDelayTranHistEO中的属性字段组合 **/
    List<RbDelayTranHistEO> findByEo(RbDelayTranHistEO eo);

    /** find 根据主键: 序号、客户号、交易日期 **/
    RbDelayTranHistEO findByPrimaryKey(String seqNo, String clientNo, Date tranDate);

    /**  根据主键: 序号、客户号、交易日期执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbDelayTranHistEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbDelayTranHistEO eo);

    /** modify 根据主键: 序号、客户号、交易日期 **/
    int modifyByPrimaryKey(RbDelayTranHistEO eo);
}