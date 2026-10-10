package com.dcits.depsit.step;

import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.facade.bo.ST128InputBO;
import com.dcits.depsit.facade.bo.ST128OutputBO;
import com.dcits.depsit.facade.components.IFmBranchBcc;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.FmBranchEO;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST128 检查是否跨法人 步骤实现。
 *
 * <p>执行顺序：子步骤 1（按{账号}查【账户信息】取账户开立行行号 → 按其查【机构信息表】取账户法人）
 * → 子步骤 2（按{交易机构}查【机构信息表】取交易机构法人）→ 子步骤 3（比较两个法人得出检查结果）。</p>
 *
 * <p>业务失败仅「按{账号}查询【账户信息】查不到记录或查到多条记录」，返回错误码 ER0048（账户不存在）并短路结束本步骤，
 * 后续机构查询与比较不再执行。检查结果为「不通过」属正常业务结论，不设错误码。本步骤不产生实体写入，
 * 其余失败由技术异常向上传播。</p>
 */
@Service
public class ST128Pbc implements IST128 {

    /** 检查结果：通过（账户法人与交易机构法人一致）。 */
    private static final String CHECK_RESULT_PASS = "通过";

    /** 检查结果：不通过（账户法人与交易机构法人不一致）。 */
    private static final String CHECK_RESULT_FAIL = "不通过";

    /** 业务失败错误码：账户不存在（errorcodes.properties：ER0048=账户不存在）。 */
    private static final String ERROR_CODE_ACCT_NOT_EXIST = "ER0048";

    /** 业务失败错误信息：错误码::业务说明。 */
    private static final String ERROR_MESSAGE_ACCT_NOT_EXIST = "ER0048::账户不存在";

    /** 【账户信息】＝对公存款账户主表（RB_BUS_ACCT）数据服务接口。 */
    @Autowired
    private IRbBusAcctBcc rbBusAcctBcc;

    /** 【机构信息表】（FM_BRANCH）数据服务接口。 */
    @Autowired
    private IFmBranchBcc fmBranchBcc;

    @Override
    public ST128OutputBO execute(ST128InputBO input) {
        ST128OutputBO output = new ST128OutputBO();

        // 子步骤 1 前段：按{账号}查询【账户信息】，唯一命中一条记录时取其账户开立行行号
        RbBusAcctEO acctCondition = new RbBusAcctEO();
        acctCondition.setBaseAcctNo(input.getBaseAcctNo());
        List<RbBusAcctEO> acctList = rbBusAcctBcc.findByEo(acctCondition);
        if (acctList == null || acctList.size() != 1) {
            // 查不到记录或查到多条记录：业务失败，结束本步骤；后续机构查询与比较不再执行
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ACCT_NOT_EXIST);
            output.setErrorMessage(ERROR_MESSAGE_ACCT_NOT_EXIST);
            return output;
        }
        TranBranch acctBranch = acctList.get(0).getAcctBranch();

        // 子步骤 1 后段：按[账户开立行行号]查询【机构信息表】，取账户的法人
        FmBranchEO acctOrg = fmBranchBcc.findByBranch(acctBranch);
        String acctCompany = acctOrg.getCompany();

        // 子步骤 2：按{交易机构}查询【机构信息表】，取交易机构的法人
        FmBranchEO tranOrg = fmBranchBcc.findByBranch(input.getBranch());
        String tranCompany = tranOrg.getCompany();

        // 子步骤 3：比较两个法人，得出检查结果（“不通过”为正常业务结论，不设错误码、不写实体）
        output.setCheckResult(Objects.equals(acctCompany, tranCompany) ? CHECK_RESULT_PASS : CHECK_RESULT_FAIL);
        output.setSucceed(true);
        return output;
    }
}
