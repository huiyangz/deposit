package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.IntBasis;
import com.dcits.deposit.enums.IntType;
import com.dcits.deposit.facade.bo.ST031InputBO;
import com.dcits.deposit.facade.bo.ST031OutputBO;

/**
 * ST031 计算账户执行利率 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST031-TC001 ~ ST031-TC006）。
 *
 * 桩机制说明（依据 outputs/test-results.md 反馈调整）：当前 JDK 26 运行时下，
 * Mockito inline mockmaker 对具体类与静态方法的桩都需要 retransformation，会读取
 * java.lang.Object（class 版本 70），超出工程托管 Byte Buddy 支持的 Java 24（68），
 * 全部 6 例报 "Mockito cannot mock this class: ExternalTaskClient"。工程不可改 POM、
 * 测试命令固定不可加 JVM 参数，故：
 * - 子步骤1 依赖 ExternalTaskClient 为具体类，改用测试子类桩按真实方法签名
 *   override queryProductInterestRate，请求产品编号与预置不一致时桩不生效
 *   （返回 Map 不含 prodIntRate 键），保留用例"参数不符桩不生效"的请求字段核对口径；
 * - 子步骤2 规则 BR002 直接调用真实静态方法，不用 mockStatic；
 *   预期值按 BR002.md 已接受结论与真实运算断言（步骤对规则返回值原样透传，保留标度，
 *   TC002 乘积分支真实标度为 3+4=7，即 1.6500000）。
 */
public class ST031PbcTest {

	/** 构造输入：四项利率定价入参按用例变化，通用交易上下文字段各用例一致 */
	private ST031InputBO buildInput(String prodNo, BigDecimal acctSpreadRate, BigDecimal acctPercentRate,
			BigDecimal acctFixedRate) {
		ST031InputBO input = new ST031InputBO();
		input.setProdNo(prodNo);
		input.setAcctSpreadRate(acctSpreadRate);
		input.setAcctPercentRate(acctPercentRate);
		input.setAcctFixedRate(acctFixedRate);
		// 通用交易上下文字段（来源实体利率税率阶梯表 MB_INT_MATRIX，本步骤两段子步骤逻辑不使用，按必填契约构造）
		input.setIntType(IntType.DR1);
		input.setIntBasis(IntBasis.VALUE_2100);
		input.setBaseRate(new BigDecimal("1.100"));
		input.setActualRate(new BigDecimal("1.500"));
		return input;
	}

	/**
	 * ExternalTaskClient 测试子类桩：仅当请求产品编号与预置一致且预置产品利率非空时，
	 * 返回 Map 含 prodIntRate 键；预置产品利率为 null 表示查询结果未含该键（查询为空）。
	 */
	private static final class StubExternalTaskClient extends ExternalTaskClient {
		private final String prodNo;
		private final BigDecimal prodIntRate;

		private StubExternalTaskClient(String prodNo, BigDecimal prodIntRate) {
			super(new RestTemplate());
			this.prodNo = prodNo;
			this.prodIntRate = prodIntRate;
		}

		@Override
		public Map<String, Object> queryProductInterestRate(String requestProdNo) {
			Map<String, Object> prodIntRateInfo = new HashMap<>();
			if (prodIntRate != null && prodNo.equals(requestProdNo)) {
				prodIntRateInfo.put("prodIntRate", prodIntRate);
			}
			return prodIntRateInfo;
		}
	}

	// TC001 账户利率浮动百分点定价：按 prodNo 取回产品利率1.500，BR002 a 分支 1.500+0.350=1.850
	@Test
	public void testST031T01() {
		ST031Pbc st031Pbc = new ST031Pbc(new StubExternalTaskClient("PD0001", new BigDecimal("1.500")));
		ST031InputBO input = buildInput("PD0001", new BigDecimal("0.350"), null, null);

		ST031OutputBO output = st031Pbc.execute(input);

		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(new BigDecimal("1.850"), output.getRealRate());
	}

	// TC002 账户利率浮动百分比定价：BR002 b 分支 1.500×(1+0.1000)，真实乘法标度 3+4=7 即 1.6500000
	@Test
	public void testST031T02() {
		ST031Pbc st031Pbc = new ST031Pbc(new StubExternalTaskClient("PD0001", new BigDecimal("1.500")));
		ST031InputBO input = buildInput("PD0001", null, new BigDecimal("0.1000"), null);

		ST031OutputBO output = st031Pbc.execute(input);

		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(new BigDecimal("1.6500000"), output.getRealRate());
	}

	// TC003 账户固定利率定价：BR002 c 分支执行利率即账户固定利率 1.200
	@Test
	public void testST031T03() {
		ST031Pbc st031Pbc = new ST031Pbc(new StubExternalTaskClient("PD0001", new BigDecimal("1.500")));
		ST031InputBO input = buildInput("PD0001", null, null, new BigDecimal("1.200"));

		ST031OutputBO output = st031Pbc.execute(input);

		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(new BigDecimal("1.200"), output.getRealRate());
	}

	// TC004 三项账户利率均为 null（非必填空值边界）：BR002 无分支触发返回 null，realRate 为 null，步骤仍成功
	@Test
	public void testST031T04() {
		ST031Pbc st031Pbc = new ST031Pbc(new StubExternalTaskClient("PD0001", new BigDecimal("1.500")));
		ST031InputBO input = buildInput("PD0001", null, null, null);

		ST031OutputBO output = st031Pbc.execute(input);

		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertNull(output.getRealRate());
	}

	// TC005 三项账户利率均为 0（分支阈值边界）：0 不触发 BR002 分支，规则返回 null，步骤仍成功
	@Test
	public void testST031T05() {
		ST031Pbc st031Pbc = new ST031Pbc(new StubExternalTaskClient("PD0001", new BigDecimal("1.500")));
		ST031InputBO input = buildInput("PD0001", new BigDecimal("0.000"), new BigDecimal("0.000"),
				new BigDecimal("0.000"));

		ST031OutputBO output = st031Pbc.execute(input);

		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertNull(output.getRealRate());
	}

	// TC006 外部调用返回未含 prodIntRate（查询为空边界）：产品利率 null 视同0，BR002 a 分支 0+0.350=0.350，步骤仍成功
	@Test
	public void testST031T06() {
		ST031Pbc st031Pbc = new ST031Pbc(new StubExternalTaskClient("PD0003", null));
		ST031InputBO input = buildInput("PD0003", new BigDecimal("0.350"), null, null);

		ST031OutputBO output = st031Pbc.execute(input);

		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(new BigDecimal("0.350"), output.getRealRate());
	}
}
