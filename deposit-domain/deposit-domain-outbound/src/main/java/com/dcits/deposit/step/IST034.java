package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST034InputBO;
import com.dcits.deposit.facade.bo.ST034OutputBO;

/**
 * ST034 检查对手账户黑名单 步骤接口。
 */
public interface IST034 {
    /**
     * 检查对手账户黑名单。
     *
     * <p>按步骤描述 1–4 执行：第 1 步按凭证类型查询凭证类型定义表（TB_VOUCHER_DEF）获取凭证种类
     * docClass；第 2 步赋值事件类型为 "CRET"；第 3 步以组件内步骤调用方式访问本组件内步骤 ST036
     * 检查黑名单取得执行结果；第 4 步按执行结果分支：通过/提醒继续执行，授权输出授权标志为"是"
     * 并正常结束，拒绝返回错误码 ER0057（步骤业务失败）。</p>
     *
     * @param input 输入（docType 凭证类型、othBaseAcctNo 对手账号、tranBranch 交易机构号、
     *              tranType 交易类型、serviceCode 服务代码、messageCode 接口服务代码、
     *              messageType 接口服务类型、sourceType 渠道类型）
     * @return 输出（eventType 事件类型、dealFlow 处理方式、授权标志、docClass 凭证种类）
     */
    ST034OutputBO execute(ST034InputBO input);
}
