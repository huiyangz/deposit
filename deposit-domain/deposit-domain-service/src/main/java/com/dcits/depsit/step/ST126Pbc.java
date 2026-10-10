package com.dcits.depsit.step;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST126InputBO;
import com.dcits.depsit.facade.bo.ST126OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * ST126 检查是否存在现金止付限制（检查类步骤）。
 *
 * <p>步骤由三个动作构成：</p>
 * <ol>
 *   <li>获取账户限制信息：以账号 {@code baseAcctNo} 与限制状态码值 {@code "A"}（源需求「A-生效」）
 *       查询【账户限制信息】（对公存款账户限制表 RB_BUS_RESTRAINTS），取回全部命中记录；
 *       未查询到生效的限制信息时直接返回 {@code cashStopPayFlag = "否"}，
 *       不再查询【限制类型表】、不再执行后续判定；</li>
 *   <li>获取账户限制类型信息：对每一条限制信息，按其账户限制类型查询【限制类型表】
 *       （存款限制类型表 RB_RESTRAINT_TYPE，按主键取单条），取其借贷方控制标志与现金标志；
 *       未命中状态为 {@code "A"} 的配置时，该条不构成现金止付限制，继续判断其余限制信息；</li>
 *   <li>检查是否存在现金止付限制：当且仅当借贷方控制标志等于 {@code "D-禁止借方"}（码值 D）
 *       且现金标志等于 {@code "N-不允许现金"}（码值 N）时该条满足现金止付条件；</li>
 * </ol>
 *
 * <p>任一条满足时返回 {@code cashStopPayFlag = "是"} 并立即结束判断；全部不满足时返回
 * {@code cashStopPayFlag = "否"}。本步骤无业务失败场景（源需求「## 失败处理」），
 * 各分支均以 {@code succeed=true} 返回，不产出错误码。</p>
 *
 * <p>本步骤只读，不写库、不产生数据变更，也不调用其它步骤或外部服务。</p>
 */
@Service
public class ST126Pbc implements IST126 {

    /** 现金止付标志取值：是-存在现金止付限制 */
    private static final String CASH_STOP_PAY_FLAG_YES = "是";

    /** 现金止付标志取值：否-不存在现金止付限制 */
    private static final String CASH_STOP_PAY_FLAG_NO = "否";

    /** 现金标志的命中码值：N-不允许现金 */
    private static final String CASH_FLAG_NOT_ALLOWED = "N";

    private final IRbBusRestraintsBcc rbBusRestraintsBcc;

    private final IRbRestraintTypeBcc rbRestraintTypeBcc;

    public ST126Pbc(IRbBusRestraintsBcc rbBusRestraintsBcc, IRbRestraintTypeBcc rbRestraintTypeBcc) {
        this.rbBusRestraintsBcc = rbBusRestraintsBcc;
        this.rbRestraintTypeBcc = rbRestraintTypeBcc;
    }

    @Override
    public ST126OutputBO execute(ST126InputBO input) {
        ST126OutputBO output = new ST126OutputBO();

        // 步骤1 获取账户限制信息：按账号 + 限制状态"A-生效"查询【账户限制信息】
        // 查询条件只承载账号与限制状态两个字段，不附加其它限定条件；查询为只读
        RbBusRestraintsEO condition = new RbBusRestraintsEO();
        condition.setBaseAcctNo(input.getBaseAcctNo());
        condition.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(condition);

        // 步骤1 未查询到生效的限制信息：直接返回 cashStopPayFlag = "否"，
        // 不再查询【限制类型表】、不再执行步骤2 与步骤3 的判定
        if (restraintsList == null || restraintsList.isEmpty()) {
            output.setCashStopPayFlag(CASH_STOP_PAY_FLAG_NO);
            output.setSucceed(true);
            return output;
        }

        // 步骤2 + 步骤3：按步骤1 取回的顺序逐条判断
        for (RbBusRestraintsEO restraint : restraintsList) {
            // 步骤2 获取账户限制类型信息：按当前记录的账户限制类型取【限制类型表】配置
            RbRestraintTypeEO restraintTypeInfo =
                    rbRestraintTypeBcc.findByRestraintType(restraint.getRestraintType());

            // 步骤2 未命中状态为"A-生效"的配置：该条不构成现金止付限制，继续判断其余限制信息
            if (restraintTypeInfo == null || !Status.A.equals(restraintTypeInfo.getStatus())) {
                continue;
            }

            // 步骤3 检查是否存在现金止付限制：借贷方控制标志 = "D-禁止借方" 且 现金标志 = "N-不允许现金"
            if (DrCrCtlFlag.D.equals(restraintTypeInfo.getDrCrCtlFlag())
                    && CASH_FLAG_NOT_ALLOWED.equals(restraintTypeInfo.getCashFlag())) {
                // 任一条命中即返回 "是" 并立即结束判断，不再对其余限制信息继续判断
                output.setCashStopPayFlag(CASH_STOP_PAY_FLAG_YES);
                output.setSucceed(true);
                return output;
            }
            // 两个条件中任一不成立：该条不满足现金止付条件，继续判断其余限制信息
        }

        // 全部限制信息均不满足（含全部账户限制类型均无 A-生效 配置）：返回 "否"
        output.setCashStopPayFlag(CASH_STOP_PAY_FLAG_NO);
        output.setSucceed(true);
        return output;
    }
}
