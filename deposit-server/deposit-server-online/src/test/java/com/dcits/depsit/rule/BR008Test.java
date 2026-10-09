package com.dcits.depsit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dcits.depsit.enums.AcctNatureNo;
import com.dcits.depsit.enums.ClientType;
import com.dcits.depsit.enums.TaxResidentFlag;

/**
 * BR008 设置自贸区种类 单元测试。
 *
 * <p>用例来源：outputs/测试用例.md（BR008-TC001 ~ BR008-TC008），
 * 期望值取自正式 Spec。{@code isIndividual} 源需求未定义取值域且不参与判定，
 * 统一取固定样本值 "Y" 满足必填，不作为断言依据。</p>
 */
class BR008Test {

    /** 对私客户标志固定样本值：源需求未定义该字段取值域，不参与任何分支判定。 */
    private static final String IS_INDIVIDUAL = "Y";

    /** REQ-001-S01：个人客户且中国税收居民，取 FTI 分支，返回 "3605"。 */
    @Test
    void test_01() {
        String actual = BR008.execute(IS_INDIVIDUAL, TaxResidentFlag.VALUE_1, ClientType.VALUE_100, "Y");
        assertEquals(AcctNatureNo.VALUE_3605.getValue(), actual);
    }

    /** REQ-001-S02：个人客户且既是中国税收居民又是其他国家（地区）税收居民，同取 FTI，返回 "3605"。 */
    @Test
    void test_02() {
        String actual = BR008.execute(IS_INDIVIDUAL, TaxResidentFlag.VALUE_3, ClientType.VALUE_100, "Y");
        assertEquals(AcctNatureNo.VALUE_3605.getValue(), actual);
    }

    /** REQ-001-S03：个人客户且非中国税收居民，取 FTF 分支，返回 "3606"。 */
    @Test
    void test_03() {
        String actual = BR008.execute(IS_INDIVIDUAL, TaxResidentFlag.VALUE_2, ClientType.VALUE_100, "Y");
        assertEquals(AcctNatureNo.VALUE_3606.getValue(), actual);
    }

    /** REQ-001-S04：个人分支不受境内境外标志影响，inlandOffshore 为 "N" 时仍返回 "3605"。 */
    @Test
    void test_04() {
        String actual = BR008.execute(IS_INDIVIDUAL, TaxResidentFlag.VALUE_1, ClientType.VALUE_100, "N");
        assertEquals(AcctNatureNo.VALUE_3605.getValue(), actual);
    }

    /** REQ-002-S01：对公客户且境内，取 FTE 分支，返回 "3603"。 */
    @Test
    void test_05() {
        String actual = BR008.execute(IS_INDIVIDUAL, TaxResidentFlag.VALUE_1, ClientType.VALUE_200, "Y");
        assertEquals(AcctNatureNo.VALUE_3603.getValue(), actual);
    }

    /** REQ-002-S02：对公客户且境外，取 FTN 分支，返回 "3604"。 */
    @Test
    void test_06() {
        String actual = BR008.execute(IS_INDIVIDUAL, TaxResidentFlag.VALUE_3, ClientType.VALUE_200, "N");
        assertEquals(AcctNatureNo.VALUE_3604.getValue(), actual);
    }

    /** REQ-002-S03：对公分支不受税收居民标识影响，taxResidentFlag 为 "2" 时仍返回 "3603"。 */
    @Test
    void test_07() {
        String actual = BR008.execute(IS_INDIVIDUAL, TaxResidentFlag.VALUE_2, ClientType.VALUE_200, "Y");
        assertEquals(AcctNatureNo.VALUE_3603.getValue(), actual);
    }

    /** REQ-003-S01：同业客户且境外，取 FTU 分支，返回 "3607"。 */
    @Test
    void test_08() {
        String actual = BR008.execute(IS_INDIVIDUAL, TaxResidentFlag.VALUE_1, ClientType.VALUE_300, "N");
        assertEquals(AcctNatureNo.VALUE_3607.getValue(), actual);
    }
}
