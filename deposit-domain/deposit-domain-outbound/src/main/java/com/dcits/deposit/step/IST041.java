package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST041InputBO;
import com.dcits.deposit.facade.bo.ST041OutputBO;

/**
 * ST041 处理限额 步骤接口。
 */
public interface IST041 {

    /**
     * 以必填输入 limitSceneNo（限额场景编码）查询【限额控制配置】（RB_LIMIT_CTRL_CONF），
     * 取得对应配置记录的处理方式（dealFlow），并按处理方式（拒绝/提醒/授权）返回检查结果。
     *
     * @param input ST041 步骤输入
     * @return 步骤输出：成功时 succeed=true 且错误字段为空，业务输出 dealFlow 为处理方式
     */
    ST041OutputBO execute(ST041InputBO input);
}
