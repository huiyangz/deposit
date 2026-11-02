package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST011InputBO;
import com.dcits.deposit.facade.bo.ST011OutputBO;

/**
 * ST011 检查支取密码状态 步骤接口。
 *
 * <p>依据必填输入 baseAcctNo（账号）、pwdType（密码类型，本步骤查询的密码类型为「支取密码」）
 * 查询对公账户密码表（RB_BUS_PASSWORD）取得密码状态；密码状态为「L-锁定」（{@code PasswordStatus.L}）
 * 时以业务失败返回错误码 ER0079 并短路，否则正常完成并输出 passwordStatus，流程随后跳转至步骤
 * 《验证密码》（跳转由流程编排/步骤框架执行，本 Spec 不定义路由值）。</p>
 */
public interface IST011 {
    ST011OutputBO execute(ST011InputBO input);
}
