package com.dcits.deposit.step;

import java.util.List;

import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST058InputBO;
import com.dcits.deposit.facade.bo.ST058OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST058 检查是否存在不收不付限制 步骤实现。
 *
 * <p>按正式 Spec 步骤描述 1–3 执行：以账号与限制状态 {@code A} 查询对公存款账户限制表取得
 * 限制类型与限制编号，再按限制类型与状态 {@code A} 查询存款限制类型表取得借贷方控制标志，
 * 借贷方控制标志为「A-禁止借贷方」时输出不收不付标志「是」，否则输出「否」。</p>
 *
 * <p>本步骤未声明业务失败场景，不定义错误码；查询无记录等未定义行为见执行中 FIXME。</p>
 */
@Service
public class ST058Pbc implements IST058 {

    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Autowired
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @Override
    public ST058OutputBO execute(ST058InputBO input) {
        ST058OutputBO output = new ST058OutputBO();

        // REQ-001 按账号与限制状态查询并取得生效的账户限制信息
                                                                                                                                                                                             
                                                           
        RbBusRestraintsEO restraintQuery = new RbBusRestraintsEO();
        restraintQuery.setBaseAcctNo(input.getBaseAcctNo());
        restraintQuery.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintRecords = rbBusRestraintsBcc.findByEo(restraintQuery);

                                                           
        if (restraintRecords.isEmpty()) {
                                                                                                                                                                           
            output.setSucceed(true);
            return output;
        }

        // 多记录按项目约定取结果集第一条，先判空再取值
                                                                                                                                                                                                              
                                                           
        RbBusRestraintsEO restraintRecord = restraintRecords.get(0);
        output.setResSeqNo(restraintRecord.getResSeqNo());
        output.setRestraintType(restraintRecord.getRestraintType());
        output.setRestraintsStatus(restraintRecord.getRestraintsStatus());

        // REQ-002 按限制类型与状态查询并取得借贷方控制标志
        RbRestraintTypeEO typeQuery = new RbRestraintTypeEO();
        typeQuery.setRestraintType(restraintRecord.getRestraintType());
        typeQuery.setStatus(Status.A);
        List<RbRestraintTypeEO> typeRecords = rbRestraintTypeBcc.findByEo(typeQuery);

                                                           
        if (typeRecords.isEmpty()) {
                                                                                                                                                                           
            output.setSucceed(true);
            return output;
        }

        RbRestraintTypeEO typeRecord = typeRecords.get(0);
        output.setDrCrCtlFlag(typeRecord.getDrCrCtlFlag());
        output.setStatus(typeRecord.getStatus());

        // REQ-003 依据借贷方控制标志判定并输出不收不付标志
                                                                                                                                                                        
                                                           
        if (DrCrCtlFlag.A == typeRecord.getDrCrCtlFlag()) {
            output.setNoCreditNoDebitFlag("是");
        } else {
            output.setNoCreditNoDebitFlag("否");
        }

        output.setSucceed(true);
        return output;
    }
}
