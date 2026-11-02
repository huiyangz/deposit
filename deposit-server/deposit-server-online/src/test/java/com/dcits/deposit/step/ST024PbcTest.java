package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.IsOverMonthSeasonOd;
import com.dcits.deposit.facade.bo.ST024InputBO;
import com.dcits.deposit.facade.bo.ST024OutputBO;
import com.dcits.deposit.facade.components.IRbBusAgreementOverdraftBcc;
import com.dcits.deposit.facade.components.IRbOdWhiteLimitInfoBcc;
import com.dcits.deposit.facade.eo.RbBusAgreementOverdraftEO;
import com.dcits.deposit.facade.eo.RbOdWhiteLimitInfoEO;

/**
 * ST024 检查法人透支金额 单元测试。
 *
 * <p>用例对应 Spec 场景：REQ-001-S01、REQ-002-S01/S02/S03、REQ-003-S01/S02、
 * REQ-004-S01、REQ-005-S01/S02，方法 testST024T01–testST024T09。</p>
 *
 * <p>贷款客户端 {@link ExternalTaskClient} 为已加载的具体类，当前 JDK 26 下 Mockito 5.14.2
 * 内联 mock（byte-buddy 1.15.11 官方支持上限为 Java 24）无法对其创建实例 mock，故不以
 * {@code @Mock} 设桩，改用 {@link #injectExternalTaskClient(BigDecimal, AtomicReference)}
 * 注入手写子类替身覆盖 {@code calcAcctDailyLoanAmt}；其余 BCC 均为接口 mock。</p>
 */
@ExtendWith(MockitoExtension.class)
class ST024PbcTest {

	/** 示例账号 */
	private static final String ACCT_NO = "6222020200000000001";

	/** 当日累计透支额度返回键（贷款组件《计算账号当日放款金额合计》） */
	private static final String KEY_DAILY_OVERDRAFT_AMT = "dailyOverdraftAmt";

	@Mock
	private IRbBusAgreementOverdraftBcc rbBusAgreementOverdraftBcc;

	@Mock
	private IRbOdWhiteLimitInfoBcc rbOdWhiteLimitInfoBcc;

	@InjectMocks
	private ST024Pbc st024Pbc;

	// 场景 REQ-001-S01：完整走通步骤 1–7，全部检查通过，正常完成并产生三个非必填输出（靠档跨月季标识为跨月）
	@Test
	void testST024T01() {
		// 桩：协议查询按账号返回跨月（M）记录
		lenient().when(rbBusAgreementOverdraftBcc.findByEo(any(RbBusAgreementOverdraftEO.class)))
				.thenReturn(List.of(buildAgreement(IsOverMonthSeasonOd.M)));
		// 桩：白名单查询返回单笔透支检查金额 50000.00、同一支付对象当日累计透支金额 200000.00
		lenient().when(rbOdWhiteLimitInfoBcc.findByEo(any(RbOdWhiteLimitInfoEO.class)))
				.thenReturn(List.of(buildWhiteLimit("50000.00", "200000.00")));
		// 桩：贷款组件按账号返回当日累计透支额度 0.00（手写子类替身）
		injectExternalTaskClient(new BigDecimal("0.00"), null);

		ST024OutputBO result = st024Pbc.execute(buildInput(ACCT_NO, "1000.00"));

		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals("Y-是", result.getIsCrossFlag());
		assertEquals(new BigDecimal("50000.00"), result.getOdPtAmt());
		assertEquals(new BigDecimal("200000.00"), result.getSameObjectPdOdCumulative());
	}

	// 场景 REQ-002-S01：靠档跨月季标识为跨月（M）时，靠档计息跨月跨季标志赋值为"Y-是"
	@Test
	void testST024T02() {
		// 桩：协议查询返回跨月（M）记录
		lenient().when(rbBusAgreementOverdraftBcc.findByEo(any(RbBusAgreementOverdraftEO.class)))
				.thenReturn(List.of(buildAgreement(IsOverMonthSeasonOd.M)));
		// 桩：白名单查询（isCrossFlag="Y-是"）返回两个金额
		lenient().when(rbOdWhiteLimitInfoBcc.findByEo(any(RbOdWhiteLimitInfoEO.class)))
				.thenReturn(List.of(buildWhiteLimit("50000.00", "200000.00")));
		// 桩：贷款组件返回当日累计透支额度 0.00（手写子类替身）
		injectExternalTaskClient(new BigDecimal("0.00"), null);

		ST024OutputBO result = st024Pbc.execute(buildInput(ACCT_NO, "1000.00"));

		assertEquals("Y-是", result.getIsCrossFlag());
		assertTrue(result.isSucceed());
	}

	// 场景 REQ-002-S02：靠档跨月季标识为跨季（Q）时，靠档计息跨月跨季标志赋值为"Y-是"
	@Test
	void testST024T03() {
		// 桩：协议查询返回跨季（Q）记录
		lenient().when(rbBusAgreementOverdraftBcc.findByEo(any(RbBusAgreementOverdraftEO.class)))
				.thenReturn(List.of(buildAgreement(IsOverMonthSeasonOd.Q)));
		// 桩：白名单查询（isCrossFlag="Y-是"）返回两个金额
		lenient().when(rbOdWhiteLimitInfoBcc.findByEo(any(RbOdWhiteLimitInfoEO.class)))
				.thenReturn(List.of(buildWhiteLimit("50000.00", "200000.00")));
		// 桩：贷款组件返回当日累计透支额度 0.00（手写子类替身）
		injectExternalTaskClient(new BigDecimal("0.00"), null);

		ST024OutputBO result = st024Pbc.execute(buildInput(ACCT_NO, "1000.00"));

		assertEquals("Y-是", result.getIsCrossFlag());
		assertTrue(result.isSucceed());
	}

	// 场景 REQ-002-S03：靠档跨月季标识为不跨月/季（N）时，靠档计息跨月跨季标志赋值为"否"
	@Test
	void testST024T04() {
		// 桩：协议查询返回不跨月/季（N）记录
		lenient().when(rbBusAgreementOverdraftBcc.findByEo(any(RbBusAgreementOverdraftEO.class)))
				.thenReturn(List.of(buildAgreement(IsOverMonthSeasonOd.N)));
		// 桩：白名单查询（isCrossFlag="否"）返回两个金额
		lenient().when(rbOdWhiteLimitInfoBcc.findByEo(any(RbOdWhiteLimitInfoEO.class)))
				.thenReturn(List.of(buildWhiteLimit("50000.00", "200000.00")));
		// 桩：贷款组件返回当日累计透支额度 0.00（手写子类替身）
		injectExternalTaskClient(new BigDecimal("0.00"), null);

		ST024OutputBO result = st024Pbc.execute(buildInput(ACCT_NO, "1000.00"));

		assertEquals("否", result.getIsCrossFlag());
		assertTrue(result.isSucceed());
	}

	// 场景 REQ-003-S01：交易金额（60000.00）大于单笔透支检查金额（50000.00），步骤 4 返回 ER0061 业务失败，不执行步骤 5–7
	@Test
	void testST024T05() {
		// 桩：协议查询返回跨月（M）记录
		lenient().when(rbBusAgreementOverdraftBcc.findByEo(any(RbBusAgreementOverdraftEO.class)))
				.thenReturn(List.of(buildAgreement(IsOverMonthSeasonOd.M)));
		// 桩：白名单查询返回单笔透支检查金额 50000.00（步骤 5–7 不触达，不设贷款客户端桩）
		lenient().when(rbOdWhiteLimitInfoBcc.findByEo(any(RbOdWhiteLimitInfoEO.class)))
				.thenReturn(List.of(buildWhiteLimit("50000.00", null)));

		ST024OutputBO result = st024Pbc.execute(buildInput(ACCT_NO, "60000.00"));

		assertFalse(result.isSucceed());
		assertEquals("ER0061", result.getErrorCode());
		assertNotNull(result.getErrorMessage());
		assertTrue(result.getErrorMessage().startsWith("ER0061::"));
		assertTrue(result.getErrorMessage().contains("交易金额超出单笔透支检查金额"));
	}

	// 场景 REQ-003-S02：交易金额（30000.00）未超过单笔透支检查金额（50000.00），步骤 4 不返回错误，继续执行步骤 5
	@Test
	void testST024T06() {
		// 桩：协议查询返回跨月（M）记录
		lenient().when(rbBusAgreementOverdraftBcc.findByEo(any(RbBusAgreementOverdraftEO.class)))
				.thenReturn(List.of(buildAgreement(IsOverMonthSeasonOd.M)));
		// 桩：白名单查询返回单笔透支检查金额 50000.00、同一支付对象当日累计透支金额 200000.00
		lenient().when(rbOdWhiteLimitInfoBcc.findByEo(any(RbOdWhiteLimitInfoEO.class)))
				.thenReturn(List.of(buildWhiteLimit("50000.00", "200000.00")));
		// 桩：贷款组件返回当日累计透支额度 0.00（手写子类替身）
		injectExternalTaskClient(new BigDecimal("0.00"), null);

		ST024OutputBO result = st024Pbc.execute(buildInput(ACCT_NO, "30000.00"));

		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertEquals(new BigDecimal("50000.00"), result.getOdPtAmt());
	}

	// 场景 REQ-004-S01：步骤 5 以 baseAcctNo 调用贷款组件取得当日累计透支额度（60000.00），供步骤 7 累加使用，不作为步骤输出
	@Test
	void testST024T07() {
		// 桩：协议查询返回跨月（M）记录
		lenient().when(rbBusAgreementOverdraftBcc.findByEo(any(RbBusAgreementOverdraftEO.class)))
				.thenReturn(List.of(buildAgreement(IsOverMonthSeasonOd.M)));
		// 桩：白名单查询返回单笔透支检查金额 50000.00、同一支付对象当日累计透支金额 200000.00
		lenient().when(rbOdWhiteLimitInfoBcc.findByEo(any(RbOdWhiteLimitInfoEO.class)))
				.thenReturn(List.of(buildWhiteLimit("50000.00", "200000.00")));
		// 桩：贷款组件按账号返回当日累计透支额度 60000.00，并记录替身收到的 acctNo（手写子类替身）
		AtomicReference<String> capturedAcctNo = new AtomicReference<>();
		injectExternalTaskClient(new BigDecimal("60000.00"), capturedAcctNo);

		ST024OutputBO result = st024Pbc.execute(buildInput(ACCT_NO, "30000.00"));

		// 步骤 7 累加 60000.00 + 30000.00 = 90000.00 未超 200000.00，正常完成；dailyOverdraftAmt 不进入输出表
		assertEquals(ACCT_NO, capturedAcctNo.get());
		assertTrue(result.isSucceed());
		assertEquals("Y-是", result.getIsCrossFlag());
		assertEquals(new BigDecimal("50000.00"), result.getOdPtAmt());
		assertEquals(new BigDecimal("200000.00"), result.getSameObjectPdOdCumulative());
	}

	// 场景 REQ-005-S01：当日累计透支额度（60000.00）加交易金额（50000.00）大于同一支付对象当日累计透支金额（100000.00），步骤 7 返回 ER0053 业务失败，不跳转
	@Test
	void testST024T08() {
		// 桩：协议查询返回跨月（M）记录
		lenient().when(rbBusAgreementOverdraftBcc.findByEo(any(RbBusAgreementOverdraftEO.class)))
				.thenReturn(List.of(buildAgreement(IsOverMonthSeasonOd.M)));
		// 桩：白名单查询返回单笔透支检查金额 50000.00、同一支付对象当日累计透支金额 100000.00
		lenient().when(rbOdWhiteLimitInfoBcc.findByEo(any(RbOdWhiteLimitInfoEO.class)))
				.thenReturn(List.of(buildWhiteLimit("50000.00", "100000.00")));
		// 桩：贷款组件返回当日累计透支额度 60000.00（手写子类替身）
		injectExternalTaskClient(new BigDecimal("60000.00"), null);

		ST024OutputBO result = st024Pbc.execute(buildInput(ACCT_NO, "50000.00"));

		assertFalse(result.isSucceed());
		assertEquals("ER0053", result.getErrorCode());
		assertNotNull(result.getErrorMessage());
		assertTrue(result.getErrorMessage().startsWith("ER0053::"));
		assertTrue(result.getErrorMessage().contains("当日累计透支金额已超过同一支付对象单日累计透支金额"));
	}

	// 场景 REQ-005-S02：当日累计透支额度（60000.00）加交易金额（50000.00）未超过同一支付对象当日累计透支金额（200000.00），正常完成并跳转至《检查分行法人透支额度》
	@Test
	void testST024T09() {
		// 桩：协议查询返回跨月（M）记录
		lenient().when(rbBusAgreementOverdraftBcc.findByEo(any(RbBusAgreementOverdraftEO.class)))
				.thenReturn(List.of(buildAgreement(IsOverMonthSeasonOd.M)));
		// 桩：白名单查询返回单笔透支检查金额 50000.00、同一支付对象当日累计透支金额 200000.00
		lenient().when(rbOdWhiteLimitInfoBcc.findByEo(any(RbOdWhiteLimitInfoEO.class)))
				.thenReturn(List.of(buildWhiteLimit("50000.00", "200000.00")));
		// 桩：贷款组件返回当日累计透支额度 60000.00（手写子类替身）
		injectExternalTaskClient(new BigDecimal("60000.00"), null);

		ST024OutputBO result = st024Pbc.execute(buildInput(ACCT_NO, "50000.00"));

		// 步骤 7 累加 60000.00 + 50000.00 = 110000.00 未超 200000.00，正常完成，跳转前提为成功状态
		assertTrue(result.isSucceed());
		assertNull(result.getErrorCode());
		assertNull(result.getErrorMessage());
		assertEquals("Y-是", result.getIsCrossFlag());
		assertEquals(new BigDecimal("50000.00"), result.getOdPtAmt());
		assertEquals(new BigDecimal("200000.00"), result.getSameObjectPdOdCumulative());
	}

	/**
	 * 注入贷款组件《计算账号当日放款金额合计》的测试替身。
	 *
	 * <p>贷款客户端 {@link ExternalTaskClient} 为已加载的具体类，当前 JDK 26 下 Mockito 5.14.2
	 * 内联 mock（byte-buddy 1.15.11 官方支持上限为 Java 24）无法对其创建实例 mock，故不使用
	 * {@code @Mock}，改为手写子类替身覆盖 {@code calcAcctDailyLoanAmt} 并通过反射注入被测实例。
	 * 替身按配置返回返回键 {@code dailyOverdraftAmt} 的值；{@code capturedAcctNo} 非 null 时
	 * 记录替身收到的 acctNo。</p>
	 *
	 * @param dailyOverdraftAmt 当日累计透支额度（返回键 dailyOverdraftAmt 的值）
	 * @param capturedAcctNo 非 null 时记录替身收到的 acctNo
	 */
	private void injectExternalTaskClient(BigDecimal dailyOverdraftAmt, AtomicReference<String> capturedAcctNo) {
		ExternalTaskClient client = new ExternalTaskClient() {
			@Override
			public Map<String, Object> calcAcctDailyLoanAmt(String acctNo) {
				if (capturedAcctNo != null) {
					capturedAcctNo.set(acctNo);
				}
				return Map.of(KEY_DAILY_OVERDRAFT_AMT, dailyOverdraftAmt);
			}
		};
		try {
			Field field = ST024Pbc.class.getDeclaredField("externalTaskClient");
			field.setAccessible(true);
			field.set(st024Pbc, client);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new IllegalStateException("注入 ExternalTaskClient 测试替身失败", e);
		}
	}

	/** 构造输入 BO */
	private ST024InputBO buildInput(String baseAcctNo, String tranAmt) {
		ST024InputBO input = new ST024InputBO();
		input.setBaseAcctNo(baseAcctNo);
		input.setTranAmt(new BigDecimal(tranAmt));
		return input;
	}

	/** 构造对公透支签约表协议记录 */
	private RbBusAgreementOverdraftEO buildAgreement(IsOverMonthSeasonOd isOverMonthSeasonOd) {
		RbBusAgreementOverdraftEO eo = new RbBusAgreementOverdraftEO();
		eo.setIsOverMonthSeasonOd(isOverMonthSeasonOd);
		return eo;
	}

	/** 构造法人透支白名单参数表记录；未提供的金额为 null */
	private RbOdWhiteLimitInfoEO buildWhiteLimit(String odPtAmt, String sameObjectPdOdCumulative) {
		RbOdWhiteLimitInfoEO eo = new RbOdWhiteLimitInfoEO();
		eo.setOdPtAmt(odPtAmt == null ? null : new BigDecimal(odPtAmt));
		eo.setSameObjectPdOdCumulative(sameObjectPdOdCumulative == null ? null : new BigDecimal(sameObjectPdOdCumulative));
		return eo;
	}
}
