package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST056InputBO;
import com.dcits.deposit.facade.bo.ST056OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST056 检查是否存在转账不收不付限制。
 *
 * <p>步骤描述条目 1：按 baseAcctNo 与限制状态「A-生效」查询【账户限制信息】（对公存款账户
 * 限制表）取得限制编号（resSeqNo）与账户限制类型（restraintType）；条目 2：按账户限制类型
 * 与状态「A-生效」查询【限制类型表】（存款限制类型表）取得借贷方控制标志（drCrCtlFlag）与
 * 转账标志（transferFlag）；条目 3：借贷方控制标志等于「A-禁止借贷方」（{@link DrCrCtlFlag#A}）
 * 且转账标志等于「N-禁止转账」时返回转账不收不付标志=「是」，否则返回「否」。</p>
 *
 * <p>多条匹配记录、查询无匹配记录与 baseAcctNo 缺失等未决行为见 {@link #execute(ST056InputBO)}
 * 中 FIXME（对应 Spec 待确认事项 1、2、3、7）。</p>
 */
@Service
public class ST056Pbc implements IST056 {
    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Autowired
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @Override
    public ST056OutputBO execute(ST056InputBO input) {
        ST056OutputBO result = new ST056OutputBO();
        // 子步骤1 查询【账户限制信息】：以 baseAcctNo 与限制状态「A-生效」（RestraintsStatus.A）为条件查询对公存款账户限制表，取得限制编号与账户限制类型
                                                                                                                                                                                                       
                                                                                                                                                                                                                                              
                                                           
                                                           
        RbBusRestraintsEO restraintQuery = new RbBusRestraintsEO();
        restraintQuery.setBaseAcctNo(input.getBaseAcctNo());
        restraintQuery.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintRecords = rbBusRestraintsBcc.findByEo(restraintQuery);
        RbBusRestraintsEO restraintRecord = null;
        if (restraintRecords != null) {
            for (RbBusRestraintsEO record : restraintRecords) {
                if (record.getRestraintsStatus() == RestraintsStatus.A) {
                    restraintRecord = record;
                    break;
                }
            }
        }
        // 子步骤2 查询【限制类型表】：以步骤1取得的账户限制类型与状态「A-生效」（Status.A）为条件查询存款限制类型表，取得借贷方控制标志与转账标志
                                                                                                                                                                                           
                                                           
        RbRestraintTypeEO typeRecord = null;
        if (restraintRecord != null && restraintRecord.getRestraintType() != null) {
            RbRestraintTypeEO typeQuery = new RbRestraintTypeEO();
            typeQuery.setRestraintType(restraintRecord.getRestraintType());
            typeQuery.setStatus(Status.A);
            List<RbRestraintTypeEO> typeRecords = rbRestraintTypeBcc.findByEo(typeQuery);
            if (typeRecords != null) {
                for (RbRestraintTypeEO record : typeRecords) {
                    if (record.getStatus() == Status.A) {
                        typeRecord = record;
                        break;
                    }
                }
            }
        }
        // 子步骤3 转账不收不付标志判定：借贷方控制标志等于「A-禁止借贷方」（DrCrCtlFlag.A）且转账标志等于「N-禁止转账」时返回「是」，否则返回「否」
                                                                                                                                                                                                                                                       
                                                           
        if (typeRecord != null && typeRecord.getDrCrCtlFlag() == DrCrCtlFlag.A
                && "N".equals(typeRecord.getTransferFlag())) {
            result.setTransferNoCreditNoDebitFlag("是");
        } else {
            result.setTransferNoCreditNoDebitFlag("否");
        }
        if (restraintRecord != null) {
            result.setResSeqNo(restraintRecord.getResSeqNo());
            result.setRestraintType(restraintRecord.getRestraintType());
            result.setRestraintsStatus(restraintRecord.getRestraintsStatus());
        }
        if (typeRecord != null) {
            result.setDrCrCtlFlag(typeRecord.getDrCrCtlFlag());
            result.setStatus(typeRecord.getStatus());
            result.setTransferFlag(typeRecord.getTransferFlag());
            result.setStopFlag(typeRecord.getStopFlag());
        }
                                                                                                                                                                                                                                                                    
        // 正常完成（含「否则返回『否』」分支）：显式置成功，错误字段保持为空
                                                           
        result.setSucceed(true);
        return result;
    }
}
