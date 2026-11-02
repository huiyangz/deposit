package com.dcits.deposit.step;

import com.dcits.deposit.facade.bo.ST025InputBO;
import com.dcits.deposit.facade.bo.ST025OutputBO;

/**
 * ST025 检查法透账户支取限制 步骤接口。
 */
public interface IST025 {

    /**
     * 执行「检查法透账户支取限制」步骤。
     *
     * <p>以必填账号（baseAcctNo）为输入，依次调用组件内步骤「检查是否存在不收不付限制」ST058、
     * 「检查是否存在止付限制」ST055、「检查有权机关冻结限制」ST050 取得三个标志并按序判定：
     * 任一标志等于「是」时按对应错误码（ER0059 / ER0065 / ER0066）短路失败；三个标志均不为「是」
     * 时返回检查结果「通过」并正常完成。</p>
     *
     * @param input 输入 BO（baseAcctNo 账号，必填）
     * @return 输出 BO（继承 {@link com.dcits.common.step.StepResult}）
     */
    ST025OutputBO execute(ST025InputBO input);
}
