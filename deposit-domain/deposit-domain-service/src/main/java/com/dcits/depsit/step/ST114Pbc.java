package com.dcits.depsit.step;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST114InputBO;
import com.dcits.depsit.facade.bo.ST114OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST114 检查转账止收限制。
 *
 * <p>以账号为入口，查询该账号下「A-生效」状态的账户限制记录；无生效记录时返回转账止收标志「否」
 * 并结束本步骤。存在生效记录时逐条按记录自身的账户限制类型查询【限制类型表】的「A-生效」配置，
 * 取借贷方控制标志与转账标志判定：借贷方控制标志为「C-禁止贷方」且转账标志为「N-不允许转账」
 * 时该条构成转账止收限制；任一条构成即返回「是」，全部不构成返回「否」。</p>
 *
 * <p>限制类型在【限制类型表】无「A-生效」配置（无记录或状态非「A」）时，视同该类型不构成转账止收
 * 限制：借贷方控制标志、转账标志按空值处理，该条判定为「否」，且不中止本步骤，继续处理其余记录。</p>
 *
 * <p>本步骤为只读查询，不写入、不更新、不产生数据变更，无组件内步骤调用与外部服务调用；
 * 无业务失败场景，失败仅由技术异常传播表达，故不使用错误码、不主动抛出业务异常。</p>
 */
@Service
public class ST114Pbc implements IST114 {

    private static final Logger LOGGER = LoggerFactory.getLogger(ST114Pbc.class);

    /** 转账止收标志：存在转账止收限制 */
    private static final String STOP_CREDIT_YES = "是";

    /** 转账止收标志：不存在转账止收限制 */
    private static final String STOP_CREDIT_NO = "否";

    /** 转账标志：不允许转账（该字段无枚举类，按码值字面量判定） */
    private static final String TRANSFER_FLAG_NOT_ALLOWED = "N";

    /** 【账户限制信息】数据服务 */
    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    /** 【限制类型表】数据服务 */
    @Autowired
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @Override
    public ST114OutputBO execute(ST114InputBO input) {
        ST114OutputBO output = new ST114OutputBO();

        // 步骤 1：按账号 + 限制状态「A-生效」查询【账户限制信息】
        RbBusRestraintsEO queryEo = new RbBusRestraintsEO();
        queryEo.setBaseAcctNo(input.getBaseAcctNo());
        queryEo.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(queryEo);

        // 未查到「A-生效」的账户限制记录时返回转账止收标志「否」并结束本步骤
        if (restraintsList == null || restraintsList.isEmpty()) {
            LOGGER.debug("ST114 账号 {} 未查到 A-生效 的账户限制记录，转账止收标志返回否", input.getBaseAcctNo());
            output.setStopCreditFlag(STOP_CREDIT_NO);
            output.setSucceed(true);
            return output;
        }

        // 存在生效记录时，逐条执行子步骤 2、3，任一条构成即返回「是」
        boolean stopCredit = false;
        for (RbBusRestraintsEO restraint : restraintsList) {
            output.setResSeqNo(restraint.getResSeqNo());
            output.setRestraintType(restraint.getRestraintType());
            output.setRestraintsStatus(restraint.getRestraintsStatus());

            // 子步骤 2：按该条记录的账户限制类型查询【限制类型表】，取「A-生效」配置的两标志
            RbRestraintTypeEO typeConfig = rbRestraintTypeBcc.findByRestraintType(restraint.getRestraintType());
            if (typeConfig == null || !Status.A.equals(typeConfig.getStatus())) {
                // 该限制类型无「A-生效」配置：两标志按空值处理，视同不构成，不中止本步骤
                LOGGER.debug("ST114 账户限制类型 {} 无 A-生效 配置，视同不构成转账止收限制",
                        restraint.getRestraintType());
                continue;
            }
            output.setDrCrCtlFlag(typeConfig.getDrCrCtlFlag());
            output.setStatus(typeConfig.getStatus());
            output.setTransferFlag(typeConfig.getTransferFlag());

            // 子步骤 3：借贷方控制标志「C-禁止贷方」且转账标志「N-不允许转账」时该条构成
            if (DrCrCtlFlag.C.equals(typeConfig.getDrCrCtlFlag())
                    && TRANSFER_FLAG_NOT_ALLOWED.equals(typeConfig.getTransferFlag())) {
                stopCredit = true;
            }
        }

        output.setStopCreditFlag(stopCredit ? STOP_CREDIT_YES : STOP_CREDIT_NO);
        output.setSucceed(true);
        return output;
    }
}
