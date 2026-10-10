package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.AcctCcy;
import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.RbBusAcctPurpose;

/**
 * ST098 检查账户用途 输入 BO。
 *
 * <p>字段名、类型与「必填」标记照录 Spec「### 输入」表，并沿用表行序：{@code rbBusAcctPurpose}
 * （{@code com.dcits.depsit.enums.RbBusAcctPurpose}，非必填，[对公存款账户用途]）、
 * {@code acctCcy}（{@code com.dcits.depsit.enums.AcctCcy}，必填，[账户币种]）、
 * {@code apprLetterNo}（{@code java.lang.String}，非必填，[核准件编号]）、
 * {@code acctNatureNo}（{@code com.dcits.depsit.enums.AcctNatureNo}，非必填，[账户属性]）。</p>
 *
 * <p>三个枚举字段的取值取自各自绑定枚举类已定义的常量（「## 补充说明」给出的枚举类名），
 * 不以字符串编码替代枚举成员。</p>
 *
 * <p>「## 输入」表四行的「来源实体」列均为空，本 BO 仅为承载本次调用的四个值，不据此新增
 * 任何数据访问或外部调用；{@code rbBusAcctPurpose}、{@code apprLetterNo}、{@code acctNatureNo}
 * 的「为空」均是源需求明文承认的取值情形（子步骤 1、2、3d、4 分别以「为空」为条件或结果），
 * 故不为其兜底、不新增非空校验分支。{@code acctCcy} 标「必填」而其取空时的行为源需求未定义
 * （Spec「验收范围与明确不覆盖的事项」第 3 项），同样不为其臆造默认值或异常。</p>
 */
public class ST098InputBO {

    /** 对公存款账户用途 —— 步骤描述中的 {账户用途}，子步骤 1、2 的条件与子步骤 4／5／6 的判定取值 */
    private RbBusAcctPurpose rbBusAcctPurpose;

    /** 账户币种 —— 步骤描述中的 {币种}，子步骤 1、2 的条件取值（「人民币」对应 {@code AcctCcy.CNY}） */
    private AcctCcy acctCcy;

    /** 核准件编号 —— 步骤描述中的 {核准件编号}，子步骤 1 的检查对象（为空返回 ER0012） */
    private String apprLetterNo;

    /** 账户属性 —— 步骤描述中的 {账户属性}，子步骤 2 的检查对象与子步骤 3 的分派依据 */
    private AcctNatureNo acctNatureNo;

    public RbBusAcctPurpose getRbBusAcctPurpose() {
        return rbBusAcctPurpose;
    }

    public void setRbBusAcctPurpose(RbBusAcctPurpose rbBusAcctPurpose) {
        this.rbBusAcctPurpose = rbBusAcctPurpose;
    }

    public AcctCcy getAcctCcy() {
        return acctCcy;
    }

    public void setAcctCcy(AcctCcy acctCcy) {
        this.acctCcy = acctCcy;
    }

    public String getApprLetterNo() {
        return apprLetterNo;
    }

    public void setApprLetterNo(String apprLetterNo) {
        this.apprLetterNo = apprLetterNo;
    }

    public AcctNatureNo getAcctNatureNo() {
        return acctNatureNo;
    }

    public void setAcctNatureNo(AcctNatureNo acctNatureNo) {
        this.acctNatureNo = acctNatureNo;
    }
}
