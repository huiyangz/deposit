package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.lenient;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.VoucherLostStatus;
import com.dcits.deposit.facade.bo.ST008InputBO;
import com.dcits.deposit.facade.bo.ST008OutputBO;
import com.dcits.deposit.facade.components.IRbVoucherLostBcc;
import com.dcits.deposit.facade.eo.RbVoucherLostEO;

/**
 * ST008 检查支取账户凭证状态 单元测试。
 *
 * <p>覆盖本轮已确认用例：ST008-TC001（REQ-001-S01、REQ-002-S01，生效挂失记录 → 业务失败 ER0068）、
 * ST008-TC002（REQ-001-S02、REQ-003-S01，失效挂失记录 → 检查通过）、
 * ST008-TC003（REQ-003-S02，未查询到挂失记录 → 检查通过）。
 * 未覆盖事项：同一账号多条挂失记录取舍、必填输入缺失行为，见 Spec 待确认事项 1、2。</p>
 */
@ExtendWith(MockitoExtension.class)
public class ST008PbcTest {

    /** 凭证挂失登记簿数据服务接口 */
    @Mock
    private IRbVoucherLostBcc rbVoucherLostBcc;

    /** 被测步骤实现 */
    @InjectMocks
    private ST008Pbc st008Pbc;

    /** ST008-TC001（REQ-001-S01、REQ-002-S01）：账号存在生效挂失记录，查询后输出 voucherLostStatus=生效，状态为「生效」触发业务失败返回错误码 ER0068 */
    @Test
    public void testST008T01() {
        // 前置条件：按 baseAcctNo="6222020200012345" 查询返回单条生效挂失记录
        RbVoucherLostEO record = new RbVoucherLostEO();
        record.setBaseAcctNo("6222020200012345");
        record.setVoucherLostStatus(VoucherLostStatus.A);
        lenient().when(rbVoucherLostBcc.findByEo(argThat(eo -> eo != null
                && "6222020200012345".equals(eo.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(record));

        // 输入构造
        ST008InputBO input = new ST008InputBO();
        input.setBaseAcctNo("6222020200012345");

        // 执行
        ST008OutputBO output = st008Pbc.execute(input);

        // 断言：业务失败，错误码与错误信息为已确认格式，输出 voucherLostStatus=生效
        assertEquals(false, output.isSucceed());
        assertEquals("ER0068", output.getErrorCode());
        assertEquals("ER0068::账户凭证挂失不能支取", output.getErrorMessage());
        assertEquals(VoucherLostStatus.A, output.getVoucherLostStatus());
    }

    /** ST008-TC002（REQ-001-S02、REQ-003-S01）：账号存在失效挂失记录，查询后输出 voucherLostStatus=失效，状态非「生效」检查通过 */
    @Test
    public void testST008T02() {
        // 前置条件：按 baseAcctNo="6222020200012345" 查询返回单条失效挂失记录
        RbVoucherLostEO record = new RbVoucherLostEO();
        record.setBaseAcctNo("6222020200012345");
        record.setVoucherLostStatus(VoucherLostStatus.E);
        lenient().when(rbVoucherLostBcc.findByEo(argThat(eo -> eo != null
                && "6222020200012345".equals(eo.getBaseAcctNo()))))
                .thenReturn(Collections.singletonList(record));

        // 输入构造
        ST008InputBO input = new ST008InputBO();
        input.setBaseAcctNo("6222020200012345");

        // 执行
        ST008OutputBO output = st008Pbc.execute(input);

        // 断言：检查通过，错误字段为空，输出 voucherLostStatus=失效
        assertEquals(true, output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertEquals(VoucherLostStatus.E, output.getVoucherLostStatus());
    }

    /** ST008-TC003（REQ-003-S02）：账号不存在挂失记录（查询无结果），无凭证挂失状态，检查通过且不返回错误码 ER0068 */
    @Test
    public void testST008T03() {
        // 前置条件：按 baseAcctNo="6222020200012345" 查询返回空列表
        lenient().when(rbVoucherLostBcc.findByEo(argThat(eo -> eo != null
                && "6222020200012345".equals(eo.getBaseAcctNo()))))
                .thenReturn(Collections.emptyList());

        // 输入构造
        ST008InputBO input = new ST008InputBO();
        input.setBaseAcctNo("6222020200012345");

        // 执行
        ST008OutputBO output = st008Pbc.execute(input);

        // 断言：检查通过，错误字段为空，无记录未约定时 voucherLostStatus 返回空
        assertEquals(true, output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
        assertNull(output.getVoucherLostStatus());
    }
}
