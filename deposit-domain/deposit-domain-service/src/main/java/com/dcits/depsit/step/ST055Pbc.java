package com.dcits.depsit.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.facade.bo.ST055InputBO;
import com.dcits.depsit.facade.bo.ST055OutputBO;
import com.dcits.depsit.facade.components.IFmBranchCcyBcc;
import com.dcits.depsit.facade.eo.FmBranchCcyEO;

/**
 * ST055 检查机构币种交易权限 步骤实现。
 *
 * <p>按正式 Spec「## 步骤描述」的两步依次执行，无子步骤引用、无条件跳转、无循环：</p>
 * <ol>
 *   <li>获取机构币种列表（REQ-002）：根据 {交易机构}（入参 {@code tranBranch}）查询
 *       【机构币种信息】（实体表 {@code FM_BRANCH_CCY}）获取 [机构币种列表]。
 *       查询条件为归属机构号 = {@code tranBranch}，不含币种；匹配记录的币种（{@code ccy}）
 *       构成 [机构币种列表]。该查询为只读，不写库。</li>
 *   <li>检查交易币种（REQ-003、REQ-004）：若 {交易币种}（入参 {@code tranCcy}）在
 *       [机构币种列表] 范围内，则返回检查结果为“通过”（{@code succeed = true}）；
 *       否则返回错误码 {@code "ER0047"}。两个分支互斥且穷尽，查询无匹配记录时列表为空，
 *       任一 {@code tranCcy} 均不属于该列表，走 {@code "ER0047"} 分支。</li>
 * </ol>
 *
 * <p>本步骤为只读检查，不新增、修改或删除机构币种记录，也不写账户或交易数据，
 * 故不声明事务，也不捕获或包装技术异常（查询调用本身失败的语义由正式 Spec
 * 「## 验收范围与明确不覆盖的事项」明确不作规定，交由上层统一处理）。
 * 源需求未定义输入为空（null）时的处理，本实现不为其制造分支。</p>
 */
@Service
public class ST055Pbc implements IST055 {

    /** 错误码：当前交易机构不支持当前币种交易（{@code errorcodes.properties} 第 47 行已登记） */
    private static final String ERROR_CODE_CCY_NOT_SUPPORTED = "ER0047";

    /** 错误信息：已确认错误码资料中的业务说明，按「错误码::业务说明」格式组装 */
    private static final String ERROR_MESSAGE_CCY_NOT_SUPPORTED = "ER0047::当前交易机构不支持当前币种交易";

    /** 【机构币种信息】的数据服务（本地实体只读读取入口） */
    @Autowired
    private IFmBranchCcyBcc iFmBranchCcyBcc;

    @Override
    public ST055OutputBO execute(ST055InputBO input) {
        ST055OutputBO output = new ST055OutputBO();

        // 步骤 1 获取机构币种列表（REQ-002）：以归属机构号 = tranBranch 为查询条件查询【机构币种信息】，
        // 查询条件不含币种，避免把待检查的币种当作查询条件而使后续成员判定失去意义。
        FmBranchCcyEO queryEo = new FmBranchCcyEO();
        queryEo.setBranch(input.getTranBranch());
        List<FmBranchCcyEO> branchCcyRecords = iFmBranchCcyBcc.findByEo(queryEo);

        // [机构币种列表]：匹配记录的币种构成的集合，元素类型 Ccy；查询无匹配记录时为空集
        List<Ccy> branchCcyList = new ArrayList<>();
        if (branchCcyRecords != null) {
            for (FmBranchCcyEO record : branchCcyRecords) {
                branchCcyList.add(record.getCcy());
            }
        }

        // 步骤 2 检查交易币种（REQ-003、REQ-004）：{交易币种} 在 [机构币种列表] 范围内即属于该列表。
        if (!branchCcyList.contains(input.getTranCcy())) {
            // “否则”分支（REQ-004）：业务失败，返回错误码 ER0047，不返回检查结果“通过”
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_CCY_NOT_SUPPORTED);
            output.setErrorMessage(ERROR_MESSAGE_CCY_NOT_SUPPORTED);
            return output;
        }

        // “若”分支（REQ-003）：检查结果“通过”，以成功状态表达，错误码与错误信息保持为 null
        output.setSucceed(true);
        return output;
    }
}
