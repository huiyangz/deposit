package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.TaxResidentFlag;
import org.junit.jupiter.api.Test;

/**
 * BR006 设置自贸区种类 单元测试
 *
 * 用例来源：outputs/测试用例.md / 测试用例.json（BR006-TC001 ~ BR006-TC008），期望值来自门禁通过版 SPEC。
 */
class BR006Test {

    // BR006-TC001：对私个人客户，税收居民标志=1（中国税收居民），命中 SPEC 分支 a，预期返回 "FTI"
    @Test
    void test_01() {
        String acctNatureNo = BR006.execute(
                "Y",
                TaxResidentFlag.VALUE_1,
                ClientType.VALUE_100,
                "Y");
        assertEquals("FTI", acctNatureNo);
    }

    // BR006-TC002：对私个人客户，税收居民标志=3（既是中国税收居民又是其他国家（地区）税收居民），命中 SPEC 分支 a 的另一取值，预期返回 "FTI"
    @Test
    void test_02() {
        String acctNatureNo = BR006.execute(
                "Y",
                TaxResidentFlag.VALUE_3,
                ClientType.VALUE_100,
                "Y");
        assertEquals("FTI", acctNatureNo);
    }

    // BR006-TC003：对私个人客户，税收居民标志=2（非中国税收居民），分支 a 税收居民条件不通过，命中 SPEC 分支 b，预期返回 "FTF"
    @Test
    void test_03() {
        String acctNatureNo = BR006.execute(
                "Y",
                TaxResidentFlag.VALUE_2,
                ClientType.VALUE_100,
                "Y");
        assertEquals("FTF", acctNatureNo);
    }

    // BR006-TC004：对公客户境内，对私客户标志非 "Y" 使分支 a 不命中（即使税收居民标志=1），命中 SPEC 分支 c，预期返回 "FTE"
    @Test
    void test_04() {
        String acctNatureNo = BR006.execute(
                "N",
                TaxResidentFlag.VALUE_1,
                ClientType.VALUE_200,
                "Y");
        assertEquals("FTE", acctNatureNo);
    }

    // BR006-TC005：对公客户境外，命中 SPEC 分支 d（同时构成分支 c 的境内境外条件否定），预期返回 "FTN"
    @Test
    void test_05() {
        String acctNatureNo = BR006.execute(
                "N",
                TaxResidentFlag.VALUE_1,
                ClientType.VALUE_200,
                "N");
        assertEquals("FTN", acctNatureNo);
    }

    // BR006-TC006：同业客户境外，命中 SPEC 分支 e（同时构成分支 d 的客户类型条件否定），预期返回 "FTU"
    @Test
    void test_06() {
        String acctNatureNo = BR006.execute(
                "N",
                TaxResidentFlag.VALUE_1,
                ClientType.VALUE_300,
                "N");
        assertEquals("FTU", acctNatureNo);
    }

    // BR006-TC007：对私客户标志="N" 的客户类型 100 客户，税收居民标志=2，分支 a 的对私客户标志条件不通过，命中 SPEC 分支 b，预期返回 "FTF"
    @Test
    void test_07() {
        String acctNatureNo = BR006.execute(
                "N",
                TaxResidentFlag.VALUE_2,
                ClientType.VALUE_100,
                "Y");
        assertEquals("FTF", acctNatureNo);
    }

    // BR006-TC008：对公客户境内且税收居民标志=3，验证分支 a 的「或者」边界：对私客户标志非 "Y" 时即使税收居民标志=3 也不命中分支 a，命中 SPEC 分支 c，预期返回 "FTE"
    @Test
    void test_08() {
        String acctNatureNo = BR006.execute(
                "N",
                TaxResidentFlag.VALUE_3,
                ClientType.VALUE_200,
                "Y");
        assertEquals("FTE", acctNatureNo);
    }
}
