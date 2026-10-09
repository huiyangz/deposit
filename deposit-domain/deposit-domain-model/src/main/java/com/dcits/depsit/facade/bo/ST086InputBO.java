package com.dcits.depsit.facade.bo;

import java.util.Date;

/**
 * ST086 设置账户开户日期 输入 BO。
 *
 * <p>承载「## 输入」表的唯一必填字段 {@code runDate}（核心运行日期），该值由调用方在同一次执行中
 * 直接提供，本步骤不因「来源实体」列为空而发起账户、产品、机构或系统日期表的数据访问。
 *
 * <p>{@code runDate} 是本步骤 [系统日期] 的唯一取值来源（见 Spec「### 系统日期的取值来源绑定」）；
 * 源需求未定义其取空（null）或缺失时的行为，本 BO 只按字段契约承载该值，不设默认值。
 */
public class ST086InputBO {

    /** 核心运行日期，即步骤描述中的 [系统日期]，类型 {@link java.util.Date}，必填 */
    private Date runDate;

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }
}
