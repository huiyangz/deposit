package com.dcits.deposit.step;

import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST018InputBO;
import com.dcits.deposit.facade.bo.ST018OutputBO;
import com.dcits.deposit.facade.components.IFmBranchBcc;
import com.dcits.deposit.facade.components.IRbOdBranchInfoBcc;
import com.dcits.deposit.facade.eo.FmBranchEO;
import com.dcits.deposit.facade.eo.RbOdBranchInfoEO;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ST018 检查分行法人透支额度。
 *
 * <p>子步骤：</p>
 * <ol>
 *   <li>subStep1 按交易机构号查询机构信息表 FM_BRANCH，获取归属机构号（分行机构号）；</li>
 *   <li>subStep2 按分行机构号查询机构法人透支额度信息表 RB_OD_BRANCH_INFO，获取已使用额度与总额度；</li>
 *   <li>subStep3 已使用额度不超过总额度则成功，并跳转《检查法透账户支取限制》；否则失败并返回错误码 ER0062。</li>
 * </ol>
 */
@Service
public class ST018Pbc implements IST018 {

    /** 错误码：分行法人透支额度超限 */
    private static final String ERROR_CODE = "ER0062";
    private static final String ERROR_CODE_MESSAGE = "分行法人透支额度超限";

    @Autowired
    private IFmBranchBcc fmBranchBcc;

    @Autowired
    private IRbOdBranchInfoBcc rbOdBranchInfoBcc;

    @Override
    public ST018OutputBO execute(ST018InputBO input) {
        ST018OutputBO output = new ST018OutputBO();
        TranBranch tranBranch = input.getTranBranch();

        // FIXME 业务项:ST018 检查分行法人透支额度 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:TBD-5 必填输入 tranBranch 缺失或无效取值时返回行为未定义 - 影响:当前直接按 null 参与后续查询 - 待确认:必填校验不通过时应返回何种结果与错误码
        if (tranBranch == null) {
            return output;
        }

        // subStep1 按交易机构号查询机构信息表 FM_BRANCH，输出归属机构号（分行机构号）
        FmBranchEO fmBranch = fmBranchBcc.findByBranch(tranBranch);
        // FIXME 业务项:ST018 检查分行法人透支额度 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:TBD-2 机构信息查询无记录时返回行为未定义 - 影响:当前返回 succeed=false 且错误字段为空 - 待确认:查询无记录时应返回何种结果与错误码
        if (fmBranch == null) {
            return output;
        }
        TranBranch branch = fmBranch.getBranch();
        output.setBranch(branch);

        // subStep2 按分行机构号查询机构法人透支额度信息表 RB_OD_BRANCH_INFO，输出已使用额度与总额度
        RbOdBranchInfoEO rbOdBranchInfo = rbOdBranchInfoBcc.findByBranch(branch);
        // FIXME 业务项:ST018 检查分行法人透支额度 - 问题大类:业务 - 问题分类:缺少失败处理说明 - 问题描述:TBD-3 分行法人透支额度查询无记录时返回行为未定义 - 影响:当前返回 succeed=false 且错误字段为空 - 待确认:查询无记录时应返回何种结果与错误码
        if (rbOdBranchInfo == null) {
            return output;
        }
        BigDecimal usedAmt = rbOdBranchInfo.getUsedAmt();
        BigDecimal totalLimit = rbOdBranchInfo.getTotalLimit();
        // FIXME 业务项:ST018 检查分行法人透支额度 - 问题大类:业务 - 问题分类:逻辑运算歧义 - 问题描述:TBD-4 已使用额度或总额度为 null 时额度比较结果未定义 - 影响:当前直接返回 succeed=false 且错误字段为空，不进行额度比较 - 待确认:空值应如何处理及返回何种结果
        if (usedAmt == null || totalLimit == null) {
            return output;
        }
        output.setUsedAmt(usedAmt);
        output.setTotalLimit(totalLimit);

        // subStep3 已使用额度不超过总额度则成功，否则业务失败返回 ER0062
        if (usedAmt.compareTo(totalLimit) <= 0) {
            // 成功，跳转《检查法透账户支取限制》
            output.setSucceed(true);
        } else {
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE);
            output.setErrorMessage(ERROR_CODE + "::" + ERROR_CODE_MESSAGE);
        }
        return output;
    }
}
