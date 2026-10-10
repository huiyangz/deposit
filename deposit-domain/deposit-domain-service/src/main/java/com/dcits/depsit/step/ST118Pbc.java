package com.dcits.depsit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST118InputBO;
import com.dcits.depsit.facade.bo.ST118OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;

/**
 * ST118 检查是否存在现金止收限制 步骤实现。
 *
 * <p>按正式 Spec 的三条子步骤执行：</p>
 * <ol>
 *   <li>子步骤 1（实体查询类）：以 {@code baseAcctNo} 为账号、限制状态码值 {@code "A"} 为条件，
 *       经 {@link IRbBusRestraintsBcc#findByEo} 取回该账号全部生效的限制信息（零条到多条）。
 *       零条时直接返回 {@code cashStopCreditFlag = "否"}，三个回显字段保持空值，
 *       不查询【限制类型表】、不执行后续判断。</li>
 *   <li>子步骤 2（实体查询类）：对每条限制信息，按其账户限制类型取【限制类型表】中状态为
 *       码值 {@code "A"} 的配置（{@link IRbRestraintTypeBcc#findByRestraintType}，主键为账户限制类型）；
 *       无 A-生效 配置（无记录或状态非 {@code "A"}）时视为该账户限制类型不构成现金止收限制、
 *       该条不满足现金止收条件，该条的 {@code status}/{@code drCrCtlFlag}/{@code cashFlag} 无取值，
 *       并继续判断其余限制信息，不因此提前返回「否」。</li>
 *   <li>子步骤 3（逻辑判断类）：当且仅当配置的借贷方控制标志等于 {@code C-禁止贷方} 且
 *       现金标志等于 {@code "N"}（N-不允许现金）时，该条限制满足现金止收条件；两条件为合取，
 *       任一不成立即不满足并继续判断其余限制信息。</li>
 * </ol>
 *
 * <p>汇总：任一条满足即返回 {@code cashStopCreditFlag = "是"} 并回显该条的 {@code resSeqNo}、
 * {@code restraintType}、{@code restraintsStatus} 与对应配置的 {@code status}、{@code drCrCtlFlag}、
 * {@code cashFlag}，随即结束判断；全部不满足时返回「否」且三个回显字段为空值。
 * 本步骤无业务失败场景（Spec REQ-006），仅只读访问数据，技术异常向上层传播。</p>
 */
@Service
public class ST118Pbc implements IST118 {

    /** 现金止收判定条件：借贷方控制标志等于 C-禁止贷方。 */
    private static final DrCrCtlFlag DR_CR_CTL_FLAG_C = DrCrCtlFlag.C;

    /** 现金止收判定条件：现金标志等于 "N"（N-不允许现金）。 */
    private static final String CASH_FLAG_N = "N";

    /** 步骤 1 查询【账户限制信息】的限制状态条件：码值 "A"（源需求书写「A-生效」）。 */
    private static final RestraintsStatus RESTRAINTS_STATUS_A = RestraintsStatus.A;

    /** 步骤 2 筛选【限制类型表】配置的状态条件：码值 "A"（源需求书写「A-生效」）。 */
    private static final Status STATUS_A = Status.A;

    /** 结论字面值：存在现金止收限制。 */
    private static final String CASH_STOP_CREDIT_FLAG_YES = "是";

    /** 结论字面值：不存在现金止收限制。 */
    private static final String CASH_STOP_CREDIT_FLAG_NO = "否";

    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Autowired
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @Override
    public ST118OutputBO execute(ST118InputBO input) {
        ST118OutputBO output = new ST118OutputBO();

        // 子步骤 1：获取账户限制信息——按账号 + 限制状态 A-生效 查询，取回零到多条记录
        RbBusRestraintsEO query = new RbBusRestraintsEO();
        query.setBaseAcctNo(input.getBaseAcctNo());
        query.setRestraintsStatus(RESTRAINTS_STATUS_A);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(query);

        if (restraintsList == null || restraintsList.isEmpty()) {
            // 未查询到生效的限制信息：直接返回「否」，三个回显字段为空值，不进入子步骤 2、3
            output.setCashStopCreditFlag(CASH_STOP_CREDIT_FLAG_NO);
            output.setSucceed(true);
            return output;
        }

        // 逐条判断：任一条满足即返回「是」并回显该条，随即结束判断
        for (RbBusRestraintsEO restraints : restraintsList) {
            // 子步骤 2：获取账户限制类型信息——按账户限制类型取状态为 A-生效 的配置
            RbRestraintTypeEO restraintTypeConfig =
                    rbRestraintTypeBcc.findByRestraintType(restraints.getRestraintType());
            if (restraintTypeConfig == null || STATUS_A != restraintTypeConfig.getStatus()) {
                // 无 A-生效 配置：该条不构成现金止收限制、不满足现金止收条件，继续判断其余限制信息
                continue;
            }

            // 子步骤 3：检查是否存在现金止收限制——借贷方控制标志 C-禁止贷方 且 现金标志 N-不允许现金
            if (DR_CR_CTL_FLAG_C != restraintTypeConfig.getDrCrCtlFlag()
                    || !CASH_FLAG_N.equals(restraintTypeConfig.getCashFlag())) {
                // 合取条件不成立：该条不满足现金止收条件，继续判断其余限制信息
                continue;
            }

            // 该条限制满足现金止收条件：返回「是」并回显该条记录及其 A-生效 配置值
            output.setResSeqNo(restraints.getResSeqNo());
            output.setRestraintType(restraints.getRestraintType());
            output.setRestraintsStatus(restraints.getRestraintsStatus());
            output.setStatus(restraintTypeConfig.getStatus());
            output.setDrCrCtlFlag(restraintTypeConfig.getDrCrCtlFlag());
            output.setCashFlag(restraintTypeConfig.getCashFlag());
            output.setCashStopCreditFlag(CASH_STOP_CREDIT_FLAG_YES);
            output.setSucceed(true);
            return output;
        }

        // 全部限制信息均不满足现金止收条件：返回「否」，三个回显字段为空值
        output.setCashStopCreditFlag(CASH_STOP_CREDIT_FLAG_NO);
        output.setSucceed(true);
        return output;
    }
}
