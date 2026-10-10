package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST122InputBO;
import com.dcits.depsit.facade.bo.ST122OutputBO;

/**
 * ST122 检查是否存在不收不付限制 的步骤接口。
 *
 * <p>本步骤为只读检查，不产生本地数据写入，无事务要求。</p>
 */
public interface IST122 {

    /**
     * 执行步骤 ST122：按账号与生效状态查询【账户限制信息】，逐条依据【限制类型表】的
     * A-生效 配置判定是否构成不收不付限制，并在多条记录间聚合结论。
     *
     * @param input 步骤输入（baseAcctNo＝账号）
     * @return 步骤输出：noRecvNoPayFlag（"是" / "否"），命中时并回显 resSeqNo、restraintType、
     *         restraintsStatus、drCrCtlFlag、status；本步骤无业务失败场景，正常完成时 succeed＝true
     */
    ST122OutputBO execute(ST122InputBO input);
}
