package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import com.dcits.deposit.enums.DealFlow;
import com.dcits.deposit.enums.DocClass;
import com.dcits.deposit.enums.DocType;
import com.dcits.deposit.enums.DocumentType;
import com.dcits.deposit.enums.IssCountry;
import com.dcits.deposit.enums.SourceType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.enums.TranType;
import com.dcits.deposit.facade.bo.ST009InputBO;
import com.dcits.deposit.facade.bo.ST009OutputBO;
import com.dcits.deposit.facade.bo.ST036InputBO;
import com.dcits.deposit.facade.bo.ST036OutputBO;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.components.ITbVoucherDefBcc;
import com.dcits.deposit.facade.eo.FmClientCopyEO;
import com.dcits.deposit.facade.eo.TbVoucherDefEO;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * ST009 检查支取客户黑名单 步骤实现单元测试。
 *
 * <p>覆盖正式 Spec REQ-001~REQ-005 已确认场景（测试用例 ST009-TC001~TC008）：客户证件
 * 信息获取、凭证种类获取、事件类型赋值为 DEBT、按已确认 11 项映射调用组件内步骤 ST036，
 * 以及[执行结果]三分支返回（通过/提醒、授权、拒绝）。待确认事项 TBD-1~TBD-6 对应行为
 * 不作为本套用例断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST009PbcTest {

    @Mock
    private IFmClientCopyBcc fmClientCopyBcc;

    @Mock
    private ITbVoucherDefBcc tbVoucherDefBcc;

    @Mock
    private IST036 st036;

    @InjectMocks
    private ST009Pbc pbc;

    /** 记录 ST009-TC004 捕获的 ST036InputBO 入参。 */
    private ST036InputBO capturedSt036Input;

    private ST009InputBO buildInput() {
        ST009InputBO input = new ST009InputBO();
        input.setClientNo("C000000001");
        input.setDocType(DocType.VALUE_737);
        input.setBaseAcctNo("RB1000000001");
        input.setTranBranch(TranBranch.VALUE_351155);
        input.setTranType(TranType.VALUE_4101);
        input.setServiceCode("SVC0001");
        input.setMessageCode("CIFDP0001");
        input.setMessageType("TRD");
        input.setSourceType(SourceType.CIP);
        return input;
    }

    private FmClientCopyEO buildClientCopy() {
        FmClientCopyEO eo = new FmClientCopyEO();
        eo.setClientName("张三");
        eo.setDocumentType(DocumentType.VALUE_110001);
        eo.setDocumentId("110101199001011234");
        eo.setIssCountry(IssCountry.CHN);
        return eo;
    }

    private TbVoucherDefEO buildVoucherDef() {
        TbVoucherDefEO eo = new TbVoucherDefEO();
        eo.setDocType(DocType.VALUE_737);
        eo.setDocClass(DocClass.DCT);
        return eo;
    }

    private ST036OutputBO buildSt036Out(DealFlow dealFlow) {
        ST036OutputBO out = new ST036OutputBO();
        out.setSucceed(true);
        out.setDealFlow(dealFlow);
        return out;
    }

    // 场景：REQ-001-S01（ST009-TC001），按{客户号}查询客户副本表取得客户证件信息并赋值四项输出，后续步骤全部正常结束
    @Test
    void testST009T01() {
        ST009InputBO input = buildInput();
        lenient().when(fmClientCopyBcc.findByEo(any(FmClientCopyEO.class))).thenReturn(List.of(buildClientCopy()));
        lenient().when(tbVoucherDefBcc.findByDocType(DocType.VALUE_737)).thenReturn(buildVoucherDef());
        lenient().when(st036.execute(any(ST036InputBO.class))).thenReturn(buildSt036Out(null));

        ST009OutputBO result = pbc.execute(input);

        assertEquals(true, result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("张三", result.getClientName());
        assertEquals(DocumentType.VALUE_110001, result.getDocumentType());
        assertEquals("110101199001011234", result.getDocumentId());
        assertEquals(IssCountry.CHN, result.getIssCountry());
    }

    // 场景：REQ-002-S01（ST009-TC002），按{凭证类型}查询凭证类型定义表取得凭证种类 docClass=DCT，其余步骤正常结束
    @Test
    void testST009T02() {
        ST009InputBO input = buildInput();
        lenient().when(fmClientCopyBcc.findByEo(any(FmClientCopyEO.class))).thenReturn(List.of(buildClientCopy()));
        lenient().when(tbVoucherDefBcc.findByDocType(DocType.VALUE_737)).thenReturn(buildVoucherDef());
        lenient().when(st036.execute(any(ST036InputBO.class))).thenReturn(buildSt036Out(null));

        ST009OutputBO result = pbc.execute(input);

        assertEquals(true, result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals(DocClass.DCT, result.getDocClass());
    }

    // 场景：REQ-003-S01（ST009-TC003），步骤 3 将输出事件类型赋值为 "DEBT"，其余步骤正常结束
    @Test
    void testST009T03() {
        ST009InputBO input = buildInput();
        lenient().when(fmClientCopyBcc.findByEo(any(FmClientCopyEO.class))).thenReturn(List.of(buildClientCopy()));
        lenient().when(tbVoucherDefBcc.findByDocType(DocType.VALUE_737)).thenReturn(buildVoucherDef());
        lenient().when(st036.execute(any(ST036InputBO.class))).thenReturn(buildSt036Out(null));

        ST009OutputBO result = pbc.execute(input);

        assertEquals(true, result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("DEBT", result.getEventType());
    }

    // 场景：REQ-004-S01（ST009-TC004），按已确认 11 项映射组装 ST036InputBO 调用组件内步骤 ST036，桩捕获入参断言字段映射
    @Test
    void testST009T04() {
        ST009InputBO input = buildInput();
        lenient().when(fmClientCopyBcc.findByEo(any(FmClientCopyEO.class))).thenReturn(List.of(buildClientCopy()));
        lenient().when(tbVoucherDefBcc.findByDocType(DocType.VALUE_737)).thenReturn(buildVoucherDef());
        ST036OutputBO st036Out = buildSt036Out(null);
        lenient().when(st036.execute(any(ST036InputBO.class))).thenAnswer(invocation -> {
            capturedSt036Input = invocation.getArgument(0);
            return st036Out;
        });

        ST009OutputBO result = pbc.execute(input);

        // 已确认映射的 11 项字段（TBD-1 的 clientName/issCountry 与 TBD-2 的 acctBranch 不断言）
        assertEquals("RB1000000001", capturedSt036Input.getBaseAcctNo());
        assertEquals("C000000001", capturedSt036Input.getClientNo());
        assertEquals(DocumentType.VALUE_110001, capturedSt036Input.getDocumentType());
        assertEquals("110101199001011234", capturedSt036Input.getDocumentId());
        assertEquals(TranType.VALUE_4101, capturedSt036Input.getTranType());
        assertEquals("DEBT", capturedSt036Input.getEventType());
        assertEquals("SVC0001", capturedSt036Input.getServiceCode());
        assertEquals("CIFDP0001", capturedSt036Input.getMessageCode());
        assertEquals("TRD", capturedSt036Input.getMessageType());
        assertEquals(SourceType.CIP, capturedSt036Input.getSourceType());
        assertEquals(DocClass.DCT, capturedSt036Input.getDocClass());
        assertEquals(true, result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
    }

    // 场景：REQ-005-S01（ST009-TC005），执行结果为通过（无 dealFlow），返回通过，不设置[授权标志]
    @Test
    void testST009T05() {
        ST009InputBO input = buildInput();
        lenient().when(fmClientCopyBcc.findByEo(any(FmClientCopyEO.class))).thenReturn(List.of(buildClientCopy()));
        lenient().when(tbVoucherDefBcc.findByDocType(DocType.VALUE_737)).thenReturn(buildVoucherDef());
        lenient().when(st036.execute(any(ST036InputBO.class))).thenReturn(buildSt036Out(null));

        ST009OutputBO result = pbc.execute(input);

        assertEquals(true, result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getAuthorizationFlag());
    }

    // 场景：REQ-005-S02（ST009-TC006），执行结果为提醒（dealFlow=D），按提醒与通过同分支返回通过，不设置[授权标志]
    @Test
    void testST009T06() {
        ST009InputBO input = buildInput();
        lenient().when(fmClientCopyBcc.findByEo(any(FmClientCopyEO.class))).thenReturn(List.of(buildClientCopy()));
        lenient().when(tbVoucherDefBcc.findByDocType(DocType.VALUE_737)).thenReturn(buildVoucherDef());
        lenient().when(st036.execute(any(ST036InputBO.class))).thenReturn(buildSt036Out(DealFlow.D));

        ST009OutputBO result = pbc.execute(input);

        assertEquals(true, result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertNull(result.getAuthorizationFlag());
    }

    // 场景：REQ-005-S03（ST009-TC007），执行结果为授权（dealFlow=A），设置[授权标志]="是"，步骤正常结束
    @Test
    void testST009T07() {
        ST009InputBO input = buildInput();
        lenient().when(fmClientCopyBcc.findByEo(any(FmClientCopyEO.class))).thenReturn(List.of(buildClientCopy()));
        lenient().when(tbVoucherDefBcc.findByDocType(DocType.VALUE_737)).thenReturn(buildVoucherDef());
        lenient().when(st036.execute(any(ST036InputBO.class))).thenReturn(buildSt036Out(DealFlow.A));

        ST009OutputBO result = pbc.execute(input);

        assertEquals(true, result.isSucceed());
        assertNull(result.getErrorCode());
        assertNull(result.getErrorMessage());
        assertEquals("是", result.getAuthorizationFlag());
    }

    // 场景：REQ-005-S04（ST009-TC008），执行结果为拒绝（dealFlow=B），步骤业务失败返回错误码 ER0003，不设置[授权标志]
    @Test
    void testST009T08() {
        ST009InputBO input = buildInput();
        lenient().when(fmClientCopyBcc.findByEo(any(FmClientCopyEO.class))).thenReturn(List.of(buildClientCopy()));
        lenient().when(tbVoucherDefBcc.findByDocType(DocType.VALUE_737)).thenReturn(buildVoucherDef());
        lenient().when(st036.execute(any(ST036InputBO.class))).thenReturn(buildSt036Out(DealFlow.B));

        ST009OutputBO result = pbc.execute(input);

        assertEquals(false, result.isSucceed());
        assertEquals("ER0003", result.getErrorCode());
        assertNull(result.getAuthorizationFlag());
        // errorMessage 业务说明文案未提供（TBD-5），不做等值断言
    }
}
