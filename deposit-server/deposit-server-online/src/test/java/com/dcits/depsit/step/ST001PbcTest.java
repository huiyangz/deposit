package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import com.dcits.depsit.enums.VoucherLostStatus;
import com.dcits.depsit.facade.bo.ST001InputBO;
import com.dcits.depsit.facade.bo.ST001OutputBO;
import com.dcits.depsit.facade.components.IRbVoucherLostBcc;
import com.dcits.depsit.facade.eo.RbVoucherLostEO;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST001 检查对手账户凭证状态 —— 单元测试。
 *
 * <p>调用签名：{@code ST001OutputBO execute(ST001InputBO input)}。用例依据本轮正式 Spec
 * 与 {@code outputs/测试用例.md}／{@code .json} 的 8 个用例设计：子步骤 1 的取值规则
 * （无记录 / 单条 / 多条含 USE）与子步骤 2 的两条互斥判定分支（{@code USE} → {@code ER0068}；
 * 否则 → 通过）各有对应用例。</p>
 *
 * <p>本步骤唯一依赖为【凭证挂失信息】的查询，全部用例只对
 * {@link IRbVoucherLostBcc#findByEo(RbVoucherLostEO)} 设桩；按技能约定不使用
 * {@code verify} / {@code never} / {@code times} / {@code InOrder} 验证交互。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST001PbcTest {

    /** 用例统一的对手账号入参 */
    private static final String OTH_BASE_ACCT_NO = "6222021234567890123";

    /** 【凭证挂失信息】数据服务（实体表 RB_VOUCHER_LOST） */
    @Mock
    private IRbVoucherLostBcc rbVoucherLostBcc;

    /** 被测步骤实现 */
    @InjectMocks
    private ST001Pbc st001Pbc;

    // ST001-TC001：REQ-001-S01 —— 以入参账号为唯一条件查询【凭证挂失信息】，返回该账号下两条记录
    //（状态依次 CAN、USE）；查询条件为该账号，且随后按 USE 走判定分支返回 ER0068
    @Test
    void testST001T01() {
        AtomicReference<RbVoucherLostEO> queryCondition = new AtomicReference<>();
        List<RbVoucherLostEO> records = List.of(lost(OTH_BASE_ACCT_NO, VoucherLostStatus.CAN),
                lost(OTH_BASE_ACCT_NO, VoucherLostStatus.USE));
        Mockito.lenient().when(rbVoucherLostBcc.findByEo(any(RbVoucherLostEO.class))).thenAnswer(invocation -> {
            queryCondition.set(invocation.getArgument(0));
            return records;
        });

        ST001OutputBO output = st001Pbc.execute(input());

        assertNotNull(queryCondition.get());
        assertEquals(OTH_BASE_ACCT_NO, queryCondition.get().getBaseAcctNo());
        assertEquals(VoucherLostStatus.USE, output.getVoucherLostStatus());
        assertFalse(output.isSucceed());
        assertEquals("ER0068", output.getErrorCode());
        assertNotNull(output.getErrorMessage());
    }

    // ST001-TC002：REQ-002-S01 —— 查询恰好返回 1 条记录且其凭证挂失状态为 USE，取值即该记录的值
    @Test
    void testST001T02() {
        Mockito.lenient().when(rbVoucherLostBcc.findByEo(any(RbVoucherLostEO.class)))
                .thenReturn(List.of(lost(OTH_BASE_ACCT_NO, VoucherLostStatus.USE)));

        ST001OutputBO output = st001Pbc.execute(input());

        assertEquals(VoucherLostStatus.USE, output.getVoucherLostStatus());
        assertFalse(output.isSucceed());
        assertEquals("ER0068", output.getErrorCode());
    }

    // ST001-TC003：REQ-002-S02 —— 查询返回 3 条记录，状态依次 CAN、USE、CAN，存在挂失生效记录时
    // 取该条记录状态，不受非生效记录与记录顺序影响
    @Test
    void testST001T03() {
        Mockito.lenient().when(rbVoucherLostBcc.findByEo(any(RbVoucherLostEO.class)))
                .thenReturn(List.of(lost(OTH_BASE_ACCT_NO, VoucherLostStatus.CAN),
                        lost(OTH_BASE_ACCT_NO, VoucherLostStatus.USE),
                        lost(OTH_BASE_ACCT_NO, VoucherLostStatus.CAN)));

        ST001OutputBO output = st001Pbc.execute(input());

        assertEquals(VoucherLostStatus.USE, output.getVoucherLostStatus());
        assertFalse(output.isSucceed());
        assertEquals("ER0068", output.getErrorCode());
    }

    // ST001-TC004：REQ-002-S03 与 REQ-004-S03 —— 查询返回 0 条记录，凭证挂失状态为空，
    // 判定走「否则」分支返回通过，不因无记录报错或返回错误码
    @Test
    void testST001T04() {
        Mockito.lenient().when(rbVoucherLostBcc.findByEo(any(RbVoucherLostEO.class)))
                .thenReturn(Collections.emptyList());

        ST001OutputBO output = st001Pbc.execute(input());

        assertNull(output.getVoucherLostStatus());
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST001-TC005：REQ-003-S01 —— 查询返回 1 条 CAN 记录，输出字段承载枚举取值域内的常量本身
    //（同一枚举实例，非中文/字符串状态文本），判定走「否则」分支返回通过
    @Test
    void testST001T05() {
        Mockito.lenient().when(rbVoucherLostBcc.findByEo(any(RbVoucherLostEO.class)))
                .thenReturn(List.of(lost(OTH_BASE_ACCT_NO, VoucherLostStatus.CAN)));

        ST001OutputBO output = st001Pbc.execute(input());

        assertSame(VoucherLostStatus.CAN, output.getVoucherLostStatus());
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST001-TC006：REQ-004-S01 —— [凭证挂失状态]=USE，步骤返回错误码 ER0068 表达不通过，
    // 错误信息携带该码值与文案「账户凭证挂失不能支取」，且不返回其它错误码
    @Test
    void testST001T06() {
        Mockito.lenient().when(rbVoucherLostBcc.findByEo(any(RbVoucherLostEO.class)))
                .thenReturn(List.of(lost(OTH_BASE_ACCT_NO, VoucherLostStatus.USE)));

        ST001OutputBO output = st001Pbc.execute(input());

        assertFalse(output.isSucceed());
        assertEquals("ER0068", output.getErrorCode());
        assertNotNull(output.getErrorMessage());
        assertTrue(output.getErrorMessage().contains("ER0068"));
        assertTrue(output.getErrorMessage().contains("账户凭证挂失不能支取"));
        assertEquals(VoucherLostStatus.USE, output.getVoucherLostStatus());
    }

    // ST001-TC007：REQ-004-S02 —— [凭证挂失状态]=CAN，走「否则」分支返回检查结果为通过，
    // 不携带 ER0068
    @Test
    void testST001T07() {
        Mockito.lenient().when(rbVoucherLostBcc.findByEo(any(RbVoucherLostEO.class)))
                .thenReturn(List.of(lost(OTH_BASE_ACCT_NO, VoucherLostStatus.CAN)));

        ST001OutputBO output = st001Pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(VoucherLostStatus.CAN, output.getVoucherLostStatus());
    }

    // ST001-TC008：REQ-004-S02 口径说明 —— 查询有多条记录但无任何记录处于挂失生效状态（状态均为 CAN），
    // 判定结论同为「通过」；该情形下 voucherLostStatus 的具体取值 Spec 未规定，本用例不断言该字段
    @Test
    void testST001T08() {
        Mockito.lenient().when(rbVoucherLostBcc.findByEo(any(RbVoucherLostEO.class)))
                .thenReturn(List.of(lost(OTH_BASE_ACCT_NO, VoucherLostStatus.CAN),
                        lost(OTH_BASE_ACCT_NO, VoucherLostStatus.CAN)));

        ST001OutputBO output = st001Pbc.execute(input());

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    /** 构造本步骤用例统一的输入。 */
    private ST001InputBO input() {
        ST001InputBO input = new ST001InputBO();
        input.setOthBaseAcctNo(OTH_BASE_ACCT_NO);
        return input;
    }

    /**
     * 构造用于设桩的挂失登记记录，仅设置本步骤用到的两个属性：账号与凭证挂失状态。
     */
    private RbVoucherLostEO lost(String baseAcctNo, VoucherLostStatus voucherLostStatus) {
        RbVoucherLostEO eo = new RbVoucherLostEO();
        eo.setBaseAcctNo(baseAcctNo);
        eo.setVoucherLostStatus(voucherLostStatus);
        return eo;
    }
}
