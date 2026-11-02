package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST054InputBO;
import com.dcits.deposit.facade.bo.ST054OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST054 检查是否存在现金止收限制 步骤实现。
 *
 * <p>交易执行步骤。依据必填输入账号（baseAcctNo）按「账号 + 限制状态 A-生效」查询
 * 【对公存款账户限制表】（RB_BUS_RESTRAINTS）取得账户限制信息，再依据取得的账户限制类型按
 * 「账户限制类型 + 状态 A-生效」查询【存款限制类型表】（RB_RESTRAINT_TYPE），按 REQ-003
 * 规则判定现金止收限制并按「输出」表返回两次查询取得的字段。</p>
 *
 * <p>已确认行为（正式 Spec REQ-001~REQ-004，步骤描述第 1–3 条）：</p>
 * <ul>
 *   <li>步骤 1：以 baseAcctNo 与 {@code RestraintsStatus.A} 为等值条件经
 *       {@link IRbBusRestraintsBcc#findByEo} 查询账户限制信息；账号无生效限制（REQ-001-S02）
 *       时现金止收标志落入"否则"分支返回"否"，本步骤正常提前结束；</li>
 *   <li>步骤 2：以步骤 1 取得的账户限制类型与 {@code Status.A} 为等值条件经
 *       {@link IRbRestraintTypeBcc#findByEo} 查询限制类型定义，按「输出」表取得状态、借贷方
 *       控制标志、现金标志、止付标志；</li>
 *   <li>步骤 3（REQ-003）：借贷方控制标志="C-禁止贷方"（{@code DrCrCtlFlag.C}）且现金标志
 *       ="N-不允许现金"时返回现金止收标志="是"，否则返回"否"；</li>
 *   <li>正常完成时 succeed=true，errorCode、errorMessage 为 null；需求未声明本步骤的
 *       业务失败与错误码，本实现不补写失败处理或错误码。</li>
 * </ul>
 *
 * <p>必填输入为空（TBD-6）、步骤 2 查询无记录（TBD-5）、现金止收标志输出字段去向（TBD-2）及
 * 输出表同名字段区分（TBD-7）待业务确认，相关实现位置已标记业务 FIXME，见
 * {@link #execute(ST054InputBO)}。命中多条记录（TBD-1）按本项目约定取结果集第一条；查询条件
 * "A-生效" 按 Spec 已绑定枚举常量 {@code RestraintsStatus.A}、{@code Status.A}（TBD-3）；
 * 现金标志除"N-不允许现金"外取值未定义（TBD-4），现金止收判定仅以"N"为命中值。</p>
 */
@Service
public class ST054Pbc implements IST054 {

    /** 现金标志：不允许现金 */
    private static final String CASH_FLAG_FORBIDDEN = "N";

    private final IRbBusRestraintsBcc rbBusRestraintsBcc;
    private final IRbRestraintTypeBcc rbRestraintTypeBcc;

    public ST054Pbc(IRbBusRestraintsBcc rbBusRestraintsBcc, IRbRestraintTypeBcc rbRestraintTypeBcc) {
        this.rbBusRestraintsBcc = rbBusRestraintsBcc;
        this.rbRestraintTypeBcc = rbRestraintTypeBcc;
    }

    @Override
    public ST054OutputBO execute(ST054InputBO input) {
        ST054OutputBO output = new ST054OutputBO();
        String baseAcctNo = input.getBaseAcctNo();
                                                                                                                                                                                                                                               

        // 步骤 1（REQ-001）：根据{账号}、限制状态等于"A-生效"（RestraintsStatus.A）查询【对公存款账户限制表】获取[账户限制信息]，必须包括账户限制类型、限制编号
                                                           
        RbBusRestraintsEO restraintQuery = new RbBusRestraintsEO();
        restraintQuery.setBaseAcctNo(baseAcctNo);
        restraintQuery.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintList = rbBusRestraintsBcc.findByEo(restraintQuery);
        if (restraintList.isEmpty()) {
            // REQ-001-S02：账号无生效限制，现金止收标志落入"否则"分支返回"否"，本步骤正常提前结束；
            // "否"的承载输出字段未登记于「输出」表，去向见步骤 3 的 TBD-2 FIXME
            output.setSucceed(true);
            return output;
        }
        // 多条统一取结果集第一条（本项目约定；多条生效限制的聚合判定与输出记录选取见 Spec 待确认事项 TBD-1）
        RbBusRestraintsEO restraint = restraintList.get(0);
        output.setResSeqNo(restraint.getResSeqNo());
                                                                                                                                                                                                                                                                                       
                                                           
        output.setRestraintType(restraint.getRestraintType());
        output.setRestraintsStatus(restraint.getRestraintsStatus());

        // 步骤 2（REQ-002）：根据[账户限制信息]中的账户限制类型查询【限制类型表】获取状态等于"A-生效"（Status.A）的限制类型记录，按「输出」表取得状态、借贷方控制标志、现金标志、止付标志
        RbRestraintTypeEO typeQuery = new RbRestraintTypeEO();
        typeQuery.setRestraintType(restraint.getRestraintType());
        typeQuery.setStatus(Status.A);
        List<RbRestraintTypeEO> typeList = rbRestraintTypeBcc.findByEo(typeQuery);
        if (typeList.isEmpty()) {
                                                                                                                                                                                                                                              
                                                           
        } else {
            // 多条统一取结果集第一条（本项目约定；TBD-1 选取规则待确认）
            RbRestraintTypeEO type = typeList.get(0);
            output.setStatus(type.getStatus());
            output.setDrCrCtlFlag(type.getDrCrCtlFlag());
            output.setCashFlag(type.getCashFlag());
            output.setStopFlag(type.getStopFlag());

            // 步骤 3（REQ-003）：借贷方控制标志="C-禁止贷方"（DrCrCtlFlag.C）且现金标志="N-不允许现金"时返回现金止收标志="是"，否则（含借贷方控制标志≠C、现金标志≠N 及无生效限制记录等情形）返回"否"
                                                                                                                                                                                                                                                                      
                                                               
            if (DrCrCtlFlag.C.equals(type.getDrCrCtlFlag()) && CASH_FLAG_FORBIDDEN.equals(type.getCashFlag())) {
                // REQ-003-S01：命中现金止收限制，现金止收标志="是"（承载输出字段待 TBD-2 确认后落位）
            } else {
                // REQ-003-S02/S03 等未命中情形：现金止收标志="否"（承载输出字段待 TBD-2 确认后落位）
            }
        }
        output.setSucceed(true);
        return output;
    }
}
