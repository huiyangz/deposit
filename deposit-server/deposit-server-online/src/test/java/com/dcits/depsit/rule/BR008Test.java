package com.dcits.depsit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.ClientType;
import com.dcits.depsit.enums.TaxResidentFlag;

/**
 * BR008 设置自贸区种类 单元测试。
 *
 * <p>用例来源：outputs/测试用例.md（BR008-TC001 ~ BR008-TC011），
 * 期望值取自正式 Spec。分支 a～e 未引用的入参取用例给定的样本值以满足必填，不作为断言依据；
 * 兜底分支 f 的"为空"未细化 null 与空串的表示（Spec 不覆盖第 5 条），故按用例要求断言取值未设置（null 或空串）。</p>
 */
class BR008Test {

    /** 断言返回值未设置自贸区种类：不取任何已定义的账户属性码值。 */
    private static void assertAcctNatureNotSet(String actual) {
        assertTrue(actual == null || actual.isEmpty(),
                "分支 f 应不设置自贸区种类，实际返回值：" + actual);
    }

    /** REQ-001-S01 / 分支 a：个人且中国税收居民，返回 FTI 的码值 "3605"。 */
    @Test
    void test_01() {
        String actual = BR008.execute("Y", TaxResidentFlag.VALUE_1, ClientType.VALUE_100, "Y");
        assertEquals(AcctNatureNo.VALUE_3605.getValue(), actual);
    }

    /** REQ-001-S02 / 分支 a：个人且既是中国税收居民又是其他国家（地区）税收居民，返回 "3605"。 */
    @Test
    void test_02() {
        String actual = BR008.execute("Y", TaxResidentFlag.VALUE_3, ClientType.VALUE_100, "Y");
        assertEquals(AcctNatureNo.VALUE_3605.getValue(), actual);
    }

    /** REQ-001-S03 / 分支 b：个人且非中国税收居民，返回 FTF 的码值 "3606"。 */
    @Test
    void test_03() {
        String actual = BR008.execute("Y", TaxResidentFlag.VALUE_2, ClientType.VALUE_100, "Y");
        assertEquals(AcctNatureNo.VALUE_3606.getValue(), actual);
    }

    /** REQ-001-S04：个人分支判定条件不含境内境外标志，inlandOffshore 为 "N" 时仍返回 "3605"。 */
    @Test
    void test_04() {
        String actual = BR008.execute("Y", TaxResidentFlag.VALUE_1, ClientType.VALUE_100, "N");
        assertEquals(AcctNatureNo.VALUE_3605.getValue(), actual);
    }

    /** REQ-002-S01 / 分支 c：对公且境内，返回 FTE 的码值 "3603"。 */
    @Test
    void test_05() {
        String actual = BR008.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_200, "Y");
        assertEquals(AcctNatureNo.VALUE_3603.getValue(), actual);
    }

    /** REQ-002-S02 / 分支 d：对公且境外，返回 FTN 的码值 "3604"。 */
    @Test
    void test_06() {
        String actual = BR008.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_200, "N");
        assertEquals(AcctNatureNo.VALUE_3604.getValue(), actual);
    }

    /** REQ-002-S03：对公分支判定条件不含税收居民标识，taxResidentFlag 为 "2" 时仍返回 "3603"。 */
    @Test
    void test_07() {
        String actual = BR008.execute("N", TaxResidentFlag.VALUE_2, ClientType.VALUE_200, "Y");
        assertEquals(AcctNatureNo.VALUE_3603.getValue(), actual);
    }

    /** REQ-003-S01 / 分支 e：同业且境外，返回 FTU 的码值 "3607"。 */
    @Test
    void test_08() {
        String actual = BR008.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_300, "N");
        assertEquals(AcctNatureNo.VALUE_3607.getValue(), actual);
    }

    /** REQ-004-S01 / 分支 f：非个人且客户类型 100，a～e 均不满足，不设置自贸区种类。 */
    @Test
    void test_09() {
        String actual = BR008.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_100, "Y");
        assertAcctNatureNotSet(actual);
    }

    /** REQ-004-S02 / 分支 f：同业且境内，不满足分支 e，a～e 均不满足，不设置自贸区种类。 */
    @Test
    void test_10() {
        String actual = BR008.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_300, "Y");
        assertAcctNatureNotSet(actual);
    }

    /**
     * REQ-001 判别性用例：个人分支仅由对私客户标志与税收居民标识判定，clientType 不参与判定。
     * isIndividual="Y"、clientType="300"（非个人语义值）、inlandOffshore="Y"（分支 e 要求 "N"）时仍返回 "3605"；
     * 与 test_10 的入参仅差 isIndividual 一个字段，可区分"个人分支被额外绑定 clientType"的错误实现。
     */
    @Test
    void test_11() {
        String actual = BR008.execute("Y", TaxResidentFlag.VALUE_1, ClientType.VALUE_300, "Y");
        assertEquals(AcctNatureNo.VALUE_3605.getValue(), actual);
    }
}
