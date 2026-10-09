package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import com.dcits.depsit.enums.RestraintsStatus;
import com.dcits.depsit.facade.bo.ST135InputBO;
import com.dcits.depsit.facade.bo.ST135OutputBO;
import com.dcits.depsit.facade.components.IRbBusRestraintsBcc;
import com.dcits.depsit.facade.eo.RbBusRestraintsEO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST135 更新账户手工解限限制状态 单元测试。
 *
 * <p>用例来源：`outputs/测试用例.md` ST135-TC001 至 ST135-TC006，覆盖 Spec REQ-001 至 REQ-003
 * 的全部 5 个场景。本步骤无子步骤分支、无跳转、无循环，全部用例走同一条执行路径：
 * 输入 → 一次按限制编号的更新写操作 → 输出，差异只在输入取值与断言侧重。</p>
 *
 * <p>桩点：本步骤唯一的数据访问是按限制编号的更新写操作，用例对
 * {@link IRbBusRestraintsBcc#modifyByPrimaryKeySelective(RbBusRestraintsEO)} 设桩并记录收到的 EO。
 * Spec「验收范围与明确不覆盖的事项」第 1、7 项未定义影响行数不足或无记录时的步骤行为与输出取值，
 * 故不对返回行数做业务分支断言；GIVEN 中的既有限制状态属场景叙事，本步骤不读取（只有一次写操作），
 * 因此不设查询桩。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST135PbcTest {

    @Mock
    private IRbBusRestraintsBcc rbBusRestraintsBcc;

    @InjectMocks
    private ST135Pbc pbc;

    /**
     * 对唯一的更新写操作设桩：记录收到的 EO 并返回影响行数 1。
     *
     * @param captured 长度为 1 的数组，用于回传实现构造的更新 EO
     */
    private void stubUpdate(RbBusRestraintsEO[] captured) {
        lenient().when(rbBusRestraintsBcc.modifyByPrimaryKeySelective(any(RbBusRestraintsEO.class)))
                .thenAnswer(invocation -> {
                    captured[0] = invocation.getArgument(0);
                    return 1;
                });
    }

    /** REQ-001-S01：命中限制编号记录（既有状态 A-已批准），按限制编号把限制状态更新为 E-失效（ST135-TC001）。 */
    @Test
    void testST135T01() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubUpdate(captured);

        ST135InputBO input = new ST135InputBO();
        input.setResSeqNo("R20261009001");
        input.setClientNo("C0000000001");

        ST135OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("R20261009001", captured[0].getResSeqNo());
        assertEquals(RestraintsStatus.E, captured[0].getRestraintsStatus());
        assertEquals(RestraintsStatus.E, output.getRestraintsStatus());
    }

    /** REQ-001-S02：记录既有状态 F-未生效，更新不以原有状态为前置条件，仍写入 E-失效（ST135-TC002）。 */
    @Test
    void testST135T02() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubUpdate(captured);

        ST135InputBO input = new ST135InputBO();
        input.setResSeqNo("R20261009002");
        input.setClientNo("C0000000002");

        ST135OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("R20261009002", captured[0].getResSeqNo());
        assertEquals(RestraintsStatus.E, captured[0].getRestraintsStatus());
        assertEquals(RestraintsStatus.E, output.getRestraintsStatus());
    }

    /** REQ-002-S01：按输入表传入 resSeqNo 与 clientNo，{限制编号} 绑定 resSeqNo 并以其为定位条件执行更新（ST135-TC003）。 */
    @Test
    void testST135T03() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubUpdate(captured);

        ST135InputBO input = new ST135InputBO();
        input.setResSeqNo("R20261009003");
        input.setClientNo("C0000000001");

        ST135OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertEquals("R20261009003", captured[0].getResSeqNo());
        assertEquals(RestraintsStatus.E, captured[0].getRestraintsStatus());
        assertEquals(RestraintsStatus.E, output.getRestraintsStatus());
    }

    /** REQ-002-S02 场景 A：resSeqNo=R20261009004 配 clientNo=C0000000002，按限制编号定位并写入 E-失效（ST135-TC004）。 */
    @Test
    void testST135T04() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubUpdate(captured);

        ST135InputBO input = new ST135InputBO();
        input.setResSeqNo("R20261009004");
        input.setClientNo("C0000000002");

        ST135OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertEquals("R20261009004", captured[0].getResSeqNo());
        assertEquals(RestraintsStatus.E, captured[0].getRestraintsStatus());
        assertEquals(RestraintsStatus.E, output.getRestraintsStatus());
    }

    /** REQ-002-S02 场景 B：与 TC004 相同 resSeqNo、不同 clientNo，客户号不改变定位条件与写入取值（ST135-TC005）。 */
    @Test
    void testST135T05() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubUpdate(captured);

        ST135InputBO input = new ST135InputBO();
        input.setResSeqNo("R20261009004");
        input.setClientNo("C0000000009");

        ST135OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertEquals("R20261009004", captured[0].getResSeqNo());
        assertEquals(RestraintsStatus.E, captured[0].getRestraintsStatus());
        assertEquals(RestraintsStatus.E, output.getRestraintsStatus());
    }

    /** REQ-003-S01：更新成功后输出 restraintsStatus 承载本次写入的 E-失效，而非被更新记录的既有取值（ST135-TC006）。 */
    @Test
    void testST135T06() {
        RbBusRestraintsEO[] captured = new RbBusRestraintsEO[1];
        stubUpdate(captured);

        ST135InputBO input = new ST135InputBO();
        input.setResSeqNo("R20261009005");
        input.setClientNo("C0000000001");

        ST135OutputBO output = pbc.execute(input);

        assertTrue(output.isSucceed());
        assertEquals(RestraintsStatus.E, output.getRestraintsStatus());
        assertEquals(captured[0].getRestraintsStatus(), output.getRestraintsStatus());
        assertNotEquals(RestraintsStatus.A, output.getRestraintsStatus());
        assertNotEquals(RestraintsStatus.F, output.getRestraintsStatus());
    }
}
