package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST001InputBO;
import com.dcits.deposit.facade.bo.ST001OutputBO;

/**
 * ST001 检查账户到期日 步骤接口
 *
 * 只读查询步骤，仅读取【账户信息】（RB_BUS_ACCT），无本地数据库写入，无事务要求。
 */
public interface IST001 {

    /**
     * 检查账户到期日
     *
     * @param input 账号、交易日期
     * @return 检查结果与账户到期日期；账户到期日期小于交易日期返回错误码 ER0054，未查询到账户信息记录返回业务失败
     */
    ST001OutputBO execute(ST001InputBO input);
}
