package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST106InputBO;
import com.dcits.depsit.facade.bo.ST106OutputBO;

/**
 * ST106 获取累计限额 步骤接口。
 *
 * <p>以 {账号}（入参 {@code baseAcctNo}）作为限额检查对象值，连同 [限额场景编码]（入参
 * {@code limitSceneNo}）查询【限额累计信息表 RB_LIMIT_SUM_INFO】，取得该记录的限额累计金额与
 * 限额累计笔数；查无记录时两值均为 0。</p>
 *
 * <p>本步骤为纯读取步骤，不写入、新增或删除本地数据库记录，因此不要求调用方提供事务；
 * 本步骤无业务失败场景，失败仅由技术异常传播表达。</p>
 */
public interface IST106 {

    /**
     * 执行「获取累计限额」。
     *
     * @param input 步骤输入，含账号 {@code baseAcctNo}、客户号 {@code clientNo}、限额场景编码 {@code limitSceneNo}
     * @return 步骤输出；正常结束（含命中记录与查无记录两条路径）时 {@code succeed = true} 且错误字段为空
     */
    ST106OutputBO execute(ST106InputBO input);
}
