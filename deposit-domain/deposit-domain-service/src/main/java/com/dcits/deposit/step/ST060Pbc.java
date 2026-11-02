package com.dcits.deposit.step;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.DrCrCtlFlag;
import com.dcits.deposit.enums.RestraintsStatus;
import com.dcits.deposit.enums.Status;
import com.dcits.deposit.facade.bo.ST060InputBO;
import com.dcits.deposit.facade.bo.ST060OutputBO;
import com.dcits.deposit.facade.components.IRbBusRestraintsBcc;
import com.dcits.deposit.facade.components.IRbRestraintTypeBcc;
import com.dcits.deposit.facade.eo.RbBusRestraintsEO;
import com.dcits.deposit.facade.eo.RbRestraintTypeEO;

/**
 * ST060 检查是否存在现金不收不付限制。
 *
 * <p>依据必填输入账号（baseAcctNo）查询账户的「生效」限制信息（REQ-001），
 * 再依据取得的账户限制类型查询「生效」的限制类型定义（REQ-002），
 * 最后按限制类型的借贷方控制标志与现金标志判定是否存在现金不收不付限制（REQ-003），
 * 正常完成时返回现金不收不付限制标志「是」/「否」并携带查询取得的限制信息字段（REQ-004）。</p>
 */
@Service
public class ST060Pbc implements IST060 {

    /** 现金标志：禁止现金 */
    private static final String CASH_FLAG_FORBIDDEN = "N";

    /** 现金不收不付限制标志：是 */
    private static final String FLAG_YES = "是";

    /** 现金不收不付限制标志：否 */
    private static final String FLAG_NO = "否";

    private final IRbBusRestraintsBcc rbBusRestraintsBcc;

    private final IRbRestraintTypeBcc rbRestraintTypeBcc;

    public ST060Pbc(IRbBusRestraintsBcc rbBusRestraintsBcc, IRbRestraintTypeBcc rbRestraintTypeBcc) {
        this.rbBusRestraintsBcc = rbBusRestraintsBcc;
        this.rbRestraintTypeBcc = rbRestraintTypeBcc;
    }

    @Override
    public ST060OutputBO execute(ST060InputBO input) {
        ST060OutputBO output = new ST060OutputBO();

        // FIXME 业务项:ST060/检查是否存在现金不收不付限制 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:输入 baseAcctNo 标记必填，但为空/缺失时的行为未定义（Spec 待确认事项 TBD-6；Spec 明确本步骤不补充失败处理） - 影响:baseAcctNo 为空或缺失时当前按原查询条件执行，查询结果及步骤结果未定义 - 待确认:baseAcctNo 缺失时应报错及错误码，还是存在其它既定处理
        // 步骤1（REQ-001）：按账号与限制状态「A-生效」（RestraintsStatus.A）查询对公存款账户限制表
        RbBusRestraintsEO restraintsQuery = new RbBusRestraintsEO();
        restraintsQuery.setBaseAcctNo(input.getBaseAcctNo());
        restraintsQuery.setRestraintsStatus(RestraintsStatus.A);
        List<RbBusRestraintsEO> restraintsRecords = rbBusRestraintsBcc.findByEo(restraintsQuery);

        // FIXME 业务项:ST060/检查是否存在现金不收不付限制 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:账号无「生效」（RestraintsStatus.A）限制记录时需求未明确行为，按步骤3「否则」分支推得的现金不收不付限制标志「否」未在需求中显式确认（Spec 待确认事项 TBD-2） - 影响:当前无记录分支成功结束但现金不收不付限制标志及其余业务字段以空值占位返回，未按已确认规则赋值 - 待确认:无匹配记录时应返回「否」并成功结束，还是存在其它既定处理
        if (restraintsRecords.isEmpty()) {
            output.setSucceed(true);
            return output;
        }

        // FIXME 业务项:ST060/检查是否存在现金不收不付限制 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:账号下生效（RestraintsStatus.A）限制记录可能多于一条，需求未定义多条记录的判定规则与输出取数规则（Spec 待确认事项 TBD-1） - 影响:当前按工程约定取结果集第一条记录进行类型查询、判定与取数，未实现逐条判定或任一满足即「是」等规则 - 待确认:多条生效限制记录时应逐条判断存在任一满足「借贷方控制标志=A 且现金标志=N」即返回「是」，还是仅处理其中一条；输出 resSeqNo/restraintType/restraintsStatus 取自哪条记录
        RbBusRestraintsEO restraintsRecord = restraintsRecords.get(0);
        output.setResSeqNo(restraintsRecord.getResSeqNo());
        output.setRestraintType(restraintsRecord.getRestraintType());
        output.setRestraintsStatus(restraintsRecord.getRestraintsStatus());

        // 步骤2（REQ-002）：按账户限制类型与状态「A-生效」（Status.A）查询存款限制类型表
        RbRestraintTypeEO typeQuery = new RbRestraintTypeEO();
        typeQuery.setRestraintType(restraintsRecord.getRestraintType());
        typeQuery.setStatus(Status.A);
        List<RbRestraintTypeEO> typeRecords = rbRestraintTypeBcc.findByEo(typeQuery);

        // FIXME 业务项:ST060/检查是否存在现金不收不付限制 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:账户限制类型在存款限制类型表中无「生效」（Status.A）记录时需求未明确行为，按步骤3「否则」分支推得的「否」未在需求中显式确认（Spec 待确认事项 TBD-2） - 影响:当前无记录分支成功结束但现金不收不付限制标志以空值占位返回，未按已确认规则赋值 - 待确认:无匹配记录时应返回「否」并成功结束，还是存在其它既定处理
        if (typeRecords.isEmpty()) {
            output.setSucceed(true);
            return output;
        }

        RbRestraintTypeEO typeRecord = typeRecords.get(0);
        output.setDrCrCtlFlag(typeRecord.getDrCrCtlFlag());
        output.setStatus(typeRecord.getStatus());
        output.setCashFlag(typeRecord.getCashFlag());

        // 步骤3（REQ-003）：借贷方控制标志=A（禁止借贷方）且现金标志=N（禁止现金）时判定为「是」，否则为「否」
        if (DrCrCtlFlag.A.equals(typeRecord.getDrCrCtlFlag()) && CASH_FLAG_FORBIDDEN.equals(typeRecord.getCashFlag())) {
            output.setCashNoReceiveNoPayFlag(FLAG_YES);
        } else {
            output.setCashNoReceiveNoPayFlag(FLAG_NO);
        }

        // 步骤4（REQ-004）：正常完成按成功结束表达
        output.setSucceed(true);
        return output;
    }
}
