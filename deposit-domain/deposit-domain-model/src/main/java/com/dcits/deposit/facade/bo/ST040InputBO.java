package com.dcits.deposit.facade.bo;

import java.math.BigDecimal;

/**
 * ST040 检查限额 输入。
 */
public class ST040InputBO {

    /** 限额场景编码（必填） */
    private String limitSceneNo;

    /** 限额累计金额（必填） */
    private BigDecimal limitSumAmt;

    /** 限额累计笔数（必填） */
    // FIXME 业务项:ST040/检查限额 - 问题大类:业务 - 问题分类:缺少必要输入/输出 - 问题描述:限额累计笔数字段名未确定（Spec 待确认事项 TBD-1）：需求「输入」表字段名列原文为「否」，工程 RB_LIMIT_SUM_INFO 列名与实体字段名亦为「否」（getter get否()），与业务语义不符，疑似如 limitSumNum 的编码名被破坏 - 影响:本 BO 暂以 limitSumNum 作为占位字段名，实际字段名确认后需同步替换实现与测试中的绑定 - 待确认:限额累计笔数的实际字段名
    private Integer limitSumNum;

    public String getLimitSceneNo() {
        return limitSceneNo;
    }

    public void setLimitSceneNo(String limitSceneNo) {
        this.limitSceneNo = limitSceneNo;
    }

    public BigDecimal getLimitSumAmt() {
        return limitSumAmt;
    }

    public void setLimitSumAmt(BigDecimal limitSumAmt) {
        this.limitSumAmt = limitSumAmt;
    }

    public Integer getLimitSumNum() {
        return limitSumNum;
    }

    public void setLimitSumNum(Integer limitSumNum) {
        this.limitSumNum = limitSumNum;
    }
}
