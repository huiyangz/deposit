package com.dcits.depsit.facade.bo;

import java.math.BigDecimal;

/**
 * ST065 检查分位金额 输入 BO。
 *
 * <p>字段取自正式 Spec「## 输入」表（2 个入参，字段名与类型照录源需求）：
 * 「分位金额」（java.math.BigDecimal，必填）与「分位处理金额分位上限」（java.lang.String，必填）。</p>
 *
 * <p>「分位处理金额分位上限」在输入表与步骤描述1 中的两种出现形式指向同一取值：
 * 该字段即步骤1 按预设参数 LIMIT_CENT_AMT 取数结果在步骤2 判定中的引用，不是第 3 个重复入参。
 * 源需求「## 输入」表「来源实体」列为空，本 BO 不据此增加取数动作。</p>
 */
public class ST065InputBO {

    /** 分位金额（必填，java.math.BigDecimal）：判定主体，步骤2 判定的左操作数 */
    private BigDecimal 分位金额;

    /** 分位处理金额分位上限（必填，java.lang.String）：系统配置的分位上限，由步骤1 按预设参数 LIMIT_CENT_AMT 取得，步骤2 判定的右操作数（比较上界） */
    private String 分位处理金额分位上限;

    public BigDecimal get分位金额() {
        return 分位金额;
    }

    public void set分位金额(BigDecimal 分位金额) {
        this.分位金额 = 分位金额;
    }

    public String get分位处理金额分位上限() {
        return 分位处理金额分位上限;
    }

    public void set分位处理金额分位上限(String 分位处理金额分位上限) {
        this.分位处理金额分位上限 = 分位处理金额分位上限;
    }
}
