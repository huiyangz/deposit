package com.dcits.deposit.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dcits.deposit.enums.RbBusAcctPurpose;
import org.junit.jupiter.api.Test;

/**
 * DT001 根据核准类型设置账户状态 —— 单元测试
 *
 * <p>用例来源：outputs/测试用例.md（DT001-TC001 ~ DT001-TC019），覆盖 SPEC 全部 19 个已定义决策行。
 * 期望结果均来自门禁通过版 SPEC（docs/specs/DT001.md）。</p>
 */
class DT001Test {

    @Test
    // 场景：基本户、境内、企业标志“是”，命中决策行 1a；预期返回账户状态“新建”
    void test_01() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "基本户";
        String corporationFlag = "是";
        String inlandOffshore = "境内";

        assertEquals("新建", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC001");
    }

    @Test
    // 场景：基本户、境内、企业标志“否”，命中决策行 1b；预期返回账户状态“预开户”
    void test_02() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "基本户";
        String corporationFlag = "否";
        String inlandOffshore = "境内";

        assertEquals("预开户", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC002");
    }

    @Test
    // 场景：基本户、境外、企业标志“是”，命中决策行 1c；预期返回账户状态“预开户”
    void test_03() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "基本户";
        String corporationFlag = "是";
        String inlandOffshore = "境外";

        assertEquals("预开户", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC003");
    }

    @Test
    // 场景：基本户、境外、企业标志“否”，命中决策行 1d；预期返回账户状态“新建”
    void test_04() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "基本户";
        String corporationFlag = "否";
        String inlandOffshore = "境外";

        assertEquals("新建", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC004");
    }

    @Test
    // 场景：一般户，境内境外标志/企业标志/账户用途均不关心，命中决策行 2；预期返回账户状态“新建”
    void test_05() {
        RbBusAcctPurpose rbBusAcctPurpose = RbBusAcctPurpose.VALUE_0; // 0-无特殊用途（样本值）
        String acctNatureNo = "一般户";
        String corporationFlag = "是";
        String inlandOffshore = "境外";

        assertEquals("新建", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC005");
    }

    @Test
    // 场景：专用户、账户用途为预算单位专用存款户、境内、企业标志“是”，命中决策行 3.1a；预期返回账户状态“无”
    void test_06() {
        RbBusAcctPurpose rbBusAcctPurpose = RbBusAcctPurpose.VALUE_4; // 4-预算单位专用
        String acctNatureNo = "专用户";
        String corporationFlag = "是";
        String inlandOffshore = "境内";

        assertEquals("无", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC006");
    }

    @Test
    // 场景：专用户、账户用途为预算单位专用存款户、境内、企业标志“否”，命中决策行 3.1b；预期返回账户状态“预开户”
    void test_07() {
        RbBusAcctPurpose rbBusAcctPurpose = RbBusAcctPurpose.VALUE_4; // 4-预算单位专用
        String acctNatureNo = "专用户";
        String corporationFlag = "否";
        String inlandOffshore = "境内";

        assertEquals("预开户", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC007");
    }

    @Test
    // 场景：专用户、账户用途为预算单位专用存款户、境外、企业标志“是”，命中决策行 3.1c；预期返回账户状态“无”
    void test_08() {
        RbBusAcctPurpose rbBusAcctPurpose = RbBusAcctPurpose.VALUE_4; // 4-预算单位专用
        String acctNatureNo = "专用户";
        String corporationFlag = "是";
        String inlandOffshore = "境外";

        assertEquals("无", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC008");
    }

    @Test
    // 场景：专用户、账户用途为预算单位专用存款户、境外、企业标志“否”，命中决策行 3.1d；预期返回账户状态“新建”
    void test_09() {
        RbBusAcctPurpose rbBusAcctPurpose = RbBusAcctPurpose.VALUE_4; // 4-预算单位专用
        String acctNatureNo = "专用户";
        String corporationFlag = "否";
        String inlandOffshore = "境外";

        assertEquals("新建", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC009");
    }

    @Test
    // 场景：专用户、账户用途为非预算单位专用存款户，境内境外标志/企业标志不关心，命中决策行 3.2；预期返回账户状态“新建”
    void test_10() {
        RbBusAcctPurpose rbBusAcctPurpose = RbBusAcctPurpose.VALUE_3; // 3-非预算单位专用
        String acctNatureNo = "专用户";
        String corporationFlag = "否";
        String inlandOffshore = "境内";

        assertEquals("新建", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC010");
    }

    @Test
    // 场景：临时户、境内、企业标志“是”，命中决策行 4a；预期返回账户状态“新建”
    void test_11() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "临时户";
        String corporationFlag = "是";
        String inlandOffshore = "境内";

        assertEquals("新建", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC011");
    }

    @Test
    // 场景：临时户、境内、企业标志“否”，命中决策行 4b；预期返回账户状态“预开户”
    void test_12() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "临时户";
        String corporationFlag = "否";
        String inlandOffshore = "境内";

        assertEquals("预开户", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC012");
    }

    @Test
    // 场景：临时户、境外、企业标志“是”，命中决策行 4c；预期返回账户状态“无”
    void test_13() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "临时户";
        String corporationFlag = "是";
        String inlandOffshore = "境外";

        assertEquals("无", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC013");
    }

    @Test
    // 场景：临时户、境外、企业标志“否”，命中决策行 4d；预期返回账户状态“新建”
    void test_14() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "临时户";
        String corporationFlag = "否";
        String inlandOffshore = "境外";

        assertEquals("新建", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC014");
    }

    @Test
    // 场景：验资户、境内、企业标志“是”，命中决策行 5a；预期返回账户状态“新建”
    void test_15() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "验资户";
        String corporationFlag = "是";
        String inlandOffshore = "境内";

        assertEquals("新建", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC015");
    }

    @Test
    // 场景：验资户、境内、企业标志“否”，命中决策行 5b；预期返回账户状态“新建”
    void test_16() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "验资户";
        String corporationFlag = "否";
        String inlandOffshore = "境内";

        assertEquals("新建", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC016");
    }

    @Test
    // 场景：验资户、境外、企业标志“是”，命中决策行 5c；预期返回账户状态“无”
    void test_17() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "验资户";
        String corporationFlag = "是";
        String inlandOffshore = "境外";

        assertEquals("无", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC017");
    }

    @Test
    // 场景：验资户、境外、企业标志“否”，命中决策行 5d；预期返回账户状态“新建”
    void test_18() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "验资户";
        String corporationFlag = "否";
        String inlandOffshore = "境外";

        assertEquals("新建", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC018");
    }

    @Test
    // 场景：账户属性为非列举取值，境内境外标志/企业标志/账户用途不关心，命中默认决策行 6；预期返回账户状态“新建”
    void test_19() {
        RbBusAcctPurpose rbBusAcctPurpose = null;
        String acctNatureNo = "其他属性";
        String corporationFlag = "是";
        String inlandOffshore = "境内";

        assertEquals("新建", DT001.execute(rbBusAcctPurpose, acctNatureNo, corporationFlag, inlandOffshore),
                "DT001-TC019");
    }
}
