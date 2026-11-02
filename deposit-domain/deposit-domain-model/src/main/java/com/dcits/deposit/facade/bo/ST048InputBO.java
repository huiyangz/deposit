package com.dcits.deposit.facade.bo;

import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranType;

/**
 * ST048 检查限制豁免 步骤输入。
 *
 * <p>字段对应正式 Spec「输入」表五个必填输入：渠道类型、账户限制类型、交易类型、摘要码、产品类型。</p>
 */
public class ST048InputBO {

    /** 渠道类型 */
    private SourceType sourceType;

    /** 账户限制类型 */
    private RestraintType restraintType;

    /** 交易类型 */
    private TranType tranType;

    /** 摘要码 */
    private String narrativeCode;

                                                                                                                                                                                                               
    /** 产品类型 */
                                                       
    private String productType;

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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
