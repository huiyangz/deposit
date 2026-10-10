package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST120InputBO;
import com.dcits.depsit.facade.bo.ST120OutputBO;

/**
 * ST120 检查是否存在转账不收不付限制。
 *
 * <p>以入参账号查询【账户限制信息】，逐条按其账户限制类型到【限制类型表】取状态为 A-生效 配置的
 * 借贷方控制标志与转账标志，判定该账户是否存在转账不收不付限制，结论由
 * {@code acctTranNoRecvNoPayFlag}（"是" / "否"）承载。</p>
 *
 * <p>本步骤只读，不新增、修改或解除任何限制记录，不执行冻结/解限等账务动作，不跳转其他步骤；
 * 无业务失败场景，依赖的数据访问异常按技术异常向上传播，本步骤不提供事务要求。</p>
 */
public interface IST120 {

    /**
     * 执行步骤。
     *
     * @param input 入参，账号（baseAcctNo）必填
     * @return 出参：转账不收不付标志及命中记录的回显字段
     */
    ST120OutputBO execute(ST120InputBO input);
}
