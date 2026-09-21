package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctPaymentStatus;
import com.dcits.deposit.enums.AcglFlag;
import com.dcits.deposit.enums.BillType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.CrDrInd;
import com.dcits.deposit.enums.Direction;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.HangStatus;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.PtPaymentTranHistEO;

/*实体表【支付核心交易流水表(PT_PAYMENT_TRAN_HIST)】数据服务接口*/
public interface IPtPaymentTranHistBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.PtPaymentTranHistEO中的属性字段组合 **/
    long countByEo(PtPaymentTranHistEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.PtPaymentTranHistEO中的属性字段组合 **/
    int removeByEo(PtPaymentTranHistEO eo);

    /** remove 根据主键: 渠道流水号、渠道子流水号、交易日期、客户号 **/
    int removeByPrimaryKey(String channelSeqNo, String channelSubSeqNo, Date tranDate, String clientNo);

    int create(PtPaymentTranHistEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.PtPaymentTranHistEO中不为空的属性写入数据库**/
    int createSelective(PtPaymentTranHistEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.PtPaymentTranHistEO中的属性字段组合 **/
    List<PtPaymentTranHistEO> findByEo(PtPaymentTranHistEO eo);

    /** find 根据主键: 渠道流水号、渠道子流水号、交易日期、客户号 **/
    PtPaymentTranHistEO findByPrimaryKey(String channelSeqNo, String channelSubSeqNo, Date tranDate, String clientNo);

    /**  根据主键: 渠道流水号、渠道子流水号、交易日期、客户号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.PtPaymentTranHistEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(PtPaymentTranHistEO eo);

    /** modify 根据主键: 渠道流水号、渠道子流水号、交易日期、客户号 **/
    int modifyByPrimaryKey(PtPaymentTranHistEO eo);
}