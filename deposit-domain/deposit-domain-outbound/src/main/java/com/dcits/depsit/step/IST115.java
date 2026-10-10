package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST115InputBO;
import com.dcits.depsit.facade.bo.ST115OutputBO;

/**
 * ST115 检查账户是否存在限制 步骤接口。
 *
 * <p>以入参账号（{@code baseAcctNo}）为条件查询【账户信息】（对公存款账户主表 {@code RB_BUS_ACCT}），
 * 唯一命中一条时可继续：命中记录表明其不是主账户时，按其「上级账户内部键」回查【账户信息】取主账户账号，
 * 并以该账号为 [待查账户]；是主账户时以入参账号为 [待查账户]。随后按 [待查账户] 与限制状态
 * 「A-生效」（码值 {@code "A"}）查询【账户限制信息表】（对公存款账户限制表 {@code RB_BUS_RESTRAINTS}），
 * 零条命中时三个回显字段为空值，多条命中时按限制编号升序取第一条并回显该条的限制编号、
 * 账户限制类型、限制状态；并按「## 输出」表回显按上送 {@code {账号}} 查得的【账户信息】记录的
 * 账号（{@code baseAcctNo}）与主账户标志（{@code leadAcctFlag}）（Spec REQ-001 ~ REQ-009）。</p>
 *
 * <p>业务失败仅「按 {账号} 查询【账户信息】查不到记录或查到多条记录」，此时返回错误码
 * {@code ER0048}（账户不存在）并短路结束本步骤，回查、[待查账户] 赋值、限制查询与输出赋值均不执行
 * （Spec REQ-002、REQ-009-S03、REQ-010）。</p>
 *
 * <p>本步骤只读取数据、不写库、不修改账户或限制数据，因此调用方无需为本步骤提供事务；
 * 除 {@code ER0048} 外的失败由技术异常向上传播。</p>
 */
public interface IST115 {

    /**
     * 执行「检查账户是否存在限制」。
     *
     * @param input 步骤入参：账号（{@code baseAcctNo}，必填）
     * @return 步骤输出：命中时回显限制编号 {@code resSeqNo}、账户限制类型 {@code restraintType}、
     *         限制状态 {@code restraintsStatus}（多条命中取限制编号升序第一条）；零条命中时三者为空值；
     *         并回显按上送 {@code {账号}} 查得的【账户信息】记录的账号 {@code baseAcctNo} 与
     *         主账户标志 {@code leadAcctFlag}（不取回查所得主账户记录）；
     *         成功时 {@code succeed=true} 且错误码、错误信息为 null；
     *         按账号查【账户信息】查无或多条时 {@code succeed=false} 且 {@code errorCode="ER0048"}
     */
    ST115OutputBO execute(ST115InputBO input);
}
