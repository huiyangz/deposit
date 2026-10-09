package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST084InputBO;
import com.dcits.depsit.facade.bo.ST084OutputBO;

/**
 * ST084 检查联系人（步骤接口）。
 *
 * <p>按子步骤 1→2→3→（4）→5 的顺序执行：先查询【证件类型定义信息】获取全量[证件类型列表]，
 * 再依次完成证件类型合法性检查、是否“居民身份证”的判定、居民身份证的证件号码长度检查（18 位）
 * 与电话号码长度检查（11 位）。任一检查失败即终止本步骤并返回对应错误码
 * （ER0036 证件类型不存在、ER0037 身份证号码长度不为18位、ER0038 电话号码长度不为11位）；
 * 全部通过则返回检查结果“通过”。</p>
 *
 * <p>本步骤只读取本地实体数据，不新增、更新或删除本地数据，不要求调用方开启事务。</p>
 */
public interface IST084 {

    /**
     * 执行 ST084 检查联系人。
     *
     * @param input 步骤输入：documentId（证件号码）、电话号码、documentType（证件类型）
     * @return 步骤输出：检查结果“通过”时 succeed=true 且错误码、错误信息为 null；
     *         业务失败时 succeed=false 并携带 ER0036／ER0037／ER0038 之一的错误码
     */
    ST084OutputBO execute(ST084InputBO input);
}
