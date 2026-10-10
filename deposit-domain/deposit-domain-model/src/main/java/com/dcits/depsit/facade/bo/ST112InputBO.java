package com.dcits.depsit.facade.bo;

import com.dcits.depsit.enums.RestraintType;
import com.dcits.depsit.enums.SourceType;
import com.dcits.depsit.enums.TranType;

/**
 * ST112 检查限制豁免 入参。
 *
 * <p>字段与类型照录正式 Spec「## 输入」表的 5 个必填字段；步骤描述中的
 * {@code {渠道类型}}、{@code {账户限制类型}}、{@code {交易类型}}、{@code {摘要码}}、
 * {@code {产品类型}} 分别绑定 sourceType、restraintType、tranType、narrativeCode、prodType。
 * 源需求「来源实体」列为空，本步骤不推断其上游取得方式。</p>
 */
public class ST112InputBO {

    /** 渠道类型（子步骤 1 匹配【渠道类型定义表】的「渠道」） */
    private SourceType sourceType;

    /** 账户限制类型（子步骤 2 查询【限制控制明细表】的查询键） */
    private RestraintType restraintType;

    /** 交易类型（子步骤 4／5「同时匹配」判据之一） */
    private TranType tranType;

    /** 摘要码（子步骤 4／5「同时匹配」判据之一） */
    private String narrativeCode;

    /** 产品类型（子步骤 4／5「同时匹配」判据之一，对应明细记录的产品编号） */
    private String prodType;

    public SourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public RestraintType getRestraintType() {
        return restraintType;
    }

    public void setRestraintType(RestraintType restraintType) {
        this.restraintType = restraintType;
    }

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }

    public String getNarrativeCode() {
        return narrativeCode;
    }

    public void setNarrativeCode(String narrativeCode) {
        this.narrativeCode = narrativeCode;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }
}
