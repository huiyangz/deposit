package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.Ccy;
import com.dcits.depsit.enums.TranBranch;

/**
 * ST055 检查机构币种交易权限 输入 BO。
 *
 * <p>承载源需求「## 输入」表的两个必填字段：{@code tranBranch}（交易机构号，类型
 * {@link TranBranch}）与 {@code tranCcy}（交易币种，类型 {@link Ccy}），按该行序接收。
 * 两个字段的「来源实体」列均为空，由调用方在同一次检查中直接提供，本步骤不因该列为空
 * 而要求调用方额外提供机构币种数据。</p>
 *
 * <p>两个字段均标「必填」；源需求未定义其为空（null）或缺失时的处理，本 BO 只按字段契约
 * 承载取值，不设默认值、不做取值域之外的校验。</p>
 */
public class ST055InputBO {

    /** 交易机构号，类型 {@link TranBranch}，必填；对应源需求输入表「交易机构号」 */
    private TranBranch tranBranch;

    /** 交易币种，类型 {@link Ccy}，必填；对应源需求输入表「交易币种」 */
    private Ccy tranCcy;

    public TranBranch getTranBranch() {
        return tranBranch;
    }

    public void setTranBranch(TranBranch tranBranch) {
        this.tranBranch = tranBranch;
    }

    public Ccy getTranCcy() {
        return tranCcy;
    }

    public void setTranCcy(Ccy tranCcy) {
        this.tranCcy = tranCcy;
    }
}
