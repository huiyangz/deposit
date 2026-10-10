package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST109InputBO;
import com.dcits.depsit.facade.bo.ST109OutputBO;

/**
 * ST109 检查限额场景配置是否有效。
 *
 * <p>调用签名：{@code ST109OutputBO execute(ST109InputBO input)}。</p>
 *
 * <p>本步骤为只读查询：按 [限额场景编码] 查询【限额控制配置】并判定配置是否覆盖本次交易，
 * 不写库、不调用其它服务，对调用方无事务要求。步骤无业务失败场景，
 * 配置无效（查无记录或全部记录未覆盖）为正常判定结果，失败仅由技术异常传播表达。</p>
 */
public interface IST109 {

    /**
     * 执行检查限额场景配置是否有效。
     *
     * @param input 交易日期、交易时间戳、限额场景编码（三项必填）
     * @return 判定结果：配置有效时 limitSceneNo 为入参原值并回显命中记录的控制区间值；
     *         无效时 limitSceneNo 为空值；两种结论均 succeed=true 且错误字段为 null
     */
    ST109OutputBO execute(ST109InputBO input);
}
