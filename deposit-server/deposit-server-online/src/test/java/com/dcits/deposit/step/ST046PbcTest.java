package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.deposit.enums.AcctCcy;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.AcctStatus;
import com.dcits.deposit.enums.AllDepInd;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.CheckCertificateType;
import com.dcits.deposit.enums.FarmerFlag;
import com.dcits.deposit.enums.IntIndFlag;
import com.dcits.deposit.enums.ManageType;
import com.dcits.deposit.enums.RbAcctType;
import com.dcits.deposit.enums.SimpleAcct;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST046InputBO;
import com.dcits.deposit.facade.bo.ST046OutputBO;
import com.dcits.deposit.facade.components.IRbBusAcctBcc;
import com.dcits.deposit.facade.eo.RbBusAcctEO;

/**
 * ST046 登记账户信息 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST046-TC001 ~ ST046-TC015，对应行为规格 REQ-001-S01 ~ REQ-009-S01）。
 *
 * 本步骤唯一持久化依赖为 IRbBusAcctBcc（RB_BUS_ACCT 数据服务），以构造器注入被测 ST046Pbc 真实执行；
 * createSelective 桩以 thenAnswer 记录取值供数据断言（不使用 verify/次数统计）。
 * SPEC 声明无业务失败场景（失败仅由技术异常传播表达），无业务错误码可断言；
 * checkCertificateType、acctLicenseNo 属已接受的需求处理结论（豁免）范围，全部用例不做值断言。
 */
@ExtendWith(MockitoExtension.class)
public class ST046PbcTest {

    @Mock
    private IRbBusAcctBcc rbBusAcctBcc;

    @InjectMocks
    private ST046Pbc st046Pbc;

    /** 构造公共输入基线（outputs/测试用例.md「公共输入基线」30 项），各用例仅按差异字段覆盖 */
    private ST046InputBO buildBaseInput() throws Exception {
        ST046InputBO input = new ST046InputBO();
        input.setAllowSuspendFlag("是");
        input.setManageFlag("是");
        input.setManageContent("购房资金监管");
        input.setManageType(ManageType.VALUE_1);
        input.setAnnualFlag("是");
        input.setSimpleAcct(SimpleAcct.N);
        input.setFarmerFlag(FarmerFlag.VALUE_2);
        input.setIsSellCheque("否");
        input.setLineOwnerShip("零售条线");
        input.setAcctExecName("客户经理甲");
        input.setAcctExecCode("E0001");
        input.setPromoterName("推介人乙");
        input.setPromoterCode("P0001");
        input.setCheckCertificateAmt(new BigDecimal("100000.00"));
        input.setClientNo("C000001234");
        input.setBaseAcctNo("200001000001");
        input.setAcctCcy(AcctCcy.CNY);
        input.setProdNo("PD0001");
        input.setTranBranch(TranBranch.VALUE_351155);
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2026-09-24");
        input.setAcctOpenDate(date);
        input.setEffectDate(date);
        input.setRbAcctType(RbAcctType.C);
        input.setAcctStatus(AcctStatus.A);
        input.setAllDepInd(AllDepInd.N001);
        input.setAllDraInd(AllDraInd.N001);
        input.setAcctNatureNo(AcctNatureNo.VALUE_11001);
        input.setIntIndFlag(IntIndFlag.Y);
        input.setAcctLicenseNo("LXK2026001");
        input.setApprLetterNo("AL2026001");
        input.setCheckCertificateType(CheckCertificateType.VALUE_03);
        return input;
    }

    /** 公共桩（TC001–TC014）：createSelective 记录取值并返回 1，返回写入记录列表（断言目标为最终写入记录） */
    private List<RbBusAcctEO> stubCreateSelective() {
        List<RbBusAcctEO> written = new ArrayList<>();
        Mockito.lenient().when(rbBusAcctBcc.createSelective(Mockito.any(RbBusAcctEO.class)))
                .thenAnswer(invocation -> {
                    written.add(invocation.getArgument(0));
                    return 1;
                });
        return written;
    }

    /** 成功三项断言：succeed=true、errorCode/errorMessage=null */
    private void assertSucceed(ST046OutputBO output) {
        assertTrue(output.isSucceed());
        assertNull(output.getErrorCode());
        assertNull(output.getErrorMessage());
    }

    /** 子步骤1 的 11 项无条件辅助信息：写入记录与输出逐项与输入相等 */
    private void assertAuxiliary11(RbBusAcctEO record, ST046OutputBO output, ST046InputBO input) {
        assertEquals(input.getAllowSuspendFlag(), record.getAllowSuspendFlag());
        assertEquals(input.getManageFlag(), record.getManageFlag());
        assertEquals(input.getAnnualFlag(), record.getAnnualFlag());
        assertEquals(input.getSimpleAcct(), record.getSimpleAcct());
        assertEquals(input.getFarmerFlag(), record.getFarmerFlag());
        assertEquals(input.getIsSellCheque(), record.getIsSellCheque());
        assertEquals(input.getLineOwnerShip(), record.getLineOwnerShip());
        assertEquals(input.getAcctExecCode(), record.getAcctExecCode());
        assertEquals(input.getAcctExecName(), record.getAcctExecName());
        assertEquals(input.getPromoterCode(), record.getPromoterCode());
        assertEquals(input.getPromoterName(), record.getPromoterName());
        assertEquals(input.getAllowSuspendFlag(), output.getAllowSuspendFlag());
        assertEquals(input.getManageFlag(), output.getManageFlag());
        assertEquals(input.getAnnualFlag(), output.getAnnualFlag());
        assertEquals(input.getSimpleAcct(), output.getSimpleAcct());
        assertEquals(input.getFarmerFlag(), output.getFarmerFlag());
        assertEquals(input.getIsSellCheque(), output.getIsSellCheque());
        assertEquals(input.getLineOwnerShip(), output.getLineOwnerShip());
        assertEquals(input.getAcctExecCode(), output.getAcctExecCode());
        assertEquals(input.getAcctExecName(), output.getAcctExecName());
        assertEquals(input.getPromoterCode(), output.getPromoterCode());
        assertEquals(input.getPromoterName(), output.getPromoterName());
    }

    /** 子步骤2 的 14 项输入映射（tranBranch→acctBranch）在写入记录上逐项与输入相等 */
    private void assertBasicInfoRecord(RbBusAcctEO record, ST046InputBO input) {
        assertEquals(input.getClientNo(), record.getClientNo());
        assertEquals(input.getBaseAcctNo(), record.getBaseAcctNo());
        assertEquals(input.getAcctCcy(), record.getAcctCcy());
        assertEquals(input.getProdNo(), record.getProdNo());
        assertEquals(input.getTranBranch(), record.getAcctBranch());
        assertEquals(input.getAcctOpenDate(), record.getAcctOpenDate());
        assertEquals(input.getAcctStatus(), record.getAcctStatus());
        assertEquals(input.getRbAcctType(), record.getRbAcctType());
        assertEquals(input.getAllDepInd(), record.getAllDepInd());
        assertEquals(input.getAllDraInd(), record.getAllDraInd());
        assertEquals(input.getAcctNatureNo(), record.getAcctNatureNo());
        assertEquals(input.getIntIndFlag(), record.getIntIndFlag());
        assertEquals(input.getApprLetterNo(), record.getApprLetterNo());
        assertEquals(input.getEffectDate(), record.getEffectDate());
    }

    /** 输出表声明的 13 个基本信息输出字段（tranBranch 无输出字段）与登记值相等 */
    private void assertBasicInfoOutput(ST046OutputBO output, ST046InputBO input) {
        assertEquals(input.getClientNo(), output.getClientNo());
        assertEquals(input.getBaseAcctNo(), output.getBaseAcctNo());
        assertEquals(input.getProdNo(), output.getProdNo());
        assertEquals(input.getAcctCcy(), output.getAcctCcy());
        assertEquals(input.getAcctOpenDate(), output.getAcctOpenDate());
        assertEquals(input.getEffectDate(), output.getEffectDate());
        assertEquals(input.getAcctStatus(), output.getAcctStatus());
        assertEquals(input.getRbAcctType(), output.getRbAcctType());
        assertEquals(input.getAcctNatureNo(), output.getAcctNatureNo());
        assertEquals(input.getAllDraInd(), output.getAllDraInd());
        assertEquals(input.getAllDepInd(), output.getAllDepInd());
        assertEquals(input.getIntIndFlag(), output.getIntIndFlag());
        assertEquals(input.getApprLetterNo(), output.getApprLetterNo());
    }

    // TC001 场景（REQ-001-S01）：全量提供辅助信息，子步骤1 的 11 项无条件登记与输入逐项相等，两条件分支均触发，执行成功
    @Test
    public void testST046T01() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertAuxiliary11(record, output, input);
    }

    // TC002 场景（REQ-001-S02）：5 项非必填辅助信息为 null，登记项保持为空不赋默认值，其余 6 项无条件登记且监管/查证条件分支不受影响
    @Test
    public void testST046T02() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();
        input.setLineOwnerShip(null);
        input.setAcctExecName(null);
        input.setAcctExecCode(null);
        input.setPromoterName(null);
        input.setPromoterCode(null);

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertNull(record.getLineOwnerShip());
        assertNull(record.getAcctExecName());
        assertNull(record.getAcctExecCode());
        assertNull(record.getPromoterName());
        assertNull(record.getPromoterCode());
        assertNull(output.getLineOwnerShip());
        assertNull(output.getAcctExecName());
        assertNull(output.getAcctExecCode());
        assertNull(output.getPromoterName());
        assertNull(output.getPromoterCode());
        assertEquals("是", record.getAllowSuspendFlag());
        assertEquals("是", record.getManageFlag());
        assertEquals("是", record.getAnnualFlag());
        assertEquals("否", record.getIsSellCheque());
        assertEquals(SimpleAcct.N, record.getSimpleAcct());
        assertEquals(FarmerFlag.VALUE_2, record.getFarmerFlag());
        assertEquals(ManageType.VALUE_1, record.getManageType());
        assertEquals("购房资金监管", record.getManageContent());
        assertEquals(0, record.getCheckCertificateAmt().compareTo(new BigDecimal("100000.00")));
        assertEquals(ManageType.VALUE_1, output.getManageType());
        assertEquals("购房资金监管", output.getManageContent());
        assertEquals(0, output.getCheckCertificateAmt().compareTo(new BigDecimal("100000.00")));
    }

    // TC003 场景（REQ-002-S01）：监管账户标志为"是"，登记监管账户类型=ManageType.VALUE_1、监管原因="购房资金监管"（查证金额分支以 VALUE_01 隔离）
    @Test
    public void testST046T03() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();
        input.setCheckCertificateType(CheckCertificateType.VALUE_01);

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertEquals(ManageType.VALUE_1, record.getManageType());
        assertEquals("购房资金监管", record.getManageContent());
        assertEquals(ManageType.VALUE_1, output.getManageType());
        assertEquals("购房资金监管", output.getManageContent());
    }

    // TC004 场景（REQ-002-S02）：监管账户标志为"否"，manageType/manageContent 已提供但不登记，记录与输出保持为空，manageFlag 本身按"否"无条件登记
    @Test
    public void testST046T04() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();
        input.setManageFlag("否");

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertNull(record.getManageType());
        assertNull(record.getManageContent());
        assertNull(output.getManageType());
        assertNull(output.getManageContent());
        assertEquals("否", record.getManageFlag());
        assertEquals("否", output.getManageFlag());
    }

    // TC005 场景（REQ-003-S01）：查证类型为对资金类业务查证（VALUE_03），登记查证金额且与输入 BigDecimal 同值（监管分支以"否"隔离）
    @Test
    public void testST046T05() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();
        input.setManageFlag("否");

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertEquals(0, record.getCheckCertificateAmt().compareTo(new BigDecimal("100000.00")));
        assertEquals(0, output.getCheckCertificateAmt().compareTo(new BigDecimal("100000.00")));
    }

    // TC006 场景（REQ-003-S02）：查证类型为其他取值（VALUE_01 全部查证），查证金额已提供但不登记，记录与输出为空
    @Test
    public void testST046T06() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();
        input.setCheckCertificateType(CheckCertificateType.VALUE_01);

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertNull(record.getCheckCertificateAmt());
        assertNull(output.getCheckCertificateAmt());
    }

    // TC007 场景（REQ-003-S03）：查证类型未提供（null 非必填边界），查证金额已提供但不登记；按豁免结论不对 checkCertificateType 登记值断言
    @Test
    public void testST046T07() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();
        input.setCheckCertificateType(null);

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertNull(record.getCheckCertificateAmt());
        assertNull(output.getCheckCertificateAmt());
    }

    // TC008 场景（REQ-004-S01）：全量提供基本信息，14 项输入映射登记与输入逐项相等（tranBranch 落 acctBranch），输出 13 个对应字段与登记值一致
    @Test
    public void testST046T08() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertEquals("C000001234", record.getClientNo());
        assertEquals("200001000001", record.getBaseAcctNo());
        assertEquals("PD0001", record.getProdNo());
        assertEquals(TranBranch.VALUE_351155, record.getAcctBranch());
        assertEquals(AcctCcy.CNY, record.getAcctCcy());
        assertEquals(AcctStatus.A, record.getAcctStatus());
        assertEquals(RbAcctType.C, record.getRbAcctType());
        assertEquals(AllDepInd.N001, record.getAllDepInd());
        assertEquals(AllDraInd.N001, record.getAllDraInd());
        assertEquals(AcctNatureNo.VALUE_11001, record.getAcctNatureNo());
        assertEquals(IntIndFlag.Y, record.getIntIndFlag());
        assertEquals(input.getAcctOpenDate(), record.getAcctOpenDate());
        assertEquals(input.getEffectDate(), record.getEffectDate());
        assertEquals("AL2026001", record.getApprLetterNo());
        assertBasicInfoRecord(record, input);
        assertBasicInfoOutput(output, input);
    }

    // TC009 场景（REQ-004-S02）：核准件编号为 null，登记项保持为空，其余 13 项基本信息映射登记不受影响
    @Test
    public void testST046T09() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();
        input.setApprLetterNo(null);

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertNull(record.getApprLetterNo());
        assertNull(output.getApprLetterNo());
        assertBasicInfoRecord(record, input);
        assertBasicInfoOutput(output, input);
    }

    // TC010 场景（REQ-005-S01）：internalKey 由系统根据账号生成、非空 Integer 且为主键，经 findByByPrimaryKey 桩内回放可定位本步骤形成的记录（不断言生成算法与确定性）
    @Test
    public void testST046T10() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertNotNull(record.getInternalKey());
        Mockito.lenient().when(rbBusAcctBcc.findByPrimaryKey(record.getInternalKey())).thenReturn(record);
        RbBusAcctEO found = rbBusAcctBcc.findByPrimaryKey(record.getInternalKey());
        assertSame(record, found);
        assertEquals("200001000001", found.getBaseAcctNo());
        assertEquals("C000001234", found.getClientNo());
    }

    // TC011 场景（REQ-006-S01）：创建时间戳与最后修改时间戳为执行时点系统时间，非空且非空串，不来自任何输入（格式不作断言依据）
    @Test
    public void testST046T11() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertNotNull(record.getCreateTimestamp());
        assertFalse(record.getCreateTimestamp().isEmpty());
        assertNotNull(record.getLastUpdTimestamp());
        assertFalse(record.getLastUpdTimestamp().isEmpty());
    }

    // TC012 场景（REQ-007-S01）：两条件均触发、非必填辅助信息 5 项均提供时，同一条 RB_BUS_ACCT 记录承载两个子步骤的全部登记结果与系统生成项
    @Test
    public void testST046T12() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertAuxiliary11(record, output, input);
        assertEquals(ManageType.VALUE_1, record.getManageType());
        assertEquals("购房资金监管", record.getManageContent());
        assertEquals(0, record.getCheckCertificateAmt().compareTo(new BigDecimal("100000.00")));
        assertBasicInfoRecord(record, input);
        assertNotNull(record.getInternalKey());
        assertNotNull(record.getCreateTimestamp());
        assertNotNull(record.getLastUpdTimestamp());
    }

    // TC013 场景（REQ-008-S01）：输出与登记值一致，27 个有登记来源的输出字段与登记值逐项相等；反射验证输出仅声明 29 个业务字段且不含 tranBranch/internalKey/createTimestamp/lastUpdTimestamp
    @Test
    public void testST046T13() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        RbBusAcctEO record = written.get(written.size() - 1);
        assertAuxiliary11(record, output, input);
        assertBasicInfoRecord(record, input);
        assertBasicInfoOutput(output, input);
        assertEquals(ManageType.VALUE_1, output.getManageType());
        assertEquals("购房资金监管", output.getManageContent());
        assertEquals(0, output.getCheckCertificateAmt().compareTo(new BigDecimal("100000.00")));
        Set<String> declaredNames = new HashSet<>();
        for (Field field : ST046OutputBO.class.getDeclaredFields()) {
            declaredNames.add(field.getName());
        }
        assertEquals(29, declaredNames.size());
        assertFalse(declaredNames.contains("tranBranch"));
        assertFalse(declaredNames.contains("internalKey"));
        assertFalse(declaredNames.contains("createTimestamp"));
        assertFalse(declaredNames.contains("lastUpdTimestamp"));
    }

    // TC014 场景（REQ-008-S02）：监管与查证条件均不触发时，输出中监管账户类型、监管原因、查证金额为空，其余 24 个有登记来源的输出字段与登记值相等
    @Test
    public void testST046T14() throws Exception {
        List<RbBusAcctEO> written = stubCreateSelective();
        ST046InputBO input = buildBaseInput();
        input.setManageFlag("否");
        input.setCheckCertificateType(CheckCertificateType.VALUE_01);

        ST046OutputBO output = st046Pbc.execute(input);

        assertSucceed(output);
        assertNull(output.getManageType());
        assertNull(output.getManageContent());
        assertNull(output.getCheckCertificateAmt());
        assertAuxiliary11(written.get(written.size() - 1), output, input);
        assertBasicInfoOutput(output, input);
    }

    // TC015 场景（REQ-009-S01）：RB_BUS_ACCT 写入时抛出技术异常（模拟主键约束冲突），异常原样向调用方传播，不被转换、包装或吞没为业务失败输出
    @Test
    public void testST046T15() throws Exception {
        RuntimeException failure = new RuntimeException("RB_BUS_ACCT 写入技术异常：模拟主键约束冲突");
        Mockito.lenient().when(rbBusAcctBcc.createSelective(Mockito.any(RbBusAcctEO.class)))
                .thenThrow(failure);
        ST046InputBO input = buildBaseInput();

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> st046Pbc.execute(input));

        assertSame(failure, thrown);
    }
}
