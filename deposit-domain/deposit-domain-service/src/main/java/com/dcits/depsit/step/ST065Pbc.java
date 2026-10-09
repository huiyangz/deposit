package com.dcits.depsit.step;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.dcits.depsit.facade.bo.ST065InputBO;
import com.dcits.depsit.facade.bo.ST065OutputBO;
import com.dcits.depsit.facade.components.IRbBusinessParameterBcc;
import com.dcits.depsit.facade.eo.RbBusinessParameterEO;

import jakarta.annotation.Resource;

/**
 * ST065 检查分位金额 步骤实现（检查类）。
 *
 * <p>子步骤1 取数：按预设参数名称 {@code LIMIT_CENT_AMT}（主键）查【存款业务参数表】一次，
 * 取得该参数的参数值，作为「分位处理金额分位上限」，同时作为输出 paraValue 的取值（同一次取数，不重复取数）。</p>
 *
 * <p>子步骤2 判定：以「分位金额 小于等于 分位处理金额分位上限」为判据按数值大小比较
 * （{@link BigDecimal#compareTo} 语义，标度与尾随零不改变结果），
 * 成立则检查结果为「通过」（{@code succeed=true}，错误字段为 null）；
 * 否则返回错误码 {@code ER0069} 并终止，无后续步骤与数据写入。</p>
 *
 * <p>源需求未定义「分位金额」为空、参数记录不存在或参数值不可解析时的分支，本实现不制造失败分支、
 * 不设默认值；此类技术异常交由上层统一处理。</p>
 */
@Service
public class ST065Pbc implements IST065 {

    /** 子步骤1 取数的查询键：预设参数名称（源需求原文给出的规范常量） */
    private static final String PARA_KEY_LIMIT_CENT_AMT = "LIMIT_CENT_AMT";

    /** 子步骤2 失败分支的错误码：分位金额超出「分位处理金额分位上限」（Spec REQ-004 原文） */
    private static final String ERROR_CODE_ER0069 = "ER0069";

    /** 子步骤2 失败分支的错误信息，格式「错误码::业务说明」，文案取自 errorcodes.properties 第 69 行 */
    private static final String ERROR_MESSAGE_ER0069 = "ER0069::分位金额超过“分位处理金额分位上限”";

    /** 预设参数（存款业务参数表）只读数据服务 */
    @Resource
    private IRbBusinessParameterBcc rbBusinessParameterBcc;

    @Override
    public ST065OutputBO execute(ST065InputBO input) {
        ST065OutputBO output = new ST065OutputBO();

        // 子步骤1 获取分位处理金额分位上限：按预设参数 LIMIT_CENT_AMT（主键）一次只读取数，取出参数值
        RbBusinessParameterEO parameter = rbBusinessParameterBcc.findByPrimaryKey(PARA_KEY_LIMIT_CENT_AMT);
        String limitCentAmount = parameter.getParaValue();
        // 取数所得参数值即分位处理金额分位上限，同时作为输出 paraValue 的取值
        output.setParaValue(limitCentAmount);

        // 子步骤2 检查分位处理金额分位上限：分位金额 小于等于 上限（按数值大小比较）则检查结果为「通过」
        if (input.get分位金额().compareTo(new BigDecimal(limitCentAmount)) <= 0) {
            output.setSucceed(true);
        } else {
            // 否则返回错误码 ER0069，且不返回检查结果「通过」
            output.setSucceed(false);
            output.setErrorCode(ERROR_CODE_ER0069);
            output.setErrorMessage(ERROR_MESSAGE_ER0069);
        }
        return output;
    }
}
