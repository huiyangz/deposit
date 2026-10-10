package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST111InputBO;
import com.dcits.depsit.facade.bo.ST111OutputBO;

/**
 * ST111 检查客户是否存在限制 —— 步骤接口。
 *
 * <p>步骤为只读检查：按入参客户号与限制状态码值 {@code "A"} 查询【客户限制表】，
 * 取回该客户的生效限制记录（零条到多条；多于一条时按限制编号升序取第一条），
 * 再赋值客户限制信息并返回 [客户限制信息]。本步骤不新增、修改或删除任何数据，
 * 无业务副作用，调用方无需事务。</p>
 *
 * <p>本步骤无业务失败场景（Spec REQ-006）：查询结果为空时仍返回 [客户限制信息]
 * 且三项输出保持空值，正常完成时 {@code succeed = true}、错误字段为 {@code null}；
 * 数据访问或运行环境异常按技术异常向上传播，不由本步骤转换为业务失败结论。</p>
 */
public interface IST111 {

    /**
     * 执行检查客户是否存在限制。
     *
     * @param input 步骤输入，必填业务入参 {@code clientNo}（客户号）
     * @return 步骤输出；执行正常完成（含查询结果为空）时 {@code succeed = true} 且
     *         {@code errorCode}／{@code errorMessage} 为 {@code null}，业务字段
     *         {@code resSeqNo}／{@code restraintType}／{@code restraintsStatus}
     *         承载回显记录的三项取值，查询结果为空时三者均为空值
     */
    ST111OutputBO execute(ST111InputBO input);
}
