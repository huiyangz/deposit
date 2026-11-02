package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST052InputBO;
import com.dcits.deposit.facade.bo.ST052OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST052 检查是否存在转账止付限制 步骤实现。
 *
 * <p>流程：REQ-001 按输入账号 baseAcctNo 与限制状态「A-生效」（{@code RestraintsStatus.A}）查询
 * 对公存款账户限制表（RB_BUS_RESTRAINTS），取得账户限制类型与限制编号；REQ-002 按 REQ-001 取得的
 * 账户限制类型与状态「A-生效」（{@code Status.A}）查询存款限制类型表（RB_RESTRAINT_TYPE），
 * 取得借贷方控制标志与转账标志；REQ-003 当借贷方控制标志等于「D-禁止借方」（{@code DrCrCtlFlag.D}）
 * 且转账标志等于「N-不允许转账」时，返回转账止付标志「是」，否则返回「否」。</p>
 *
 * <p>查询无记录（TBD-1）、多条生效限制记录（TBD-2）、stopFlag 承载与物理值（TBD-3）、
 * 「A-生效」标签口径（TBD-4，不影响代码值 "A" 的使用）、baseAcctNo 缺失行为（TBD-5）
 * 见 {@code execute} 中 FIXME，待业务确认后落实。</p>
 */
@Service
public class ST052Pbc implements IST052 {

    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Autowired
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @Override
    public ST052OutputBO execute(ST052InputBO input) {
        ST052OutputBO output = new ST052OutputBO();

        // 子步骤 REQ-001 查询账户限制信息：按 baseAcctNo 与限制状态「A-生效」（RestraintsStatus.A）
        // 查询对公存款账户限制表，取得账户限制类型（restraintType）与限制编号（resSeqNo）。
                                                                                                                                                                                            
                                                           
        RbBusRestraintsEO restraintsQuery = new RbBusRestraintsEO();
        restraintsQuery.setBaseAcctNo(input.getBaseAcctNo());
        restraintsQuery.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(restraintsQuery);

                                                                                                                                                                                                                     
                                                           
        if (restraintsList == null || restraintsList.isEmpty()) {
            // TBD-1 未确认：查询无生效限制记录时的行为，暂按查询为空正常提前结束返回（不设置业务字段），
            // 不作为业务失败；该路径结果待业务确认后实现。
            output.setSucceed(true);
            return output;
        }

                                                                                                                                                                                                                                        
                                                           
        RbBusRestraintsEO restraints = restraintsList.get(0);
        output.setResSeqNo(restraints.getResSeqNo());
        output.setRestraintType(restraints.getRestraintType());
        output.setRestraintsStatus(restraints.getRestraintsStatus());

        // 子步骤 REQ-002 查询限制类型表：按 REQ-001 取得的账户限制类型与状态「A-生效」（Status.A）
        // 查询存款限制类型表，取得借贷方控制标志（drCrCtlFlag）与转账标志（transferFlag）。
        // 按组合条件查询（不使用仅按类型查询、不按状态过滤的 findByRestraintType）。
        RbRestraintTypeEO typeQuery = new RbRestraintTypeEO();
        typeQuery.setRestraintType(restraints.getRestraintType());
        typeQuery.setStatus(Status.A);
        List<RbRestraintTypeEO> typeList = rbRestraintTypeBcc.findByEo(typeQuery);

                                                                                                                                                                                                              
                                                           
        if (typeList == null || typeList.isEmpty()) {
            // TBD-1 未确认：限制类型表无状态「A-生效」记录时的行为，暂按查询为空正常提前结束返回
            // （已取得的限制记录字段保留，其余业务字段不设置），不作为业务失败；该路径结果待业务确认后实现。
            output.setSucceed(true);
            return output;
        }
        RbRestraintTypeEO typeRecord = typeList.get(0);
        output.setDrCrCtlFlag(typeRecord.getDrCrCtlFlag());
        output.setStatus(typeRecord.getStatus());
        output.setTransferFlag(typeRecord.getTransferFlag());

        // 子步骤 REQ-003 判定转账止付标志：借贷方控制标志等于「D-禁止借方」（DrCrCtlFlag.D）
        // 且转账标志等于「N-不允许转账」时返回「是」，否则返回「否」。
                                                                                                                                                                                                                                                                                    
                                                           
        if (typeRecord.getDrCrCtlFlag() == DrCrCtlFlag.D && "N".equals(typeRecord.getTransferFlag())) {
            output.setStopFlag("是");
        } else {
            output.setStopFlag("否");
        }

        output.setSucceed(true);
        return output;
    }
}
