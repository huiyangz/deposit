package com.dcits.depsit.step;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST120InputBO;
import com.dcits.depsit.facade.bo.ST120OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ST120 检查是否存在转账不收不付限制的实现。
 *
 * <p>子步骤 1：以账号 + 限制状态码值 "A" 查询【账户限制信息】（{@code RB_BUS_RESTRAINTS}），
 * 未查询到生效限制信息时直接返回「否」。</p>
 *
 * <p>子步骤 2：对每条限制信息，按其账户限制类型查询【限制类型表】（{@code RB_RESTRAINT_TYPE}），
 * 取状态码值为 "A" 的配置；未查询到（无记录或状态非 "A"）时该条不构成转账不收不付限制，继续判断其余限制信息。</p>
 *
 * <p>子步骤 3：借贷方控制标志等于 "A" 且转账标志等于 "N" 时该条满足条件，返回「是」并回显该条记录的
 * 限制编号、账户限制类型、限制状态及其配置的借贷方控制标志、状态、转账标志；全部不满足时返回「否」。</p>
 *
 * <p>本步骤只读、无业务失败场景：各路径均以 {@code succeed=true} 返回，依赖的数据访问异常按技术异常向上传播。</p>
 */
@Service
public class ST120Pbc implements IST120 {

    /** 结论：存在转账不收不付限制。 */
    private static final String FLAG_YES = "是";

    /** 结论：不存在转账不收不付限制。 */
    private static final String FLAG_NO = "否";

    /** 转账标志：禁止转账。 */
    private static final String TRANSFER_FLAG_FORBIDDEN = "N";

    private final IRbBusRestraintsBcc rbBusRestraintsBcc;

    private final IRbRestraintTypeBcc rbRestraintTypeBcc;

    public ST120Pbc(IRbBusRestraintsBcc rbBusRestraintsBcc, IRbRestraintTypeBcc rbRestraintTypeBcc) {
        this.rbBusRestraintsBcc = rbBusRestraintsBcc;
        this.rbRestraintTypeBcc = rbRestraintTypeBcc;
    }

    @Override
    public ST120OutputBO execute(ST120InputBO input) {
        ST120OutputBO output = new ST120OutputBO();

        // 子步骤 1 获取账户限制信息：账号 + 限制状态等于 "A-生效"
        RbBusRestraintsEO queryEo = new RbBusRestraintsEO();
        queryEo.setBaseAcctNo(input.getBaseAcctNo());
        queryEo.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(queryEo);

        // 未查询到生效的限制信息：直接返回「否」，不再执行子步骤 2、3
        if (restraintsList == null || restraintsList.isEmpty()) {
            output.setAcctTranNoRecvNoPayFlag(FLAG_NO);
            output.setSucceed(true);
            return output;
        }

        // 逐条判断取回的限制信息
        for (RbBusRestraintsEO restraints : restraintsList) {
            // 子步骤 2 获取账户限制类型信息：按当前记录的账户限制类型取状态为 "A-生效" 的配置
            RbRestraintTypeEO restraintTypeEo =
                    rbRestraintTypeBcc.findByRestraintType(restraints.getRestraintType());
            if (restraintTypeEo == null || Status.A != restraintTypeEo.getStatus()) {
                // 未查询到 A-生效 配置：该条不构成转账不收不付限制，继续判断其余限制信息
                continue;
            }

            // 子步骤 3 检查是否存在转账不收不付限制：借贷方控制标志 = "A-禁止借贷方" 且 转账标志 = "N-禁止转账"
            if (DrCrCtlFlag.A == restraintTypeEo.getDrCrCtlFlag()
                    && TRANSFER_FLAG_FORBIDDEN.equals(restraintTypeEo.getTransferFlag())) {
                output.setAcctTranNoRecvNoPayFlag(FLAG_YES);
                output.setResSeqNo(restraints.getResSeqNo());
                output.setRestraintType(restraints.getRestraintType());
                output.setRestraintsStatus(restraints.getRestraintsStatus());
                output.setDrCrCtlFlag(restraintTypeEo.getDrCrCtlFlag());
                output.setStatus(restraintTypeEo.getStatus());
                output.setTransferFlag(restraintTypeEo.getTransferFlag());
                output.setSucceed(true);
                return output;
            }
        }

        // 全部限制信息均不构成转账不收不付限制
        output.setAcctTranNoRecvNoPayFlag(FLAG_NO);
        output.setSucceed(true);
        return output;
    }
}
