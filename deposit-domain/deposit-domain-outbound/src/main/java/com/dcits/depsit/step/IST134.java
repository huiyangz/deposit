package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST134InputBO;
import com.dcits.depsit.facade.bo.ST134OutputBO;

/**
 * ST134 解限更新账户冻结金额 —— 步骤接口。
 *
 * <p>源需求「## 步骤描述」1：先按 {账号} 查询【账户信息】取得账户内部键值，再按账户内部键值
 * 更新【账户余额信息】的 $冻结金额$ 为 0；查不到账户或该账户没有余额记录时，返回错误码
 * ER0048“账户不存在”并结束本步骤。</p>
 *
 * <p><b>事务要求</b>：本步骤包含对【账户余额信息】的本地更新，调用方 MUST 在事务内调用
 * {@link #execute(ST134InputBO)}（实现类已在方法上声明 {@code @Transactional}）。
 * 业务失败通过返回结果的 {@code succeed=false} 表达，不会自动回滚，调用方按本步骤的
 * 业务契约决定提交或回滚。</p>
 */
public interface IST134 {

    /**
     * 执行本步骤。
     *
     * @param input 步骤输入，仅承载账号 {@code baseAcctNo}
     * @return 步骤结果：成功时 {@code succeed=true} 且 {@code pldAmount} 为本次写入的 0；
     *         按账号查不到账户或该账户没有余额记录时 {@code succeed=false}、
     *         {@code errorCode="ER0048"}
     */
    ST134OutputBO execute(ST134InputBO input);
}
