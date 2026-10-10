package com.dcits.depsit.step;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.depsit.facade.bo.ST121InputBO;
import com.dcits.depsit.facade.bo.ST121OutputBO;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.components.IRbTranDefBcc;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;
import com.dcits.depsit.facade.eo.RbTranDefEO;

/**
 * ST121 检查限制优先级 步骤实现。
 *
 * <p>执行顺序：子步骤 1（按 {交易类型} 查【交易定义信息】取冻结级别 → 回显 {@code tranResPriority}）
 * → 子步骤 2（按 {账户限制类型} 查【限制类型定义信息】取冻结级别 → 回显 {@code restraintResPriority}）
 * → 子步骤 3（比较两个冻结级别得出 {@code checkResult}）。两次查询均为按主键查询，至多返回一条记录。</p>
 *
 * <p>子步骤 3 的判定：交易的冻结级别高于限制类型对应的冻结级别时为「不检查限制」；否则——含两者相等、
 * 交易侧较低，以及任一冻结级别取不到值（按主键查询无对应记录，或记录存在但冻结级别列为空）——
 * 为「继续检查」。本步骤无业务失败场景，所有分支均不设置错误码；步骤只读，不写库、不产生数据变更，
 * 也不调用其它步骤、规则或外部服务，其余失败由技术异常向上传播。</p>
 *
 * <p>「高于」的比较口径：源需求未定义冻结级别的取值域与排序关系（RB_TRAN_DEF.RES_PRIORITY、
 * RB_RESTRAINT_TYPE.RES_PRIORITY 均为 VARCHAR(2) 且允许为空，工程内无对应枚举或字典），
 * 该缺口已由源需求「已接受的需求处理结论」按需求处理流程放行（见正式 Spec「验收范围与明确不覆盖的事项」
 * 第 1 项），放行记录不补充业务取值。为落实 REQ-003 的比较关系，本实现以字符串大小比较作为该关系的
 * 确定性承载，此处的比较方式不构成规范常量；业务给出取值清单与高低顺序后须同步修订本比较方式
 * 及相应用例的取值对。</p>
 */
@Service
public class ST121Pbc implements IST121 {

    /** 检查结果：不检查限制（交易的冻结级别高于限制的冻结级别）。 */
    private static final String CHECK_RESULT_SKIP = "不检查限制";

    /** 检查结果：继续检查（除「高于」以外的全部情形）。 */
    private static final String CHECK_RESULT_CONTINUE = "继续检查";

    /** 【交易定义信息】＝交易类型定义表（RB_TRAN_DEF）数据服务接口：子步骤 1 的取数来源（只读查询） */
    @Autowired
    private IRbTranDefBcc rbTranDefBcc;

    /** 【限制类型定义信息】＝存款限制类型表（RB_RESTRAINT_TYPE）数据服务接口：子步骤 2 的取数来源（只读查询） */
    @Autowired
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @Override
    public ST121OutputBO execute(ST121InputBO input) {
        ST121OutputBO output = new ST121OutputBO();

        // 子步骤 1 获取交易的冻结级别：根据{交易类型}查询【交易定义信息】获取交易的冻结级别
        RbTranDefEO tranDefInfo = rbTranDefBcc.findByTranType(input.getTranType());
        String tranResPriority = tranDefInfo == null ? null : tranDefInfo.getResPriority();
        output.setTranResPriority(tranResPriority);

        // 子步骤 2 获取限制的冻结级别：根据{账户限制类型}查询【限制类型定义信息】获取限制的冻结级别
        RbRestraintTypeEO restraintTypeInfo = rbRestraintTypeBcc.findByRestraintType(input.getRestraintType());
        String restraintResPriority = restraintTypeInfo == null ? null : restraintTypeInfo.getResPriority();
        output.setRestraintResPriority(restraintResPriority);

        // 子步骤 3 检查限制优先级：交易的[冻结级别]高于账户限制类型对应的[冻结级别]时返回"不检查限制"，
        // 否则（含两者相等、交易侧较低）返回"继续检查"；任一冻结级别取不到值时同样返回"继续检查"
        if (isUnavailable(tranResPriority) || isUnavailable(restraintResPriority)) {
            output.setCheckResult(CHECK_RESULT_CONTINUE);
        } else {
            output.setCheckResult(tranResPriority.compareTo(restraintResPriority) > 0
                    ? CHECK_RESULT_SKIP : CHECK_RESULT_CONTINUE);
        }

        output.setSucceed(true);
        return output;
    }

    /** 判定冻结级别是否取不到值：无对应记录（null）或冻结级别列为空。 */
    private static boolean isUnavailable(String resPriority) {
        return resPriority == null || resPriority.isEmpty();
    }
}
