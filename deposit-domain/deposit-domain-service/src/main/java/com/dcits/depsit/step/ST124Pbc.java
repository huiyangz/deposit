package com.dcits.depsit.step;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST124InputBO;
import com.dcits.depsit.facade.bo.ST124OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ST124 检查是否存在现金不收不付限制的实现。
 *
 * <p>子步骤 1：以账号 + 限制状态码值 "A" 查询【账户限制信息】（{@code RB_BUS_RESTRAINTS}），
 * 未查询到生效限制信息时直接返回「否」。</p>
 *
 * <p>子步骤 2：对每条限制信息，按其账户限制类型查询【限制类型表】（{@code RB_RESTRAINT_TYPE}），
 * 取状态码值为 "A" 的配置；未查询到（无记录或状态非 "A"）时该条不构成现金不收不付限制，继续判断其余限制信息。</p>
 *
 * <p>子步骤 3：借贷方控制标志等于 "A" 且现金标志等于 "N" 时该条满足条件，返回「是」并回显该条记录的
 * 限制编号、账户限制类型、限制状态及其配置的借贷方控制标志、状态、现金标志；全部不满足时返回「否」。</p>
 */
@Service
public class ST124Pbc implements IST124 {

    /** 结论：存在现金不收不付限制。 */
    private static final String FLAG_YES = "是";

    /** 结论：不存在现金不收不付限制。 */
    private static final String FLAG_NO = "否";

    /** 现金标志：禁止现金。 */
    private static final String CASH_FLAG_FORBIDDEN = "N";

    private final IRbBusRestraintsBcc rbBusRestraintsBcc;

    private final IRbRestraintTypeBcc rbRestraintTypeBcc;

    public ST124Pbc(IRbBusRestraintsBcc rbBusRestraintsBcc, IRbRestraintTypeBcc rbRestraintTypeBcc) {
        this.rbBusRestraintsBcc = rbBusRestraintsBcc;
        this.rbRestraintTypeBcc = rbRestraintTypeBcc;
    }

    @Override
    public ST124OutputBO execute(ST124InputBO input) {
        ST124OutputBO output = new ST124OutputBO();

        // 子步骤 1 获取账户限制信息：账号 + 限制状态等于 "A-生效"
        RbBusRestraintsEO queryEo = new RbBusRestraintsEO();
        queryEo.setBaseAcctNo(input.getBaseAcctNo());
        queryEo.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(queryEo);

        // 未查询到生效的限制信息：直接返回「否」，不再执行子步骤 2、3
        if (restraintsList == null || restraintsList.isEmpty()) {
            output.setCashNoRecvNoPayFlag(FLAG_NO);
            output.setSucceed(true);
            return output;
        }

        // 逐条判断取回的限制信息
        for (RbBusRestraintsEO restraints : restraintsList) {
            // 子步骤 2 获取账户限制类型信息：按当前记录的账户限制类型取状态为 "A-生效" 的配置
            RbRestraintTypeEO restraintTypeEo =
                    rbRestraintTypeBcc.findByRestraintType(restraints.getRestraintType());
            if (restraintTypeEo == null || Status.A != restraintTypeEo.getStatus()) {
                // 未查询到 A-生效 配置：该条不构成现金不收不付限制，继续判断其余限制信息
                continue;
            }

            // 子步骤 3 检查是否存在现金不收不付限制：借贷方控制标志 = "A-禁止借贷方" 且 现金标志 = "N-禁止现金"
            if (DrCrCtlFlag.A == restraintTypeEo.getDrCrCtlFlag()
                    && CASH_FLAG_FORBIDDEN.equals(restraintTypeEo.getCashFlag())) {
                output.setCashNoRecvNoPayFlag(FLAG_YES);
                output.setResSeqNo(restraints.getResSeqNo());
                output.setRestraintType(restraints.getRestraintType());
                output.setRestraintsStatus(restraints.getRestraintsStatus());
                output.setDrCrCtlFlag(restraintTypeEo.getDrCrCtlFlag());
                output.setStatus(restraintTypeEo.getStatus());
                output.setCashFlag(restraintTypeEo.getCashFlag());
                output.setSucceed(true);
                return output;
            }
        }

        // 全部限制信息均不满足现金不收不付条件
        output.setCashNoRecvNoPayFlag(FLAG_NO);
        output.setSucceed(true);
        return output;
    }
}
