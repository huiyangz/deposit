package com.dcits.depsit.step;

import com.dcits.depsit.facade.bo.ST055InputBO;
import com.dcits.depsit.facade.bo.ST055OutputBO;

/**
 * ST055 检查机构币种交易权限 步骤接口。
 *
 * <p>以两个必填输入 {@code tranBranch}（交易机构号，{@code com.dcits.depsit.enums.TranBranch}）
 * 与 {@code tranCcy}（交易币种，{@code com.dcits.depsit.enums.Ccy}）执行检查：按交易机构查询
 * 【机构币种信息】得到 [机构币种列表]，判断交易币种是否属于该列表。</p>
 *
 * <p>本步骤为只读检查，不新增、修改或删除机构币种记录，不写账户或交易数据，
 * 也不调用其它业务组件步骤或跨组件客户端，因此调用方无需为其开启事务；
 * 技术异常按工程既有方式向上传播。</p>
 */
public interface IST055 {

    /**
     * 执行检查机构币种交易权限。
     *
     * @param input 两个必填输入：{@code tranBranch}（交易机构号，类型
     *              {@code com.dcits.depsit.enums.TranBranch}）与 {@code tranCcy}
     *              （交易币种，类型 {@code com.dcits.depsit.enums.Ccy}）
     * @return 步骤结果：{@code tranCcy} 属于 [机构币种列表] 时 {@code succeed = true}、
     *         {@code errorCode} 与 {@code errorMessage} 均为 {@code null}；
     *         不属于（含查询无匹配记录、列表为空）时 {@code succeed = false}、
     *         {@code errorCode = "ER0047"}
     */
    ST055OutputBO execute(ST055InputBO input);
}
