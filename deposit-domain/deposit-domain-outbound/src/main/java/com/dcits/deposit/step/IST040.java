package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST040InputBO;
import com.dcits.deposit.facade.bo.ST040OutputBO;

/**
 * ST040 检查限额 步骤接口。
 */
public interface IST040 {

    /**
     * 执行检查限额步骤：根据限额场景编码获取限额控制值，检查限额累计金额/笔数是否超限，
     * 返回「超限」/「未超限」业务结论；本步无业务失败场景，正常完成返回 succeed=true。
     */
    ST040OutputBO execute(ST040InputBO input);
}
