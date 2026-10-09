package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST050InputBO;
import com.dcits.depsit.facade.bo.ST050OutputBO;

/**
 * ST050 设置贷记交易的借贷标志 步骤接口。
 *
 * <p>将 [借贷标志] 赋值为常量“贷方”（枚举 {@code com.dcits.depsit.enums.CrDrInd} 的成员 {@code C}），
 * 并以字段 {@code crDrInd} 返回（REQ-001）。本步骤无输入依赖、不查询实体、不发起外部调用、不产生写入，
 * 因此<b>不要求调用方开启事务</b>。</p>
 *
 * <p>执行成功时返回结果 {@code succeed = true}，{@code errorCode} 与 {@code errorMessage} 均为 {@code null}；
 * 本步骤无业务失败场景，失败仅由技术异常按工程既有方式向上传播（REQ-003）。</p>
 */
public interface IST050 {

    /**
     * 执行「设置贷记交易的借贷标志」。
     *
     * @param input 步骤输入，本步骤无业务输入字段，可为空对象
     * @return 步骤输出，业务字段 {@code crDrInd} 恒为贷方（{@code CrDrInd.C}）；无业务失败结果
     */
    ST050OutputBO execute(ST050InputBO input);
}
