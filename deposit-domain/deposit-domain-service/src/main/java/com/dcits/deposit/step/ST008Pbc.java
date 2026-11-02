package com.dcits.deposit.step;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.deposit.enums.VoucherLostStatus;
import com.dcits.deposit.facade.bo.ST008InputBO;
import com.dcits.deposit.facade.bo.ST008OutputBO;
import com.dcits.deposit.facade.components.IRbVoucherLostBcc;
import com.dcits.deposit.facade.eo.RbVoucherLostEO;

/**
 * ST008 检查支取账户凭证状态。
 *
 * <p>依据必填输入账号（baseAcctNo）查询凭证挂失登记簿（RB_VOUCHER_LOST）获取凭证挂失状态（voucherLostStatus）；
 * 若状态为「A-生效」（{@link VoucherLostStatus#A}），步骤业务失败并返回错误码 ER0068（账户凭证挂失不能支取）；
 * 否则返回检查结果「通过」，步骤正常完成（{@code succeed=true}，错误字段为空）。</p>
 */
@Service
public class ST008Pbc implements IST008 {

    /** 凭证挂失状态为「生效」时的错误码：账户凭证挂失不能支取 */
    private static final String ERROR_CODE_VOUCHER_LOST = "ER0068";
    /** 凭证挂失状态为「生效」时的错误信息（已确认格式：错误码::业务说明） */
    private static final String ERROR_MESSAGE_VOUCHER_LOST = "ER0068::账户凭证挂失不能支取";

    @Autowired
    private IRbVoucherLostBcc rbVoucherLostBcc;

    @Override
    public ST008OutputBO execute(ST008InputBO input) {
        ST008OutputBO output = new ST008OutputBO();

        // 子步骤1：根据{账号}查询【凭证挂失信息】获取$凭证挂失状态$
        // FIXME 业务项:ST008/检查支取账户凭证状态 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:需求标记 baseAcctNo 为必填，但未定义其为空/未提供时的行为（Spec 待确认事项 2） - 影响:baseAcctNo 为 null 或空串时按当前实现仍以该值构造查询 EO 执行查询，无已确认的校验或失败路径 - 待确认:必填输入缺失时应返回哪个错误码、何种失败行为，或由调用方保证提供
        RbVoucherLostEO queryEo = new RbVoucherLostEO();
        queryEo.setBaseAcctNo(input.getBaseAcctNo());
        List<RbVoucherLostEO> voucherLostList = rbVoucherLostBcc.findByEo(queryEo);

        VoucherLostStatus voucherLostStatus = null;
        if (!voucherLostList.isEmpty()) {
            // 面向单条结果的查询：多条记录时按本项目约定取结果集第一条
            // FIXME 业务项:ST008/检查支取账户凭证状态 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:需求以单数表述「获取$凭证挂失状态$」，未定义同一账号存在多条挂失记录时取哪条记录的状态、以及是否存在生效记录即应判定失败（Spec 待确认事项 1） - 影响:多条记录路径当前按本项目约定取结果集第一条的状态，取舍结果未确认 - 待确认:同一账号多条挂失记录时取哪条状态，是否存在生效记录即应判定失败
            voucherLostStatus = voucherLostList.get(0).getVoucherLostStatus();
        }
        output.setVoucherLostStatus(voucherLostStatus);

        // 子步骤2：检查凭证挂失状态，若[凭证挂失状态]是"A-生效"，则返回[错误码]"ER0068"，否则返回检查结果为"通过"
        if (voucherLostStatus == VoucherLostStatus.A) {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_VOUCHER_LOST);
            output.setErrorMessage(ERROR_MESSAGE_VOUCHER_LOST);
            return output;
        }

        output.setSucceed(true);
        return output;
    }
}
