package com.dcits.depsit.step;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.depsit.enums.Status;
import com.dcits.depsit.facade.bo.ST127InputBO;
import com.dcits.depsit.facade.bo.ST127OutputBO;
import com.dcits.depsit.facade.components.IRbRestraintTypeBcc;
import com.dcits.depsit.facade.eo.RbRestraintTypeEO;

/**
 * ST127 检查限制类型（检查类步骤）。
 *
 * <p>步骤1 以 {限制类型}（{@code restraintType}）为查询键查询【限制类型定义表】取得
 * [限制类型信息]（存款限制类型表 RB_RESTRAINT_TYPE，按主键查询至多返回一条）；步骤2 判定其
 * 存在性，为空时返回检查结果「不通过」并短路；步骤3 判定其 $状态$，为「A-有效」时返回
 * 「通过」，其余取值（含无值）返回「不通过」。</p>
 *
 * <p>检查结果由返回对象的 {@code succeed} 承载（true＝「通过」、false＝「不通过」），
 * 不以错误码表达；「## 失败处理」声明本步骤无业务失败场景，故各分支均不设置错误码。
 * 本步骤只读，不写库、不产生数据变更，也不调用其它步骤、规则或外部服务。</p>
 */
@Service
public class ST127Pbc implements IST127 {

    /** 存款限制类型表数据服务接口：步骤1 的取数来源（只读查询） */
    @Autowired
    private IRbRestraintTypeBcc rbRestraintTypeBcc;

    @Override
    public ST127OutputBO execute(ST127InputBO input) {
        ST127OutputBO output = new ST127OutputBO();

        // 步骤1 获取限制类型：根据{限制类型}查询【限制类型定义表】获取[限制类型信息]
        RbRestraintTypeEO restraintTypeInfo = rbRestraintTypeBcc.findByRestraintType(input.getRestraintType());

        // 步骤2 检查限制类型存在性：若[限制类型信息]为空，则返回检查结果为"不通过"
        if (restraintTypeInfo == null) {
            output.setSucceed(false);
            return output;
        }

        // 步骤3 检查限制类型状态：若[限制类型信息]的$状态$为"A-有效"，则返回检查结果为"通过"，
        // 否则返回"不通过"（「否则」为穷尽分支，含无值）
        output.setSucceed(Status.A.equals(restraintTypeInfo.getStatus()));
        return output;
    }
}
