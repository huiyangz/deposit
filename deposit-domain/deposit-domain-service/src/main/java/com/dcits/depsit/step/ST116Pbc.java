package com.dcits.depsit.step;

import java.util.List;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST116InputBO;
import com.dcits.depsit.facade.bo.ST116OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST116 检查是否存在转账止付限制 步骤实现。
 *
 * <p>以入参账号（{@code baseAcctNo}）为条件，限制状态取码值 {@code "A"}，查询【账户限制信息】；
 * 未查询到记录视为不存在转账止付限制，直接返回「否」并结束。对取回的每条限制信息，
 * 按其账户限制类型查询【限制类型表】并筛选状态码值 {@code "A"} 的配置，当且仅当该配置的
 * 借贷方控制标志等于 {@code "D"} 且转账标志等于 {@code "N"} 时判定该条满足转账止付条件，
 * 返回「是」并回显该条的限制编号、账户限制类型、限制状态，立即结束判断；全部不满足时返回「否」。</p>
 *
 * <p>本步骤无业务失败场景，不产生业务错误码；依赖的数据访问异常按技术异常向上传播。</p>
 */
@Service
public class ST116Pbc implements IST116 {

    /** 检查结论：是（存在转账止付限制） */
    private static final String FLAG_YES = "是";

    /** 检查结论：否（不存在转账止付限制） */
    private static final String FLAG_NO = "否";

    /** 转账标志：不允许转账 */
    private static final String TRANSFER_FLAG_NOT_ALLOWED = "N";

    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @Autowired
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @Override
    public ST116OutputBO execute(ST116InputBO input) {
        ST116OutputBO output = new ST116OutputBO();

        // 步骤 1 获取账户限制信息：账号 = baseAcctNo 且 限制状态 = "A"，取回全部命中的记录
        RbBusRestraintsEO restraintsQuery = new RbBusRestraintsEO();
        restraintsQuery.setBaseAcctNo(input.getBaseAcctNo());
        restraintsQuery.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(restraintsQuery);

        // 未查询到记录：视为不存在转账止付限制，返回「否」并结束，其余输出字段为空值
        if (restraintsList == null || restraintsList.isEmpty()) {
            output.setTransferStopPayFlag(FLAG_NO);
            output.setSucceed(true);
            return output;
        }

        // 按取回顺序逐条执行步骤 2 与步骤 3
        for (RbBusRestraintsEO restraints : restraintsList) {
            // 步骤 2 获取账户限制类型配置：按账户限制类型取配置，并筛选状态 = "A"
            RbRestraintTypeEO config = rbRestraintTypeBcc.findByRestraintType(restraints.getRestraintType());
            if (config == null || !Status.A.equals(config.getStatus())) {
                // 未取到 A-生效 配置：该条不构成转账止付限制，继续判断其余限制
                continue;
            }

            // 步骤 3 检查是否存在转账止付限制：借贷方控制标志 = "D" 且 转账标志 = "N"
            if (DrCrCtlFlag.D.equals(config.getDrCrCtlFlag())
                    && TRANSFER_FLAG_NOT_ALLOWED.equals(config.getTransferFlag())) {
                // 命中：返回「是」，回显该条限制信息与所取配置，并立即结束判断
                output.setTransferStopPayFlag(FLAG_YES);
                output.setResSeqNo(restraints.getResSeqNo());
                output.setRestraintType(restraints.getRestraintType());
                output.setRestraintsStatus(restraints.getRestraintsStatus());
                output.setDrCrCtlFlag(config.getDrCrCtlFlag());
                output.setStatus(config.getStatus());
                output.setTransferFlag(config.getTransferFlag());
                output.setSucceed(true);
                return output;
            }
        }

        // 全部限制信息均不满足：返回「否」
        output.setTransferStopPayFlag(FLAG_NO);
        output.setSucceed(true);
        return output;
    }
}
