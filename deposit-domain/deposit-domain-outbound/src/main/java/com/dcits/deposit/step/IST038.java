package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST038InputBO;
import com.dcits.deposit.facade.bo.ST038OutputBO;

/**
 * ST038 检查账户机构是否可匹配到限额场景配置 步骤接口。
 */
public interface IST038 {

    /**
     * 执行步骤，返回限额场景编码等输出。
     *
     * @param input 输入 BO（必填账号 baseAcctNo）
     * @return 输出 BO（继承 StepResult，业务输出均为非必填）
     */
    ST038OutputBO execute(ST038InputBO input);
}
