package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.RbBusAcctPurpose;

/**
 * DT001 根据核准类型设置账户状态 单元测试
 *
 * 用例来源：outputs/测试用例.md（DT001-TC001 ~ DT001-TC021）
 */
public class DT001Test {

    // 规则1.a：基本户+境内+企业标志是，预期返回新建(N)
    @Test
    public void test_01() {
        assertEquals(AcctStatus.N, DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_11001, "是", "境内"));
    }

    // 规则1.b：基本户+境内+企业标志否，预期返回预开户(I)
    @Test
    public void test_02() {
        assertEquals(AcctStatus.I, DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_11001, "否", "境内"));
    }

    // 规则1.c：基本户+境外+企业标志是，预期返回预开户(I)
    @Test
    public void test_03() {
        assertEquals(AcctStatus.I, DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_11001, "是", "境外"));
    }

    // 规则1.d：基本户+境外+企业标志否，预期返回新建(N)
    @Test
    public void test_04() {
        assertEquals(AcctStatus.N, DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_11001, "否", "境外"));
    }

    // 规则2：一般户，境内境外标志/企业标志为该分支不评估的样本值（境内/是），预期返回新建(N)
    @Test
    public void test_05() {
        assertEquals(AcctStatus.N, DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_11002, "是", "境内"));
    }

    // 规则3.1.a：专用户+预算单位专用存款户+境内+企业标志是，预期返回空值（null）
    @Test
    public void test_06() {
        assertNull(DT001.execute(
                RbBusAcctPurpose.VALUE_4, AcctNatureNo.VALUE_11004, "是", "境内"));
    }

    // 规则3.1.b：专用户+预算单位专用存款户+境内+企业标志否，预期返回预开户(I)
    @Test
    public void test_07() {
        assertEquals(AcctStatus.I, DT001.execute(
                RbBusAcctPurpose.VALUE_4, AcctNatureNo.VALUE_11004, "否", "境内"));
    }

    // 规则3.1.c：专用户+预算单位专用存款户+境外+企业标志是，预期返回空值（null）
    @Test
    public void test_08() {
        assertNull(DT001.execute(
                RbBusAcctPurpose.VALUE_4, AcctNatureNo.VALUE_11004, "是", "境外"));
    }

    // 规则3.1.d：专用户+预算单位专用存款户+境外+企业标志否，预期返回新建(N)
    @Test
    public void test_09() {
        assertEquals(AcctStatus.N, DT001.execute(
                RbBusAcctPurpose.VALUE_4, AcctNatureNo.VALUE_11004, "否", "境外"));
    }

    // 规则3.2：专用户+非预算单位专用存款户，境内境外标志/企业标志为该分支不评估的样本值（境内/否），预期返回新建(N)
    @Test
    public void test_10() {
        assertEquals(AcctStatus.N, DT001.execute(
                RbBusAcctPurpose.VALUE_3, AcctNatureNo.VALUE_11004, "否", "境内"));
    }

    // 规则3.3：专用户+其他用途枚举值（结算性），境内境外标志/企业标志为该分支不评估的样本值（境外/是），预期返回新建(N)
    @Test
    public void test_11() {
        assertEquals(AcctStatus.N, DT001.execute(
                RbBusAcctPurpose.VALUE_6, AcctNatureNo.VALUE_11004, "是", "境外"));
    }

    // 规则3.3：专用户+对公存款账户用途为null（非必填字段空值，落入否则行），样本值（境内/是），预期返回新建(N)
    @Test
    public void test_12() {
        assertEquals(AcctStatus.N, DT001.execute(
                null, AcctNatureNo.VALUE_11004, "是", "境内"));
    }

    // 规则4.a：临时户+境内+企业标志是，预期返回新建(N)
    @Test
    public void test_13() {
        assertEquals(AcctStatus.N, DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_11003, "是", "境内"));
    }

    // 规则4.b：临时户+境内+企业标志否，预期返回预开户(I)
    @Test
    public void test_14() {
        assertEquals(AcctStatus.I, DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_11003, "否", "境内"));
    }

    // 规则4.c：临时户+境外+企业标志是，预期返回空值（null）
    @Test
    public void test_15() {
        assertNull(DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_11003, "是", "境外"));
    }

    // 规则4.d：临时户+境外+企业标志否，预期返回新建(N)
    @Test
    public void test_16() {
        assertEquals(AcctStatus.N, DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_11003, "否", "境外"));
    }

    // 规则5.a：验资户+境内+企业标志是，预期返回新建(N)
    @Test
    public void test_17() {
        assertEquals(AcctStatus.N, DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_17, "是", "境内"));
    }

    // 规则5.b：验资户+境内+企业标志否（与临时户4.b同输入不同结果），预期返回新建(N)
    @Test
    public void test_18() {
        assertEquals(AcctStatus.N, DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_17, "否", "境内"));
    }

    // 规则5.c：验资户+境外+企业标志是，预期返回空值（null）
    @Test
    public void test_19() {
        assertNull(DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_17, "是", "境外"));
    }

    // 规则5.d：验资户+境外+企业标志否，预期返回新建(N)
    @Test
    public void test_20() {
        assertEquals(AcctStatus.N, DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_17, "否", "境外"));
    }

    // 规则6：账户属性为五类之外的其他枚举值（对公人民币定期存款账户），样本值（境内/否/无特殊用途），预期返回新建(N)
    @Test
    public void test_21() {
        assertEquals(AcctStatus.N, DT001.execute(
                RbBusAcctPurpose.VALUE_0, AcctNatureNo.VALUE_11005, "否", "境内"));
    }
}
