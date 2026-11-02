package com.dcits.deposit.step;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcits.deposit.facade.bo.ST046InputBO;
import com.dcits.deposit.facade.bo.ST046OutputBO;
import com.dcits.deposit.facade.components.IRbLimitSumInfoBcc;
import com.dcits.deposit.facade.eo.RbLimitSumInfoEO;

/**
 * ST046 更新累计限额 步骤实现。
 *
 * <p>触发条件为[限额检查结果]等于"未超限"且（[限额累计金额]大于0 或 [限额累计笔数]大于0）；
 * 条件成立时经 {@link IRbLimitSumInfoBcc} 按主键更新【限额累计信息表】记录的累计限额字段
 * （LIMIT_SUM_AMT）为[限额累计金额]，仅变更累计限额字段；条件不成立时不执行更新，正常提前结束。
 * 需求未声明本步骤业务失败分支与错误码，正常完成时 succeed=true、错误字段为 null。</p>
 *
 * <p>更新记录定位键（{@link #execute(ST046InputBO)} 中 {账号}→CHECK_OBJ_VAL 映射）与
 * [限额检查结果]"未超限"物理编码见代码内 FIXME（Spec 待确认事项 1、3），确认前分别按
 * checkObjVal=baseAcctNo、业务字面量"未超限"处理。</p>
 */
@Service
public class ST046Pbc implements IST046 {

    @Autowired
    private IRbLimitSumInfoBcc rbLimitSumInfoBcc;

    @Override
    @Transactional
    public ST046OutputBO execute(ST046InputBO input) {
        ST046OutputBO result = new ST046OutputBO();
        // FIXME 业务项:ST046/更新累计限额 - 问题大类:业务 - 问题分类:枚举业务定义缺失 - 问题描述:[限额检查结果]="未超限"的物理编码/常量未确认（Spec 待确认事项 3） - 影响:当前以需求业务字面量"未超限"做等于判断，物理编码确认后可能需改用已确认常量 - 待确认:系统判断"未超限"的实际物理取值
        boolean limitChecked = "未超限".equals(input.get限额检查结果());
        boolean amountPositive = input.getLimitSumAmt() != null && input.getLimitSumAmt().compareTo(BigDecimal.ZERO) > 0;
        boolean countPositive = input.get否() != null && input.get否() > 0;
        // 触发条件：限额检查未超限且（累计金额>0 或 累计笔数>0）时执行更新
        if (limitChecked && (amountPositive || countPositive)) {
            // FIXME 业务项:ST046/更新累计限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:RB_LIMIT_SUM_INFO 无账号列，主键为(CHECK_OBJ_VAL,LIMIT_SCENE_NO)；{账号}(baseAcctNo)如何定位更新记录未明确——是否映射为 CHECK_OBJ_VAL、limitSceneNo/clientNo 是否参与定位、是否按主键更新（Spec 待确认事项 1） - 影响:当前按 checkObjVal=baseAcctNo、按主键(CHECK_OBJ_VAL,LIMIT_SCENE_NO)选择性更新假设实现，定位键可能错误 - 待确认:账号与 CHECK_OBJ_VAL 的映射、完整定位键及更新实现方式
            RbLimitSumInfoEO eo = new RbLimitSumInfoEO();
            eo.setCheckObjVal(input.getBaseAcctNo());
            eo.setLimitSceneNo(input.getLimitSceneNo());
            eo.setLimitSumAmt(input.getLimitSumAmt());
            // 按主键选择性更新：仅更新入参非空字段，需求仅声明累计限额字段（LIMIT_SUM_AMT）的变更
            rbLimitSumInfoBcc.modifyByPrimaryKeySelective(eo);
        }
        // 正常完成或正常提前结束：显式成功，错误码与错误信息保持 null
        result.setSucceed(true);
        return result;
    }
}
