package com.dcits.deposit.step;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.CtrlItemType;
import com.dcits.deposit.enums.SumType;
import com.dcits.deposit.facade.bo.ST039InputBO;
import com.dcits.deposit.facade.bo.ST039OutputBO;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.components.IRbLimitSceneDefBcc;
import com.dcits.deposit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.deposit.facade.components.IRbLimitSumJnlBcc;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;
import com.dcits.deposit.facade.eo.RbLimitSceneDefEO;
import com.dcits.deposit.facade.eo.RbLimitSumInfoEO;
import com.dcits.deposit.facade.eo.RbLimitSumJnlEO;

/**
 * ST039 计算限额累计金额 步骤实现。
 *
 * <p>执行流程（正式 Spec ST039 REQ-002~REQ-009）：按 limitSceneNo 从限额控制配置表获取
 * 限额信息（REQ-002）；限额控制类型为 O-单笔金额时不计算累计限额（REQ-003）；累计类型
 * 代码为 1/3/4/5 时按限额场景定义表的检查对象类型查询限额累计信息表并累加
 * （REQ-004~REQ-006）；累计类型代码为 2-滑动窗口时查询限额累计流水表并汇总
 * （REQ-007~REQ-009）。</p>
 *
 * <p>本步骤无业务失败场景声明：需求未声明的各分支行为（限额信息未查询到、场景定义未查询到、
 * 累计类型代码未定义等）见 FIXME（TBD-1~TBD-9），待业务确认前按正常提前结束处理，不产出
 * 累计结果，也不设置错误码。</p>
 */
@Service
public class ST039Pbc implements IST039 {

    @Autowired
    private IRbLimitCtrlConfBcc rbLimitCtrlConfBcc;

    @Autowired
    private IRbLimitSceneDefBcc rbLimitSceneDefBcc;

    @Autowired
    private IRbLimitSumInfoBcc rbLimitSumInfoBcc;

    @Autowired
    private IRbLimitSumJnlBcc rbLimitSumJnlBcc;

    @Override
    public ST039OutputBO execute(ST039InputBO input) {
        ST039OutputBO output = new ST039OutputBO();

        // REQ-002：按 limitSceneNo 从限额控制配置表获取限额信息
        RbLimitCtrlConfEO confEo = new RbLimitCtrlConfEO();
        confEo.setLimitSceneNo(input.getLimitSceneNo());
        List<RbLimitCtrlConfEO> confList = rbLimitCtrlConfBcc.findByEo(confEo);
        // 单条结果查询：多条取结果集第一条
        RbLimitCtrlConfEO conf = confList.isEmpty() ? null : confList.get(0);
        // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:限额信息来源应在限额控制配置表与限额控制客户自定义配置表之间选取，需求未声明两表选取规则（TBD-1） - 影响:当前仅按 limitSceneNo 查询限额控制配置表，未处理客户自定义配置表（onlyCustom、allowCustomFlag 等判定未应用） - 待确认:两表选取规则（优先级、判定条件）及各自查询条件
        if (conf == null) {
            // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:按 limitSceneNo 未查询到限额信息时需求未定义处理方式（TBD-7） - 影响:当前按正常提前结束返回，succeed=true 且不产出累计结果 - 待确认:限额信息不存在是否属于业务失败、应报错还是返回默认结果
            output.setSucceed(true);
            return output;
        }

        // REQ-003：限额控制类型为 O-单笔金额时不计算累计限额
        // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:O-单笔金额分支下 limitSumAmt 与限额累计笔数的输出表示需求未声明（TBD-5） - 影响:当前两输出保持 null 未设置，按正常提前结束返回 - 待确认:该分支输出应为 null、不设置还是其它约定值
        if (conf.getCtrlItemType() == CtrlItemType.O) {
            output.setSucceed(true);
            return output;
        }

        if (conf.getSumType() == SumType.VALUE_2) {
            // 累计类型代码 2-滑动窗口：REQ-007~REQ-009
            handleSlidingWindow(input, output);
        } else if (conf.getSumType() == SumType.VALUE_1
                || conf.getSumType() == SumType.VALUE_3
                || conf.getSumType() == SumType.VALUE_4
                || conf.getSumType() == SumType.VALUE_5) {
            // 累计类型代码 1/3/4/5 非滑动窗口：REQ-004~REQ-006
            handleNonSliding(input, output);
        } else {
            // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:累计类型代码非 1/2/3/4/5（含 null）时需求未定义行为（TBD-7） - 影响:当前按正常提前结束返回，succeed=true 且不产出累计结果 - 待确认:未定义累计类型应报错还是返回默认结果
            output.setSucceed(true);
            return output;
        }

        output.setSucceed(true);
        return output;
    }

    /**
     * 非滑动窗口累计（REQ-004~REQ-006）：累计类型代码为 1/3/4/5 时，按限额场景编码与
     * 限额场景定义表的检查对象类型查询限额累计信息表，系统日期处于生效范围内的记录
     * 累加交易金额与笔数。
     */
    private void handleNonSliding(ST039InputBO input, ST039OutputBO output) {
        RbLimitSceneDefEO sceneDef = querySceneDef();
        if (sceneDef == null) {
            // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:限额场景定义未查询到时需求未定义处理方式（TBD-7） - 影响:当前按正常提前结束返回，succeed=true 且不产出累计结果 - 待确认:场景定义不存在是否属于业务失败、应报错还是返回默认结果
            return;
        }
        // REQ-004：按 limitSceneNo 与检查对象类型查询限额累计信息表；检查对象值来源未定义，
        // 查询条件仅设置限额场景编码
        // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:查询限额累计信息表所需的检查对象值（checkObjVal）来源需求未声明，输入仅含 tranAmt 与 limitSceneNo（TBD-2） - 影响:当前查询未设置 checkObjVal，无法按检查对象精确查询累计限额信息 - 待确认:checkObjVal 由调用方提供还是从交易上下文取得，以及按检查对象类型对应取哪个值
        RbLimitSumInfoEO sumInfoEo = new RbLimitSumInfoEO();
        sumInfoEo.setLimitSceneNo(input.getLimitSceneNo());
        List<RbLimitSumInfoEO> sumInfoList = rbLimitSumInfoBcc.findByEo(sumInfoEo);
        // 单条结果查询：多条取结果集第一条
        RbLimitSumInfoEO sumInfo = sumInfoList.isEmpty() ? null : sumInfoList.get(0);

        // REQ-005：系统日期处于生效范围内（生效日期与失效日期之间）的累计限额信息参与累加
        Date now = new Date();
        if (sumInfo != null && isWithinEffectRange(sumInfo, now)) {
            // REQ-005：限额累计金额=记录限额累计金额+交易金额，限额累计笔数=记录笔数+1
            // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:生效范围边界是否含等号需求表述不一致（TBD-4） - 影响:当前按严格 生效日期<系统日期<失效日期 判定生效，边界日期不参与累加 - 待确认:生效范围应含边界等号还是严格大于小于
            BigDecimal baseAmt = sumInfo.getLimitSumAmt();
            Integer baseCnt = sumInfo.get否();
            output.setLimitSumAmt(baseAmt == null ? null : baseAmt.add(input.getTranAmt()));
            output.set限额累计笔数(baseCnt == null ? null : Integer.valueOf(baseCnt.intValue() + 1));
        } else {
            // REQ-006：未查询到或不在生效范围内的累计限额信息，限额累计笔数返回 1；
            // 限额累计金额取值需求无来源（TBD-3），当前不设置
            // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:生效范围内累计限额信息不存在时需求原文「限额累计金额等于累计限额金额」无取值来源，且与 REQ-009（返回交易金额）不一致（TBD-3） - 影响:当前限额累计金额保持 null 未设置，仅返回限额累计笔数 1 - 待确认:该分支限额累计金额应返回交易金额还是其它值
            output.set限额累计笔数(Integer.valueOf(1));
        }
    }

    /**
     * 滑动窗口累计（REQ-007~REQ-009）：累计类型代码为 2-滑动窗口时，查询有效周期内的
     * 限额累计流水并汇总交易金额与笔数。
     */
    private void handleSlidingWindow(ST039InputBO input, ST039OutputBO output) {
        RbLimitSceneDefEO sceneDef = querySceneDef();
        if (sceneDef == null) {
            // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:限额场景定义未查询到时需求未定义处理方式（TBD-7） - 影响:当前按正常提前结束返回，succeed=true 且不产出累计结果 - 待确认:场景定义不存在是否属于业务失败、应报错还是返回默认结果
            return;
        }
        // REQ-007：按 limitSceneNo 与检查对象类型、周期值、期限类型查询有效周期内的限额；
        // 检查对象值来源未定义，查询条件仅设置限额场景编码
        // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:查询限额累计流水表所需的检查对象值（checkObjVal）来源需求未声明，输入仅含 tranAmt 与 limitSceneNo（TBD-2） - 影响:当前查询未设置 checkObjVal，无法按检查对象精确查询限额流水 - 待确认:checkObjVal 由调用方提供还是从交易上下文取得，以及按检查对象类型对应取哪个值
        // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:滑动窗口有效周期的起止计算需求未定义，周期值 periodValue 与期限类型 periodType 未用于限定查询；汇总字段（tranAmt 与 limitConvertAmt 的取舍）、是否计入当前交易及笔数口径亦未明确（TBD-6） - 影响:当前仅按 limitSceneNo 查询全部流水并按 tranAmt 汇总、每条记录计一笔，未按有效周期过滤 - 待确认:有效周期起止计算规则及金额、笔数的汇总口径
        RbLimitSumJnlEO jnlEo = new RbLimitSumJnlEO();
        jnlEo.setLimitSceneNo(input.getLimitSceneNo());
        List<RbLimitSumJnlEO> jnlList = rbLimitSumJnlBcc.findByEo(jnlEo);
        if (jnlList.isEmpty()) {
            // REQ-009：有效周期内不存在限额，限额累计金额=交易金额、限额累计笔数=1
            output.setLimitSumAmt(input.getTranAmt());
            output.set限额累计笔数(Integer.valueOf(1));
            return;
        }
        // REQ-008：有效周期内限额存在，限额累计金额=交易金额之和、限额累计笔数=交易笔数之和
        BigDecimal totalAmt = BigDecimal.ZERO;
        for (RbLimitSumJnlEO jnl : jnlList) {
            if (jnl.getTranAmt() != null) {
                totalAmt = totalAmt.add(jnl.getTranAmt());
            }
        }
        output.setLimitSumAmt(totalAmt);
        output.set限额累计笔数(Integer.valueOf(jnlList.size()));
    }

    /**
     * 查询限额场景定义取得检查对象类型（REQ-004/REQ-007 共用）。
     *
     * <p>单条结果查询：多条取结果集第一条；无记录返回 null（TBD-7 未定义处理方式）。</p>
     */
    private RbLimitSceneDefEO querySceneDef() {
        // FIXME 业务项:ST039/计算限额累计金额 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:限额场景定义实体 RbLimitSceneDefEO 无 limitSceneNo 字段，按限额场景编码取得检查对象类型的查询路径需求未定义（TBD-9） - 影响:当前以无关联条件查询限额场景定义表并取第一条，无法按场景精确取得检查对象类型 - 待确认:场景定义与限额场景的关联查询方式（关联字段或中间关联表）
        RbLimitSceneDefEO sceneDefEo = new RbLimitSceneDefEO();
        List<RbLimitSceneDefEO> sceneDefList = rbLimitSceneDefBcc.findByEo(sceneDefEo);
        return sceneDefList.isEmpty() ? null : sceneDefList.get(0);
    }

    /**
     * 判断累计限额信息是否处于生效范围内（REQ-005）。
     *
     * <p>生效日期或失效日期为空时视为不在生效范围内；边界取等语义见 FIXME（TBD-4）。</p>
     */
    private boolean isWithinEffectRange(RbLimitSumInfoEO sumInfo, Date now) {
        Date effectDate = sumInfo.getEffectDate();
        Date expireDate = sumInfo.getExpireDate();
        if (effectDate == null || expireDate == null) {
            return false;
        }
        return now.after(effectDate) && now.before(expireDate);
    }
}
