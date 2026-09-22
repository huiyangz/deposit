package com.dcits.deposit.facade.components;

import com.dcits.deposit.enums.AcctBranch;
import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.BatchStatus;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.Company;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IndividualFlag;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranStatus;
import com.dcits.deposit.enums.TranType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dcits.deposit.facade.eo.RbBatchTranDetailsEO;

/*实体表【批量转账信息登记薄(RB_BATCH_TRAN_DETAILS)】数据服务接口*/
public interface IRbBatchTranDetailsBcc {
    /** count数据库表记录根据入参com.dcits.deposit.facade.eo.RbBatchTranDetailsEO中的属性字段组合 **/
    long countByEo(RbBatchTranDetailsEO eo);

    /** remove数据库表记录根据入参com.dcits.deposit.facade.eo.RbBatchTranDetailsEO中的属性字段组合 **/
    int removeByEo(RbBatchTranDetailsEO eo);

    /** remove 根据主键: 批量明细序号、批次号 **/
    int removeByPrimaryKey(String batchSeqNo, String batchNo);

    int create(RbBatchTranDetailsEO eo);

    /** create数据库表记录，主键和EO对象中不允许为空的字段必填，其它可为空字段可选填，执行时根据com.dcits.deposit.facade.eo.RbBatchTranDetailsEO中不为空的属性写入数据库**/
    int createSelective(RbBatchTranDetailsEO eo);

    /** find数据库表记录根据入参com.dcits.deposit.facade.eo.RbBatchTranDetailsEO中的属性字段组合 **/
    List<RbBatchTranDetailsEO> findByEo(RbBatchTranDetailsEO eo);

    /** find 根据主键: 批量明细序号、批次号 **/
    RbBatchTranDetailsEO findByPrimaryKey(String batchSeqNo, String batchNo);

    /**  根据主键: 批量明细序号、批次号执行更新记录操作，仅更新入参com.dcits.deposit.facade.eo.RbBatchTranDetailsEO中不为空的属性字段 **/
    int modifyByPrimaryKeySelective(RbBatchTranDetailsEO eo);

    /** modify 根据主键: 批量明细序号、批次号 **/
    int modifyByPrimaryKey(RbBatchTranDetailsEO eo);
}