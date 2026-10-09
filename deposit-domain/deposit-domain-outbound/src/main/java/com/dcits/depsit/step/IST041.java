package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST041InputBO;
import com.dcits.depsit.facade.bo.ST041OutputBO;

/**
 * ST041 检查存入交易类型 步骤接口。
 *
 * 在活期现金存入交易场景下，依据入参交易类型判定是否为本场景要求的「现金存入」，
 * 相等时返回检查结果「通过」，不等时返回错误码 {@code ER0049}。
 *
 * 本步骤为纯入参判定，不查询、不写入任何数据，无事务要求。
 */
public interface IST041 {

    /**
     * 执行交易类型检查。
     *
     * @param input 输入 BO，{@code tranType} 必填
     * @return 输出 BO；判定通过时 {@code succeed=true}，判定不通过时 {@code succeed=false} 且 {@code errorCode="ER0049"}
     */
    ST041OutputBO execute(ST041InputBO input);
}
