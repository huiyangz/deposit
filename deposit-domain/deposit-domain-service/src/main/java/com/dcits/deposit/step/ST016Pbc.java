package com.dcits.deposit.step;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.dcits.deposit.facade.bo.ST016InputBO;
import com.dcits.deposit.facade.bo.ST016OutputBO;

/**
 * ST016 检查账户客户一致性 步骤实现。
 *
 * <p>比较账户客户号（clientNo）与对手客户号（othClientNo）：取值一致时判定为同名客户转账，
 * 本步骤业务失败并返回错误码 ER0078，且不产生检查结果「通过」（REQ-001）；取值不一致时
 * 检查通过、步骤正常结束且成功、不带错误码（REQ-002）。</p>
 *
 * <p>本步骤仅对输入字段做取值比较，不发起查询或外部调用（正式 Spec「输入、输出及依赖契约」）。</p>
 */
@Service
public class ST016Pbc implements IST016 {

    /** 错误码 ER0078（errorcodes.properties：ER0078=资金监管账户不允许同名账户转账） */
    private static final String ERROR_CODE_ER0078 = "ER0078";

    /** 错误信息，按「错误码::业务说明」格式组织（Spec「错误码核对」确认口径） */
    private static final String ERROR_MESSAGE_ER0078 = "ER0078::资金监管账户不允许同名账户转账";

    @Override
    public ST016OutputBO execute(ST016InputBO input) {
        ST016OutputBO output = new ST016OutputBO();
        String clientNo = input.getClientNo();
        String othClientNo = input.getOthClientNo();
        // 一致路径（REQ-001）：客户号与对手客户号取值一致，判定为同名客户转账，步骤业务失败并返回错误码 ER0078，短路不产生检查结果「通过」
        // FIXME 业务项:ST016/检查账户客户一致性 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:clientNo、othClientNo 均标记「必填」，但需求未定义任一输入缺失（null 或空字符串）时的行为：必填校验不通过时返回的错误码/处理方式，以及空字符串是否参与「一致」比较，均未确认（Spec TBD-1） - 影响:null 与 null 当前按取值一致判定为同名账户转账返回 ER0078，null 与其它值当前按不一致判定检查通过，空字符串按字面值参与「一致」比较，这些结果均未获业务确认 - 待确认:必填输入缺失（null 或空字符串）时的处理方式及返回的错误码，空字符串是否参与「一致」比较
        if (Objects.equals(clientNo, othClientNo)) {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ER0078);
            output.setErrorMessage(ERROR_MESSAGE_ER0078);
            return output;
        }
        // 不一致路径（REQ-002）：取值不一致时检查通过，步骤正常结束且成功、不带错误码
        output.setSucceed(true);
        return output;
    }
}
