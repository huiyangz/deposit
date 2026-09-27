package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.enums.TranBranch;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.TbCashBalanceEO;

/*实体表【尾箱现金余额表(TB_CASH_BALANCE)】数据服务接口*/
public interface ITbCashBalanceBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.TbCashBalanceEO中的属性字段组合 **/
    long countByEo(TbCashBalanceEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.TbCashBalanceEO中的属性字段组合 **/
    int removeByEo(TbCashBalanceEO eo);

    /** remove 根据主键: 交易时间戳、更新日期、归属机构号、上日期末余额、尾箱编号、可用余额、上日期初金额、锁定完整币金额、法人、金额、币种、锁定残损币金额、现金主键、最后修改日期、创建时间戳 **/
    int removeByPrimaryKey(String tranTimestamp, Date updateDate, String branch, BigDecimal eopdAmount, String tailboxId, BigDecimal availableAmt, BigDecimal sopdAmount, BigDecimal lockAmount, String company, BigDecimal amount, String ccy, BigDecimal lockSpallAmt, Integer cashId, Date lastChangeDate, String createTimestamp);

    int create(TbCashBalanceEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.TbCashBalanceEO中不为空的属性写入数据库**/
    int createSelective(TbCashBalanceEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.TbCashBalanceEO中的属性字段组合 **/
    List<TbCashBalanceEO> findByEo(TbCashBalanceEO eo);

    /** find 根据主键: 交易时间戳、更新日期、归属机构号、上日期末余额、尾箱编号、可用余额、上日期初金额、锁定完整币金额、法人、金额、币种、锁定残损币金额、现金主键、最后修改日期、创建时间戳 **/
    TbCashBalanceEO findByPrimaryKey(String tranTimestamp, Date updateDate, String branch, BigDecimal eopdAmount, String tailboxId, BigDecimal availableAmt, BigDecimal sopdAmount, BigDecimal lockAmount, String company, BigDecimal amount, String ccy, BigDecimal lockSpallAmt, Integer cashId, Date lastChangeDate, String createTimestamp);

    /**  根据主键: 交易时间戳、更新日期、归属机构号、上日期末余额、尾箱编号、可用余额、上日期初金额、锁定完整币金额、法人、金额、币种、锁定残损币金额、现金主键、最后修改日期、创建时间戳执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.TbCashBalanceEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(TbCashBalanceEO eo);

    /** modify 根据主键: 交易时间戳、更新日期、归属机构号、上日期末余额、尾箱编号、可用余额、上日期初金额、锁定完整币金额、法人、金额、币种、锁定残损币金额、现金主键、最后修改日期、创建时间戳 **/
    int modifyByPrimaryKey(TbCashBalanceEO eo);
}