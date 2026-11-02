package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST008InputBO;
import com.dcits.deposit.facade.bo.ST008OutputBO;

/**
 * ST008 检查支取账户凭证状态。
 *
 * <p>依据必填输入账号（baseAcctNo）查询凭证挂失登记簿（RB_VOUCHER_LOST）获取凭证挂失状态；
 * 若状态为「A-生效」，步骤业务失败并返回错误码 ER0068（账户凭证挂失不能支取），否则返回检查结果「通过」。</p>
 */
public interface IST008 {

    /**
     * 执行检查支取账户凭证状态。
     *
     * @param input 输入 BO：必填字段 baseAcctNo（账号）
     * @return 输出 BO：voucherLostStatus（凭证挂失状态，非必填），并按步骤结果约定设置 succeed / errorCode / errorMessage
     */
    ST008OutputBO execute(ST008InputBO input);
}
