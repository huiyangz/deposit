package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST062InputBO;
import com.dcits.deposit.facade.bo.ST062OutputBO;

/**
 * ST062 检查是否存在现金止付限制 步骤接口。
 */
public interface IST062 {

    /**
     * 检查是否存在现金止付限制。
     *
     * <p>以输入账号（baseAcctNo）与限制状态「A-生效」（RestraintsStatus.A）查询账户限制信息
     * 集合，逐条按（账户限制类型、状态「A-生效」Status.A）查询限制类型配置，命中「借贷方控制
     * 标志为 D-禁止借方且现金标志为 N-不允许现金」时返回现金止付标志「是」并结束遍历，空集合
     * 或遍历结束无命中返回「否」。本步骤为只读查询，无已声明业务失败路径，正常完成与正常提前
     * 结束均按成功结果返回。</p>
     *
     * @param input 步骤输入
     * @return 步骤输出；succeed=true，errorCode/errorMessage 为 null
     */
    ST062OutputBO execute(ST062InputBO input);
}
