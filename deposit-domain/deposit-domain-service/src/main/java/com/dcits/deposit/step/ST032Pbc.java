package com.dcits.deposit.step;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST032InputBO;
import com.dcits.deposit.facade.bo.ST032OutputBO;

/**
 * ST032 检查交易金额。
 *
 * <p>以必填输入交易金额（tranAmt）执行金额检查：当交易金额小于等于 0 时返回业务失败
 * （succeed=false、errorCode=ER0050、errorMessage=ER0050::交易金额不能小于等于0），
 * 否则返回检查结果为"通过"、步骤正常完成（succeed=true，错误字段为 null）。</p>
 *
 * <p>比较按数值口径执行（{@code tranAmt.compareTo(BigDecimal.ZERO) <= 0}），忽略小数位表示差异
 * （0 与 0.00 数值相等，均满足"小于等于0"）。本步骤仅对输入做数值比较，无子步骤、无跳转，
 * 不查询数据库、不调用规则或其他组件接口。</p>
 */
@Service
public class ST032Pbc implements IST032 {

    @Override
    public ST032OutputBO execute(ST032InputBO input) {
        ST032OutputBO output = new ST032OutputBO();
        // 交易金额小于等于0（数值比较，忽略小数位表示差异）时返回业务失败
        // FIXME 业务项:ST032/检查交易金额 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:tranAmt 标记"必填"，但需求未定义其为空（null）或未提供时的行为及对应错误码与错误信息（Spec 待确认事项 TBD-1），需求仅声明"交易金额小于等于0"返回 ER0050 - 影响:tranAmt 为 null 时当前实现直接调用 compareTo 产生技术异常，不按业务失败处理 - 待确认:由调用方保证必填提供，还是本步骤自行校验并定义失败行为与错误码
        if (input.getTranAmt().compareTo(BigDecimal.ZERO) <= 0) {
            output.setSucceed(false);
            output.setErrorCode("ER0050");
            output.setErrorMessage("ER0050::交易金额不能小于等于0");
            return output;
        }
        // 交易金额大于0：检查结果为"通过"，步骤正常完成
        output.setSucceed(true);
        return output;
    }
}
