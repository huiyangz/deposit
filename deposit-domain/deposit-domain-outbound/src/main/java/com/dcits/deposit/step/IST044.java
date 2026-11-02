package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST044InputBO;
import com.dcits.deposit.facade.bo.ST044OutputBO;

/**
 * ST044 登记累计限额 交易执行步骤接口。
 */
public interface IST044 {

    /**
     * 执行登记累计限额步骤。
     *
     * <p>依据限额检查结果与累计状态判定是否向限额累计信息表（RB_LIMIT_SUM_INFO）
     * 登记一条限额累计记录；条件不满足时不登记、不产生输出、正常结束。</p>
     *
     * <p>本步骤会写入限额累计信息表（RB_LIMIT_SUM_INFO），调用方须保证在事务中调用，
     * 实现以 {@code @Transactional} 声明本地写事务。</p>
     *
     * @param input 步骤输入
     * @return 步骤结果；业务输出仅在登记发生时产生
     */
    ST044OutputBO execute(ST044InputBO input);
}
