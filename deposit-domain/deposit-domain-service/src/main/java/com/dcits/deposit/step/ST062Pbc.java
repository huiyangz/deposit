package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST062InputBO;
import com.dcits.deposit.facade.bo.ST062OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST062 检查是否存在现金止付限制 步骤实现。
 *
 * <p>以输入账号（baseAcctNo）与限制状态「A-生效」（RestraintsStatus.A）查询对公存款账户限制表
 * （RB_BUS_RESTRAINTS，REQ-001）获取账户限制信息集合；逐条遍历（REQ-002），按（账户限制类型、
 * 状态「A-生效」Status.A）查询存款限制类型表（RB_RESTRAINT_TYPE）取得借贷方控制标志与现金标志，
 * 命中「借贷方控制标志为 D-禁止借方（DrCrCtlFlag.D）且现金标志为 N-不允许现金（字面量"N"）」时
 * 返回现金止付标志「是」并结束遍历（REQ-003）；集合为空或遍历结束无命中返回「否」（REQ-004）。
 * 本步骤只读查询，无已声明业务失败路径，正常完成与正常提前结束均按成功结果返回。</p>
 */
@Service
public class ST062Pbc implements IST062 {

    /** 对公存款账户限制表（RB_BUS_RESTRAINTS）数据访问接口 */
    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    /** 存款限制类型表（RB_RESTRAINT_TYPE）数据访问接口 */
    @Autowired
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    /** 命中判定条件：现金标志为「N-不允许现金」（Spec 字面量） */
    private static final String CASH_FLAG_NO = "N";

    /** 现金止付标志业务取值：是 */
    private static final String CASH_STOP_FLAG_YES = "是";

    /** 现金止付标志业务取值：否 */
    private static final String CASH_STOP_FLAG_NO = "否";

    @Override
    public ST062OutputBO execute(ST062InputBO input) {
        ST062OutputBO output = new ST062OutputBO();

        // REQ-001：按（账号、限制状态「A-生效」RestraintsStatus.A）查询对公存款账户限制表，获取账户限制信息集合
        RbBusRestraintsEO busRestraintsQuery = new RbBusRestraintsEO();
                                                           
        busRestraintsQuery.setBaseAcctNo(input.getBaseAcctNo());
        busRestraintsQuery.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> accountRestraints = rbBusRestraintsBcc.findByEo(busRestraintsQuery);

        // REQ-004-S02：账户限制信息集合为空时不执行限制类型配置查询，返回现金止付标志「否」
        if (accountRestraints.isEmpty()) {
            output.setCashStopFlag(CASH_STOP_FLAG_NO);
            output.setSucceed(true);
            return output;
        }

        // REQ-002：遍历账户限制信息集合，按（账户限制类型、状态「A-生效」Status.A）查询限制类型配置
        for (RbBusRestraintsEO accountRestraint : accountRestraints) {
            // 中间输出字段（restraintType/resSeqNo/restraintsStatus）取自当前处理记录（多记录取数归属未定义）
                                                               
            output.setRestraintType(accountRestraint.getRestraintType());
            output.setResSeqNo(accountRestraint.getResSeqNo());
            output.setRestraintsStatus(accountRestraint.getRestraintsStatus());

            RbRestraintTypeEO restraintTypeQuery = new RbRestraintTypeEO();
            restraintTypeQuery.setRestraintType(accountRestraint.getRestraintType());
            restraintTypeQuery.setStatus(Status.A);
            List<RbRestraintTypeEO> restraintTypeConfigs = rbRestraintTypeBcc.findByEo(restraintTypeQuery);

            // 面向单条结果的限制类型配置查询：多条统一取结果集第一条，先判空再取值；查无记录按未命中继续遍历
                                                               
            if (!restraintTypeConfigs.isEmpty()) {
                RbRestraintTypeEO restraintTypeConfig = restraintTypeConfigs.get(0);
                output.setDrCrCtlFlag(restraintTypeConfig.getDrCrCtlFlag());
                output.setCashFlag(restraintTypeConfig.getCashFlag());

                // REQ-003：借贷方控制标志为「D-禁止借方」（DrCrCtlFlag.D）且现金标志为「N-不允许现金」时返回「是」并结束遍历
                if (DrCrCtlFlag.D == restraintTypeConfig.getDrCrCtlFlag()
                        && CASH_FLAG_NO.equals(restraintTypeConfig.getCashFlag())) {
                    output.setCashStopFlag(CASH_STOP_FLAG_YES);
                    output.setSucceed(true);
                    return output;
                }
            }
            // REQ-004 否则分支：未命中继续遍历下一条记录
        }

        // REQ-004：遍历结束无命中返回现金止付标志「否」
        output.setCashStopFlag(CASH_STOP_FLAG_NO);
        output.setSucceed(true);
        return output;
    }
}
