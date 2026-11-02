package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

import com.dcits.deposit.facade.bo.ST037InputBO;
import com.dcits.deposit.facade.bo.ST037OutputBO;
import com.dcits.deposit.facade.components.IRbLimitCtrlConfBcc;
import com.dcits.deposit.facade.components.IRbLimitCtrlCustomInfoBcc;
import com.dcits.deposit.facade.eo.RbLimitCtrlConfEO;
import com.dcits.deposit.facade.eo.RbLimitCtrlCustomInfoEO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ST037 获取限额场景编码 步骤实现单元测试。
 *
 * <p>覆盖正式 Spec REQ-001~REQ-008 已确认场景（测试用例 ST037-TC001~TC008）：
 * 允许自定义标识为否直接返回、查询生效中的自定义限额、自定义限额存在时的
 * 临时限额标志判定、自定义限额不存在时的仅检查客户自定义标志判定，以及输入
 * 输出契约回显。待确认事项 1~7 对应行为不作为本套用例断言。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST037PbcTest {

    @Mock
    private IRbLimitCtrlConfBcc limitCtrlConfBcc;

    @Mock
    private IRbLimitCtrlCustomInfoBcc limitCtrlCustomInfoBcc;

    @InjectMocks
    private ST037Pbc pbc;

    private ST037InputBO buildInput() throws Exception {
        ST037InputBO input = new ST037InputBO();
        input.setBaseAcctNo("622000010001");
        input.setClientNo("C001");
        input.setLimitSceneNo("LS001");
        input.setTranDate(new SimpleDateFormat("yyyy-MM-dd").parse("2026-10-31"));
        return input;
    }

    // 场景：REQ-001-S01/REQ-002-S01（ST037-TC001），配置表存在 limitSceneNo="LS001" 记录且 allowCustomFlag="N-否"，
    // 步骤输出配置来源字段并直接返回输入限额场景编码
    @Test
    void testST037T01() throws Exception {
        ST037InputBO input = buildInput();
        RbLimitCtrlConfEO confRec = new RbLimitCtrlConfEO();
        confRec.setLimitSceneNo("LS001");
        confRec.setAllowCustomFlag("N-否");
        confRec.setOnlyCustom("N-否");
        confRec.setTempLimitFlag("Y-是");
        confRec.setTempLimitValidTerm("30");
        when(limitCtrlConfBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneNo()))))
                .thenReturn(List.of(confRec));

        ST037OutputBO out = pbc.execute(input);

        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("LS001", out.getLimitSceneNo());
        assertEquals("N-否", out.getAllowCustomFlag());
        assertEquals("N-否", out.getOnlyCustom());
        assertEquals("Y-是", out.getTempLimitFlag());
        assertEquals("30", out.getTempLimitValidTerm());
    }

    // 场景：REQ-002-S01（ST037-TC002），allowCustomFlag="N-否"，步骤不查询自定义限额，返回 limitSceneNo 等于输入值
    @Test
    void testST037T02() throws Exception {
        ST037InputBO input = buildInput();
        RbLimitCtrlConfEO confRec = new RbLimitCtrlConfEO();
        confRec.setLimitSceneNo("LS001");
        confRec.setAllowCustomFlag("N-否");
        when(limitCtrlConfBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneNo()))))
                .thenReturn(List.of(confRec));

        ST037OutputBO out = pbc.execute(input);

        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("LS001", out.getLimitSceneNo());
    }

    // 场景：REQ-003-S01（ST037-TC003），allowCustomFlag="Y-是" 跳转《获取自定义限额》，查询到 effectDate=2026-10-01 ≤
    // tranDate=2026-10-31 的自定义限额并输出；配置 tempLimitFlag="N-否" 使限额值检查走 REQ-005 分支返回原编码
    @Test
    void testST037T03() throws Exception {
        ST037InputBO input = buildInput();
        RbLimitCtrlConfEO confRec = new RbLimitCtrlConfEO();
        confRec.setLimitSceneNo("LS001");
        confRec.setAllowCustomFlag("Y-是");
        confRec.setTempLimitFlag("N-否");
        when(limitCtrlConfBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneNo()))))
                .thenReturn(List.of(confRec));
        RbLimitCtrlCustomInfoEO customRec = new RbLimitCtrlCustomInfoEO();
        customRec.setCheckObjVal("622000010001");
        customRec.setLimitSceneNo("LS001");
        customRec.setClientNo("C001");
        customRec.setEffectDate(new SimpleDateFormat("yyyy-MM-dd").parse("2026-10-01"));
        customRec.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").parse("2026-12-31"));
        when(limitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class))).thenReturn(List.of(customRec));

        ST037OutputBO out = pbc.execute(input);

        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("LS001", out.getLimitSceneNo());
        assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2026-10-01"), out.getEffectDate());
        assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2026-12-31"), out.getExpireDate());
    }

    // 场景：REQ-004-S01（ST037-TC004），自定义限额存在、临时限额标志="Y-是"、expireDate=2026-10-30 早于 tranDate=2026-10-31，
    // 返回 limitSceneNo 为空（null 或空串均可）
    @Test
    void testST037T04() throws Exception {
        ST037InputBO input = buildInput();
        RbLimitCtrlConfEO confRec = new RbLimitCtrlConfEO();
        confRec.setLimitSceneNo("LS001");
        confRec.setAllowCustomFlag("Y-是");
        confRec.setTempLimitFlag("Y-是");
        when(limitCtrlConfBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneNo()))))
                .thenReturn(List.of(confRec));
        RbLimitCtrlCustomInfoEO customRec = new RbLimitCtrlCustomInfoEO();
        customRec.setCheckObjVal("622000010001");
        customRec.setLimitSceneNo("LS001");
        customRec.setClientNo("C001");
        customRec.setEffectDate(new SimpleDateFormat("yyyy-MM-dd").parse("2026-10-01"));
        customRec.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").parse("2026-10-30"));
        when(limitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class))).thenReturn(List.of(customRec));

        ST037OutputBO out = pbc.execute(input);

        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertTrue(out.getLimitSceneNo() == null || out.getLimitSceneNo().isEmpty());
    }

    // 场景：REQ-005-S01（ST037-TC005），自定义限额存在、临时限额标志="N-否"，返回 limitSceneNo 等于输入值
    @Test
    void testST037T05() throws Exception {
        ST037InputBO input = buildInput();
        RbLimitCtrlConfEO confRec = new RbLimitCtrlConfEO();
        confRec.setLimitSceneNo("LS001");
        confRec.setAllowCustomFlag("Y-是");
        confRec.setTempLimitFlag("N-否");
        when(limitCtrlConfBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneNo()))))
                .thenReturn(List.of(confRec));
        RbLimitCtrlCustomInfoEO customRec = new RbLimitCtrlCustomInfoEO();
        customRec.setCheckObjVal("622000010001");
        customRec.setLimitSceneNo("LS001");
        customRec.setClientNo("C001");
        customRec.setEffectDate(new SimpleDateFormat("yyyy-MM-dd").parse("2026-10-01"));
        customRec.setExpireDate(new SimpleDateFormat("yyyy-MM-dd").parse("2026-12-31"));
        when(limitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class))).thenReturn(List.of(customRec));

        ST037OutputBO out = pbc.execute(input);

        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("LS001", out.getLimitSceneNo());
    }

    // 场景：REQ-006-S01（ST037-TC006），自定义限额查询返回空集合、配置仅检查客户自定义标志="Y-是"，返回 limitSceneNo 为空（null 或空串均可）
    @Test
    void testST037T06() throws Exception {
        ST037InputBO input = buildInput();
        RbLimitCtrlConfEO confRec = new RbLimitCtrlConfEO();
        confRec.setLimitSceneNo("LS001");
        confRec.setAllowCustomFlag("Y-是");
        confRec.setOnlyCustom("Y-是");
        when(limitCtrlConfBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneNo()))))
                .thenReturn(List.of(confRec));
        when(limitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class))).thenReturn(List.of());

        ST037OutputBO out = pbc.execute(input);

        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertTrue(out.getLimitSceneNo() == null || out.getLimitSceneNo().isEmpty());
    }

    // 场景：REQ-007-S01（ST037-TC007），自定义限额查询返回空集合、配置仅检查客户自定义标志="N-否"，返回 limitSceneNo 等于输入值
    @Test
    void testST037T07() throws Exception {
        ST037InputBO input = buildInput();
        RbLimitCtrlConfEO confRec = new RbLimitCtrlConfEO();
        confRec.setLimitSceneNo("LS001");
        confRec.setAllowCustomFlag("Y-是");
        confRec.setOnlyCustom("N-否");
        when(limitCtrlConfBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneNo()))))
                .thenReturn(List.of(confRec));
        when(limitCtrlCustomInfoBcc.findByEo(any(RbLimitCtrlCustomInfoEO.class))).thenReturn(List.of());

        ST037OutputBO out = pbc.execute(input);

        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("LS001", out.getLimitSceneNo());
    }

    // 场景：REQ-008-S01（ST037-TC008），allowCustomFlag="N-否" 直接返回分支，按输出契约回显 baseAcctNo、clientNo 并输出本分支字段
    @Test
    void testST037T08() throws Exception {
        ST037InputBO input = buildInput();
        RbLimitCtrlConfEO confRec = new RbLimitCtrlConfEO();
        confRec.setLimitSceneNo("LS001");
        confRec.setAllowCustomFlag("N-否");
        when(limitCtrlConfBcc.findByEo(argThat(eo -> eo != null && "LS001".equals(eo.getLimitSceneNo()))))
                .thenReturn(List.of(confRec));

        ST037OutputBO out = pbc.execute(input);

        assertEquals(true, out.isSucceed());
        assertNull(out.getErrorCode());
        assertNull(out.getErrorMessage());
        assertEquals("LS001", out.getLimitSceneNo());
        assertEquals("N-否", out.getAllowCustomFlag());
        assertEquals("622000010001", out.getBaseAcctNo());
        assertEquals("C001", out.getClientNo());
    }
}
