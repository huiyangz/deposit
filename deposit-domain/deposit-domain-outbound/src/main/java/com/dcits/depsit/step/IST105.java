package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST105InputBO;
import com.dcits.depsit.facade.bo.ST105OutputBO;

/**
 * ST105 处理限额 步骤接口。
 *
 * <p>以 [限额场景编码]（入参 {@code limitSceneNo}）为条件查询【限额控制配置(RB_LIMIT_CTRL_CONF)】，
 * 取得该配置的 [处理方式]（{@code DEAL_FLOW}），并据其取值返回「授权」（A）／「拒绝」（B）／
 * 「提醒」（D）三种检查结果之一，经唯一输出字段 {@code dealFlow} 对外交付。</p>
 *
 * <p>本步骤为纯读取步骤，不写入、新增或删除本地数据库记录，因此不要求调用方提供事务；
 * 本步骤无业务失败场景，正常结束（含查无配置记录等未定义取值情形）时 {@code succeed = true}，
 * 失败仅由技术异常向外传播表达，调用方按技术异常处理。</p>
 */
public interface IST105 {

    /**
     * 执行「处理限额」。
     *
     * @param input 步骤输入，含限额场景编码 {@code limitSceneNo}
     * @return 步骤输出；正常结束时 {@code succeed = true} 且错误字段为空，
     *         检查结果经 {@code dealFlow} 交付
     */
    ST105OutputBO execute(ST105InputBO input);
}
