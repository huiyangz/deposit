package com.dcits.deposit.step;

import java.util.EnumSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST020InputBO;
import com.dcits.deposit.facade.bo.ST020OutputBO;

/**
 * ST020 检查转账交易类型 步骤实现。
 *
 * <p>依据必填输入交易类型（tranType）判定是否为「行内转账（非支票）」：命中候选集合返回
 * 检查结果「通过」，步骤成功结束（{@code succeed=true}，错误字段为空，正式 Spec REQ-001）；
 * 未命中时业务失败，返回错误码 ER0067、错误信息「ER0067::交易类型错误」并短路，不进入后续
 * 流程（正式 Spec REQ-002，errorcodes.properties {@code ER0067=交易类型错误}）。</p>
 *
 * <p>「行内转账（非支票）」为业务分类称谓，枚举 {@link TranType} 无同名常量；通过分支当前
 * 使用正式 Spec「依赖核对」列出的候选常量集合，精确成员归属见实现中 FIXME（待确认事项
 * TBD-1）。必填输入缺失（null）行为见 FIXME（待确认事项 TBD-2）。</p>
 */
@Service
public class ST020Pbc implements IST020 {

    // FIXME 业务项:ST020/检查转账交易类型 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:需求以业务分类「行内转账（非支票）」表述交易类型，TranType 枚举无同名常量（常量仅代码值与注释业务名称），精确成员集合未确认；当前以正式 Spec「依赖核对」候选集合（VALUE_4186/4187/4189/4190 非批量及冲销，VALUE_4386/4387/4389/43892/4390 批量非支票及冲销）实现通过分支 - 影响:冲销常量（4187/4190/4387/4390）与批量非支票变体（4386/4387/4389/43892/4390）是否属于「行内转账（非支票）」集合未定，确认前集合归属不作为验收断言，确认后需按精确集合调整通过分支并补充集合内全量通过断言 - 待确认:「行内转账（非支票）」对应的 TranType 枚举精确取值集合（是否包含冲销常量与批量非支票变体，正式 Spec 待确认事项 TBD-1）

    // FIXME 业务项:ST020/检查转账交易类型 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:需求标记 tranType 为必填（正式 Spec「输入」表），未定义输入缺失（null）时的行为；当前实现将 null 按未命中候选集合处理，返回错误码 ER0067（REQ-002「不为「行内转账（非支票）」」字面适用） - 影响:null 输入是否为既定失败行为及对应错误码未定，确认后需补充相应失败行为与断言 - 待确认:调用方是否保证必填输入 tranType 始终提供；若输入缺失存在既定失败行为，需确认对应错误码（正式 Spec 待确认事项 TBD-2）

    /** 交易类型为「行内转账（非支票）」的候选常量集合（待确认事项 TBD-1，见类上方 FIXME）。 */
    private static final Set<TranType> NON_CHECK_TRANSFER_SET = EnumSet.of(
            TranType.VALUE_4186, TranType.VALUE_4187, TranType.VALUE_4189, TranType.VALUE_4190,
            TranType.VALUE_4386, TranType.VALUE_4387, TranType.VALUE_4389, TranType.VALUE_43892,
            TranType.VALUE_4390);

    /** 错误码：交易类型错误（errorcodes.properties {@code ER0067=交易类型错误}）。 */
    private static final String ERROR_CODE_TRAN_TYPE = "ER0067";

    @Override
    public ST020OutputBO execute(ST020InputBO input) {
        ST020OutputBO result = new ST020OutputBO();
        TranType tranType = input.getTranType();
        // 规则 a（REQ-001）：交易类型为「行内转账（非支票）」候选集合 → 检查结果「通过」，步骤成功结束，错误字段为空
        if (NON_CHECK_TRANSFER_SET.contains(tranType)) {
            result.setSucceed(true);
            return result;
        }
        // 规则 b（REQ-002）：交易类型不为「行内转账（非支票）」 → 业务失败，返回 ER0067 并短路，不进入后续流程
        result.setSucceed(false);
        result.setErrorCode(ERROR_CODE_TRAN_TYPE);
        result.setErrorMessage(ERROR_CODE_TRAN_TYPE + "::交易类型错误");
        return result;
    }
}
