package com.dcits.depsit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.depsit.enums.DrCrCtlFlag;
import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST122InputBO;
import com.dcits.depsit.facade.bo.ST122OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;

/**
 * ST122 检查是否存在不收不付限制 的步骤实现。
 *
 * <p>给定账号，查询该账号下状态为 "A-生效" 的【账户限制信息】（RB_BUS_RESTRAINTS），对每条记录
 * 依据 {账户限制类型} 查询【限制类型表】（RB_RESTRAINT_TYPE）中状态为 "A-生效" 的配置，按
 * {借贷方控制标志} 是否等于 "A-禁止借贷方"（码值 A）判定该条是否构成不收不付限制，并按
 * "任一满足即为是" 的口径在多条记录间聚合。</p>
 *
 * <p>本步骤无业务失败场景、无业务错误码；失败仅由技术异常传播表达，未查询到生效限制与
 * "全部不满足" 均为正常结果（noRecvNoPayFlag＝"否"）。</p>
 */
@Service
public class ST122Pbc implements IST122 {

    /** 不收不付标志取值：是。 */
    private static final String FLAG_YES = "是";

    /** 不收不付标志取值：否。 */
    private static final String FLAG_NO = "否";

    /** 实体表【对公存款账户限制表(RB_BUS_RESTRAINTS)】数据服务接口。 */
    @Autowired
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    /** 实体表【存款限制类型表(RB_RESTRAINT_TYPE)】数据服务接口。 */
    @Autowired
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @Override
    public ST122OutputBO execute(ST122InputBO input) {
        ST122OutputBO output = new ST122OutputBO();

        // REQ-001：以 {账号} 与限制状态码值 A（"A-生效"）为条件查询【账户限制信息】
        RbBusRestraintsEO queryEo = new RbBusRestraintsEO();
        queryEo.setBaseAcctNo(input.getBaseAcctNo());
        queryEo.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintsList = rbBusRestraintsBcc.findByEo(queryEo);

        // REQ-001：查询结果为 0 条时直接返回 "否"，resSeqNo、restraintType、restraintsStatus 输出空值，
        // 不进入 REQ-002 的逐条判断，也不发起【限制类型表】查询
        if (restraintsList == null || restraintsList.isEmpty()) {
            output.setNoRecvNoPayFlag(FLAG_NO);
            output.setSucceed(true);
            return output;
        }

        // REQ-002：逐条判断，任一满足即为 "是" 并回显该条记录；不因存在不满足的记录而提前返回
        for (RbBusRestraintsEO restraint : restraintsList) {
            // REQ-003：按当前记录的 {账户限制类型} 查询【限制类型表】，取状态码值为 A 的配置的 {借贷方控制标志}；
            // 查询无记录或记录状态不为 A 时，视为该限制类型不构成不收不付限制，输出空值并继续判断其余记录
            RbRestraintTypeEO configEo = rbRestraintTypeBcc.findByRestraintType(restraint.getRestraintType());
            if (configEo == null || configEo.getStatus() != Status.A) {
                continue;
            }
            // REQ-004：仅当 {借贷方控制标志} 等于码值 A（"A-禁止借贷方"）时该条满足不收不付条件
            if (configEo.getDrCrCtlFlag() == DrCrCtlFlag.A) {
                output.setNoRecvNoPayFlag(FLAG_YES);
                output.setResSeqNo(restraint.getResSeqNo());
                output.setRestraintType(restraint.getRestraintType());
                output.setRestraintsStatus(restraint.getRestraintsStatus());
                output.setDrCrCtlFlag(configEo.getDrCrCtlFlag());
                output.setStatus(configEo.getStatus());
                output.setSucceed(true);
                return output;
            }
        }

        // REQ-002：全部记录均不满足时返回 "否"，resSeqNo、restraintType、restraintsStatus 输出空值
        output.setNoRecvNoPayFlag(FLAG_NO);
        output.setSucceed(true);
        return output;
    }
}
