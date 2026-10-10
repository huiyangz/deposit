package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST124InputBO;
import com.dcits.depsit.facade.bo.ST124OutputBO;

/**
 * ST124 检查是否存在现金不收不付限制。
 *
 * <p>以入参账号查询【账户限制信息】，逐条按其账户限制类型到【限制类型表】取状态为 A-生效 配置的
 * 借贷方控制标志与现金标志，判定该账户是否存在现金不收不付限制，结论由
 * {@code cashNoRecvNoPayFlag}（"是" / "否"）承载。</p>
 *
 * <p>本步骤只读，不写库、不修改任何账户或限制数据；无业务失败场景，依赖的数据访问异常按技术异常向上传播。</p>
 */
public interface IST124 {

    /**
     * 执行步骤。
     *
     * @param input 入参，账号（baseAcctNo）必填
     * @return 出参：现金不收不付限制标志及命中记录的回显字段
     */
    ST124OutputBO execute(ST124InputBO input);
}
