package com.dcits.depsit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import com.dcits.depsit.enums.TranBranch;
import com.dcits.depsit.facade.bo.ST128InputBO;
import com.dcits.depsit.facade.bo.ST128OutputBO;
import com.dcits.depsit.facade.components.IFmBranchBcc;
import com.dcits.depsit.facade.components.IRbBusAcctBcc;
import com.dcits.depsit.facade.eo.FmBranchEO;
import com.dcits.depsit.facade.eo.RbBusAcctEO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST128 检查是否跨法人 步骤单元测试。
 *
 * <p>真实 {@link ST128Pbc}；仅对两个依赖数据服务接口 {@link IRbBusAcctBcc}、{@link IFmBranchBcc} 设桩，
 * 不访问数据库，不使用规则桩与跨组件客户端桩。本步骤无实体写入，故不验证写入交互。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST128PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @Mock
    private IFmBranchBcc fmBranchBcc;

    @InjectMocks
    private ST128Pbc st128Pbc;

    // ST128-TC001：REQ-001-S01/S02、REQ-002-S01、REQ-003-S01、REQ-004-S01、REQ-005-S02、REQ-006-S01
    // 账号唯一命中一条账户记录（开立行行号 351155），账户法人与交易机构法人同为「法人A」，返回“通过”且步骤成功
    @Test
    void testST128T01() {
        RbBusAcctEO acct = acct("6201000000001234", TranBranch.VALUE_351155);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(acct));
        Mockito.lenient().when(fmBranchBcc.findByBranch(TranBranch.VALUE_351155))
                .thenReturn(branch(TranBranch.VALUE_351155, "法人A"));
        Mockito.lenient().when(fmBranchBcc.findByBranch(TranBranch.VALUE_351156))
                .thenReturn(branch(TranBranch.VALUE_351156, "法人A"));

        ST128OutputBO output = st128Pbc.execute(input("6201000000001234", TranBranch.VALUE_351156));

        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals("通过", output.getCheckResult());
    }

    // ST128-TC002：REQ-005-S01 账户法人「法人A」与交易机构法人「法人B」不相等，返回“不通过”，仍为正常业务结论
    @Test
    void testST128T02() {
        RbBusAcctEO acct = acct("6201000000001234", TranBranch.VALUE_351155);
        Mockito.lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(List.of(acct));
        Mockito.lenient().when(fmBranchBcc.findByBranch(TranBranch.VALUE_351155))
                .thenReturn(branch(TranBranch.VALUE_351155, "法人A"));
        Mockito.lenient().when(fmBranchBcc.findByBranch(TranBranch.VALUE_351156))
                .thenReturn(branch(TranBranch.VALUE_351156, "法人B"));

        ST128OutputBO output = st128Pbc.execute(input("6201000000001234", TranBranch.VALUE_351156));

        assertTrue(output.isSucceed());
        assertEquals("不通过", output.getCheckResult());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    // ST128-TC003：REQ-002-S02、REQ-006-S02、REQ-007-S01 按账号查【账户信息】返回 0 条记录，业务失败 ER0048 并短路，
    // 不产出检查结果；机构查询与比较（未设桩）不执行
    @Test
    void testST128T03() {
        Mockito.lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class)))
                .thenReturn(Collections.<RbBusAcctEO>emptyList());

        ST128OutputBO output = st128Pbc.execute(input("6201000000001234", TranBranch.VALUE_351156));

        assertFalse(output.isSucceed());
        assertEquals("ER0048", output.getErrorCode());
        assertTrue(output.getErrorMessage().contains("账户不存在"));
        assertNull(output.getCheckResult());
    }

    // ST128-TC004：REQ-002-S03、REQ-007-S01 按账号查【账户信息】返回 2 条记录，与查无同码 ER0048 结束，
    // 不取其中任何一条的开立行行号，不产出检查结果
    @Test
    void testST128T04() {
        List<RbBusAcctEO> acctList = List.of(
                acct("6201000000001234", TranBranch.VALUE_351155),
                acct("6201000000001234", TranBranch.VALUE_351157));
        Mockito.lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenReturn(acctList);

        ST128OutputBO output = st128Pbc.execute(input("6201000000001234", TranBranch.VALUE_351156));

        assertFalse(output.isSucceed());
        assertEquals("ER0048", output.getErrorCode());
        assertNull(output.getCheckResult());
    }

    // ST128-TC005：REQ-001-S02、REQ-006-S01 核对机构号来源——账号查询以输入 baseAcctNo 为条件；
    // 账户法人查询用账户开立行行号 351156、交易机构查询用输入 branch 351155（枚举码值原样，无格式转换），
    // 账户法人「法人A」与交易机构法人「法人B」不等，返回“不通过”
    @Test
    void testST128T05() {
        List<RbBusAcctEO> capturedAcctConditions = new ArrayList<>();
        Mockito.lenient().when(rbBusAcctBcc.findByEo(any(RbBusAcctEO.class))).thenAnswer(invocation -> {
            RbBusAcctEO condition = invocation.getArgument(0);
            capturedAcctConditions.add(condition);
            return List.of(acct("6201000000009999", TranBranch.VALUE_351156));
        });
        List<TranBranch> requestedBranches = new ArrayList<>();
        Mockito.lenient().when(fmBranchBcc.findByBranch(any(TranBranch.class))).thenAnswer(invocation -> {
            TranBranch requested = invocation.getArgument(0);
            requestedBranches.add(requested);
            return branch(requested, TranBranch.VALUE_351156.equals(requested) ? "法人A" : "法人B");
        });

        ST128OutputBO output = st128Pbc.execute(input("6201000000009999", TranBranch.VALUE_351155));

        assertEquals(1, capturedAcctConditions.size());
        assertEquals("6201000000009999", capturedAcctConditions.get(0).getBaseAcctNo());
        assertTrue(requestedBranches.contains(TranBranch.VALUE_351156));
        assertTrue(requestedBranches.contains(TranBranch.VALUE_351155));
        assertTrue(output.isSucceed());
        assertEquals("不通过", output.getCheckResult());
        assertNull(output.getErrorCode());
    }

    /** 构造账户记录：仅填本步骤使用的账号与账户开立行行号。 */
    private static RbBusAcctEO acct(String baseAcctNo, TranBranch acctBranch) {
        RbBusAcctEO eo = new RbBusAcctEO();
        eo.setBaseAcctNo(baseAcctNo);
        eo.setAcctBranch(acctBranch);
        return eo;
    }

    /** 构造机构记录：仅填本步骤使用的归属机构号与法人。 */
    private static FmBranchEO branch(TranBranch branch, String company) {
        FmBranchEO eo = new FmBranchEO();
        eo.setBranch(branch);
        eo.setCompany(company);
        return eo;
    }

    /** 构造步骤输入：账号与归属机构号（{交易机构}）。 */
    private static ST128InputBO input(String baseAcctNo, TranBranch branch) {
        ST128InputBO input = new ST128InputBO();
        input.setBaseAcctNo(baseAcctNo);
        input.setBranch(branch);
        return input;
    }
}
