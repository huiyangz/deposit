package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;

/**
 * ST036 检查黑名单 步骤接口。
 *
 * <p>交易执行步骤：依次执行服务定义检查、黑名单信息检查、黑名单检查规则编号检查、
 * 黑名单限制操作标识检查等八个检查阶段；任一检查不满足时提前返回「通过」，全部检查
 * 通过后按处理方式返回「拒绝」「授权」或「提醒」（通过输出 dealFlow 承载）。</p>
 */
public interface IST036 {

    /**
     * 执行黑名单检查步骤。
     *
     * @param input 步骤输入
     * @return 步骤输出（succeed=true、errorCode/errorMessage 为空为正常结束；「通过」
     *     不设置 dealFlow，「拒绝/授权/提醒」设置 dealFlow=B/A/D）
     */
    ST036OutputBO execute(ST036InputBO input);
}
