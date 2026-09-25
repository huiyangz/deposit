package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.TaxResidentFlag;

/**
 * BR006 设置自贸区种类 单元测试。
 *
 * <p>用例来自 outputs/测试用例.md（TC001–TC008），期望值按本轮门禁通过版 SPEC 重推导：
 * 输出为 {@link com.dcits.deposit.enums.AcctNatureNo} 的取值代码（FTI→"3605"、FTF→"3606"、
 * FTE→"3603"、FTN→"3604"、FTU→"3607"）；行 a 含客户类型=100 并列条件，TC007 场景预期为 FTE；
 * 行 f（默认返回空值）已定义，补 test_09–test_11 覆盖。</p>
 */
public class BR006Test {

    // 条件a 命中（OR 左侧）：对私客户标志="Y" 且 税收居民标识=1、客户类型=100，返回 FTI 的取值代码 "3605"
    @Test
    void test_01() {
        String result = BR006.execute("Y", TaxResidentFlag.VALUE_1, ClientType.VALUE_100, "Y");
        assertEquals("3605", result);
    }

    // 条件a 命中（OR 右侧）：对私客户标志="Y" 且 税收居民标识=3、客户类型=100，返回 FTI 的取值代码 "3605"
    @Test
    void test_02() {
        String result = BR006.execute("Y", TaxResidentFlag.VALUE_3, ClientType.VALUE_100, "Y");
        assertEquals("3605", result);
    }

    // 条件a 不命中（标识=2 不在 {1,3}），条件b 命中：客户类型=100 且 税收居民标识=2，返回 FTF 的取值代码 "3606"
    @Test
    void test_03() {
        String result = BR006.execute("Y", TaxResidentFlag.VALUE_2, ClientType.VALUE_100, "Y");
        assertEquals("3606", result);
    }

    // 条件a 不命中（对私标志≠"Y"）、条件b 不命中（客户类型≠100），条件c 命中：客户类型=200 且 境内境外标志="Y"，返回 FTE 的取值代码 "3603"
    @Test
    void test_04() {
        String result = BR006.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_200, "Y");
        assertEquals("3603", result);
    }

    // 条件c 不命中（境内境外标志="N"），条件d 命中：客户类型=200 且 境内境外标志="N"，返回 FTN 的取值代码 "3604"
    @Test
    void test_05() {
        String result = BR006.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_200, "N");
        assertEquals("3604", result);
    }

    // 条件e 命中：客户类型=300 且 境内境外标志="N"，返回 FTU 的取值代码 "3607"
    @Test
    void test_06() {
        String result = BR006.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_300, "N");
        assertEquals("3607", result);
    }

    // 行a 需客户类型=100：对私标志="Y"、标识=1 但客户类型=200 时行a 不命中，落入行c，返回 FTE 的取值代码 "3603" 而非 FTI
    @Test
    void test_07() {
        String result = BR006.execute("Y", TaxResidentFlag.VALUE_1, ClientType.VALUE_200, "Y");
        assertEquals("3603", result);
    }

    // 条件b 否定：税收居民标识=2 但客户类型=300（≠100）不返回 FTF，条件e 命中，返回 FTU 的取值代码 "3607"
    @Test
    void test_08() {
        String result = BR006.execute("N", TaxResidentFlag.VALUE_2, ClientType.VALUE_300, "N");
        assertEquals("3607", result);
    }

    // 条件f 默认行：客户类型=300-同业 且 境内境外标志="Y"（行e 需"N"），a–e 均不命中，返回空值
    @Test
    void test_09() {
        String result = BR006.execute("Y", TaxResidentFlag.VALUE_1, ClientType.VALUE_300, "Y");
        assertNull(result);
    }

    // 条件f 默认行：客户类型=100、税收居民标识=1 但对私客户标志="N"，行a、行b 均不命中，返回空值
    @Test
    void test_10() {
        String result = BR006.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_100, "Y");
        assertNull(result);
    }

    // 条件f 默认行：客户类型=600-内部客户，a–e 均不命中，返回空值
    @Test
    void test_11() {
        String result = BR006.execute("N", TaxResidentFlag.VALUE_1, ClientType.VALUE_600, "Y");
        assertNull(result);
    }
}
