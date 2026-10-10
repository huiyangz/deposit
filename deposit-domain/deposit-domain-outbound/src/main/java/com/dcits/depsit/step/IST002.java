package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST002InputBO;
import com.dcits.depsit.facade.bo.ST002OutputBO;

/**
 * ST002 检查账户到期日 步骤接口。
 *
 * <p>本步骤为本地只读查询（按账号检索【账户信息】取账户到期日期），不含本地写入，
 * 调用方无需为本步骤开启事务。
 */
public interface IST002 {

    /**
     * 执行「检查账户到期日」。
     *
     * <p>子步骤 1 按 {@code baseAcctNo} 从【账户信息】取出账户到期日期并输出 {@code acctDueDate}；
     * 查不到账户时以 {@code ER0048} 结束本步骤，不再执行子步骤 2。
     * 子步骤 2 以子步骤 1 取得的值与 {@code tranDate} 比较：为空返回检查结果「通过」，
     * 早于交易日期返回 {@code ER0054}，不早于（晚于或等于）返回检查结果「通过」。
     *
     * @param input 步骤入参，承载账号与交易日期
     * @return 步骤执行结果，含账户到期日期与成功／错误码结论
     */
    ST002OutputBO execute(ST002InputBO input);
}
