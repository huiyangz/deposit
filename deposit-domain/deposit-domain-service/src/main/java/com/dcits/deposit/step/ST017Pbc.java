package com.dcits.deposit.step;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST017InputBO;
import com.dcits.deposit.facade.bo.ST017OutputBO;

/**
 * ST017 检查币种一致性 步骤实现。
 *
 * <p>判定交易币种（tranCcy）与账户币种（acctCcy）是否一致：「一致」指两者的货币代码
 * 相同（Spec「依赖核对」）。一致时返回检查结果「通过」（步骤成功）；不一致时返回错误码
 * 「ER0051」业务失败（Spec 步骤描述条目 1 / REQ-001、REQ-002）。</p>
 */
@Service
public class ST017Pbc implements IST017 {

    /** 错误码：交易币种与账户币种不一致（errorcodes.properties：ER0051=交易币种与账户币种不一致） */
    private static final String ERROR_CODE_CCY_MISMATCH = "ER0051";
    /** 错误信息：错误码::业务说明（Spec 错误码与步骤结果契约） */
    private static final String ERROR_MESSAGE_CCY_MISMATCH = "ER0051::交易币种与账户币种不一致";

    @Override
    public ST017OutputBO execute(ST017InputBO input) {
        ST017OutputBO output = new ST017OutputBO();

        // 判定：交易币种与账户币种的货币代码是否一致。
        // tranCcy 与 acctCcy 为必填（Spec「输入」表）；缺失时的行为未定义，当前不设置
        // 校验失败返回，缺失输入按正常入参路径自然执行，实际结果未确认，见下方 FIXME。
        // FIXME 业务项:ST017/检查币种一致性 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:需求声明 tranCcy、acctCcy 均必填，但未定义任一输入缺失（null/未提供）时的行为——是否由步骤前必填校验拒绝、返回技术异常或使用其它错误码（Spec 待确认事项 1） - 影响:输入缺失分支无已确认失败处理，当前不设置校验失败返回，缺失输入按正常入参路径自然执行 - 待确认:任一输入为 null/缺失时应返回的失败状态/错误码/异常
        if (input.getTranCcy().getValue().equals(input.getAcctCcy().getValue())) {
            // 检查结果「通过」：按公共成功状态表达（succeed=true、错误字段为 null）。
            // FIXME 业务项:ST017/检查币种一致性 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:需求未声明业务输出字段（无「输出」表），"通过"结果是否要求以字面业务值（如字符串「通过」）返回及该值的既定承载字段未确认（Spec 待确认事项 2） - 影响:若"通过"应另有业务输出字段承载，当前 OutputBO 缺少该字段 - 待确认:"通过"是否另有业务输出字段承载，字段名与取值
            output.setSucceed(true);
            return output;
        }

        // 币种不一致：返回错误码 ER0051 业务失败，不返回检查结果「通过」。
        output.setSucceed(false);
        output.setErrorCode(ERROR_CODE_CCY_MISMATCH);
        output.setErrorMessage(ERROR_MESSAGE_CCY_MISMATCH);
        return output;
    }
}
