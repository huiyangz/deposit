package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST107InputBO;
import com.dcits.depsit.facade.bo.ST107OutputBO;

/**
 * ST107 匹配限额场景 步骤接口。
 *
 * <p>本步骤只读【限额规则关系表】与【限额场景定义表】两张表，不新增、修改或删除任何记录，
 * 不调用其它步骤、规则或外部服务，也不产出错误码（源需求「## 失败处理」声明本步骤无业务失败场景），
 * 因此<b>不要求调用方提供事务</b>。
 */
public interface IST107 {

    /**
     * 执行「匹配限额场景」步骤。
     *
     * @param input 步骤输入，仅含唯一入参「因子名称」
     * @return 步骤输出；{@code matchResult} 恒为「已匹配到限额场景」或「未匹配到限额场景」之一，
     *         命中时另产出 {@code limitSceneNo} 与 {@code validFlag}
     */
    ST107OutputBO execute(ST107InputBO input);
}
