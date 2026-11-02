package com.dcits.deposit.step;

import com.dcits.deposit.enums.VoucherLostStatus;
import com.dcits.deposit.facade.bo.ST001InputBO;
import com.dcits.deposit.facade.bo.ST001OutputBO;
import com.dcits.deposit.facade.components.IRbVoucherLostBcc;
import com.dcits.deposit.facade.eo.RbVoucherLostEO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST001 检查对手账户凭证状态 步骤实现。
 *
 * <p>子步骤 1：以输入账号（baseAcctNo）与凭证挂失状态"A-生效"（{@link VoucherLostStatus#A}，
 * 代码值 {@code "A"}）构造查询条件，经 {@link IRbVoucherLostBcc#findByEo} 查询凭证挂失登记簿
 * 取得凭证挂失信息集合；子步骤 2：集合非空时步骤业务失败并返回错误码 ER0068，集合为空时
 * 检查结果为"通过"、步骤正常完成。</p>
 */
@Service
public class ST001Pbc implements IST001 {

    /** 业务失败错误码：账户凭证挂失不能支取 */
    private static final String ERROR_CODE = "ER0068";
    /** 业务失败错误信息，按 错误码::业务说明 格式 */
    private static final String ERROR_MESSAGE = "ER0068::账户凭证挂失不能支取";

    @Autowired
    private IRbVoucherLostBcc rbVoucherLostBcc;

    @Override
    public ST001OutputBO execute(ST001InputBO input) {
        ST001OutputBO result = new ST001OutputBO();

        // 子步骤 1：以输入账号与凭证挂失状态"A-生效"查询凭证挂失登记簿，取得凭证挂失信息集合
        RbVoucherLostEO queryEo = new RbVoucherLostEO();
        queryEo.setBaseAcctNo(input.getBaseAcctNo());
        queryEo.setVoucherLostStatus(VoucherLostStatus.A);
        List<RbVoucherLostEO> voucherLostList = rbVoucherLostBcc.findByEo(queryEo);

        // FIXME 业务项:ST001/检查对手账户凭证状态 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:输出表声明的 voucherLostStatus/lostType/lostNo/voucherNo 四个非必填字段（来源凭证挂失登记簿）未明确赋值与对外返回路径，需求未定义成功或失败路径下是否随结果返回查询到的挂失记录明细（Spec 待确认事项 1） - 影响:当前成功与失败路径均不对四个输出字段赋值，挂失记录明细不对外返回 - 待确认:四个输出字段在何种路径下被赋值并对外返回，以及存在多条生效挂失记录时取哪条

        // 子步骤 2：集合非空 → 业务失败返回错误码 ER0068；集合为空 → 检查通过、正常完成
        if (voucherLostList != null && !voucherLostList.isEmpty()) {
            result.setSucceed(false);
            result.setErrorCode(ERROR_CODE);
            result.setErrorMessage(ERROR_MESSAGE);
            return result;
        }
        result.setSucceed(true);
        return result;
    }
}
