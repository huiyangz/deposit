package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.WithdrawalType;
import com.dcits.deposit.facade.bo.ST019InputBO;
import com.dcits.deposit.facade.bo.ST019OutputBO;
import com.dcits.deposit.facade.components.IRbBusClientAcctBcc;
import com.dcits.deposit.facade.eo.RbBusClientAcctEO;

/**
 * ST019 检查账户支取方式 单元测试。
 *
 * <p>覆盖正式 Spec REQ-001-S01、REQ-002-S01、REQ-003-S01 已确认场景（测试用例
 * ST019-TC001、ST019-TC002）。查询目标实体所指（TBD-1）、按账号唯一匹配规则（TBD-2）、
 * 缺失与空值处理（TBD-3）及跳转承载机制与目标步骤（TBD-4）不作为本套用例断言，
 * 见 Spec 待确认事项。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST019PbcTest {

    @Mock
    private IRbBusClientAcctBcc rbBusClientAcctBcc;

    @InjectMocks
    private ST019Pbc st019Pbc;

    // 场景：REQ-001-S01 + REQ-003-S01，按账号查询取得支取方式为凭印鉴支取（WithdrawalType.S），判定检查通过、本步骤正常结束，不跳转《检查支取密码状态》
    @Test
    void testST019T01() {
        RbBusClientAcctEO acct = new RbBusClientAcctEO();
        acct.setBaseAcctNo("660200000000001");
        acct.setClientNo("1000000000001");
        acct.setWithdrawalType(WithdrawalType.S);
        lenient().when(rbBusClientAcctBcc.findByEo(argThat(eo -> "660200000000001".equals(eo.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(acct));

        ST019InputBO input = new ST019InputBO();
        input.setBaseAcctNo("660200000000001");

        ST019OutputBO result = st019Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(WithdrawalType.S, result.getWithdrawalType());
    }

    // 场景：REQ-002-S01，按账号查询取得支取方式为凭密码支取（WithdrawalType.P），流程跳转至步骤《检查支取密码状态》继续执行，本步骤不判定为检查失败
    @Test
    void testST019T02() {
        RbBusClientAcctEO acct = new RbBusClientAcctEO();
        acct.setBaseAcctNo("660200000000001");
        acct.setClientNo("1000000000002");
        acct.setWithdrawalType(WithdrawalType.P);
        lenient().when(rbBusClientAcctBcc.findByEo(argThat(eo -> "660200000000001".equals(eo.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(acct));

        ST019InputBO input = new ST019InputBO();
        input.setBaseAcctNo("660200000000001");

        ST019OutputBO result = st019Pbc.execute(input);

        assertTrue(result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(WithdrawalType.P, result.getWithdrawalType());
    }
}
