package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.CategoryType;
import com.dcits.deposit.enums.RbBusAcctPurpose;
import com.dcits.deposit.enums.RestraintType;
import com.dcits.deposit.enums.TermType;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST051InputBO;
import com.dcits.deposit.facade.bo.ST051OutputBO;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.components.IRbCorpNatureDefBcc;
import com.dcits.deposit.facade.eo.FmClientCopyEO;
import com.dcits.deposit.facade.eo.RbCorpNatureDefEO;

/**
 * ST051 增加账户限制 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST051-TC001 ~ ST051-TC005）
 *
 * 跨组件返回Map中检查结果的键名"checkResult"与ST051Pbc读取逻辑保持一致
 * （对方接口字段契约未提供，属ST051.md已接受的需求处理结论）。
 *
 * ExternalTaskClient为具体类，当前测试环境Java 26下Byte Buddy不支持具体类内联mock
 * （outputs/test-results.md：Java 26 (70) is not supported by Byte Buddy，接口mock不受影响），
 * 故以真实签名的手写测试替身替代@Mock，BCC接口依赖仍用Mockito设桩。
 */
@ExtendWith(MockitoExtension.class)
public class ST051PbcTest {

	/** 跨组件返回Map中检查结果的键名，与ST051Pbc常量保持一致 */
	private static final String KEY_CHECK_RESULT = "checkResult";

	@Mock
	private IFmClientCopyBcc fmClientCopyBcc;

	@Mock
	private IRbCorpNatureDefBcc rbCorpNatureDefBcc;

	/** 跨组件客户端测试替身（具体类无法内联mock，见类注释） */
	private final StubExternalTaskClient externalTaskClient = new StubExternalTaskClient();

	private ST051Pbc st051Pbc;

	/** 桩2记录的实际收到的配置查询EO，供子步骤1-3数据流断言 */
	private RbCorpNatureDefEO capturedQueryEo;

	@BeforeEach
	public void setUp() {
		st051Pbc = new ST051Pbc(fmClientCopyBcc, rbCorpNatureDefBcc, externalTaskClient);
	}

	/**
	 * ExternalTaskClient测试替身：按真实签名覆写《维护限制组件》四个步骤方法，
	 * 返回各测试配置的Map；父类构造所需RestTemplate不被触达，仅满足构造参数。
	 */
	private static final class StubExternalTaskClient extends ExternalTaskClient {

		/** 《检查限制类型》返回结果 */
		private Map<String, Object> checkTypeResult = new HashMap<>();
		/** 《检查是否跨法人》返回结果 */
		private Map<String, Object> crossLegalResult = new HashMap<>();
		/** 《检查增加限制起始日期》返回结果 */
		private Map<String, Object> startDateResult = new HashMap<>();
		/** 《登记账户限制信息》返回结果 */
		private Map<String, Object> registerResult = new HashMap<>();

		StubExternalTaskClient() {
			super(new RestTemplate());
		}

		@Override
		public Map<String, Object> executeRestrictionST001(Map<String, Object> bo) {
			return checkTypeResult;
		}

		@Override
		public Map<String, Object> executeRestrictionST002(Map<String, Object> bo) {
			return crossLegalResult;
		}

		@Override
		public Map<String, Object> executeRestrictionST003(Map<String, Object> bo) {
			return startDateResult;
		}

		@Override
		public Map<String, Object> executeRestrictionST004(Map<String, Object> bo) {
			return registerResult;
		}
	}

	private FmClientCopyEO buildClientCopy(String inlandOffshore, CategoryType categoryType) {
		FmClientCopyEO eo = new FmClientCopyEO();
		eo.setInlandOffshore(inlandOffshore);
		eo.setCategoryType(categoryType);
		return eo;
	}

	private RbCorpNatureDefEO buildNatureDef(RbBusAcctPurpose rbBusAcctPurpose, String corporation,
			RestraintType restraintType, String term, TermType termType) {
		RbCorpNatureDefEO eo = new RbCorpNatureDefEO();
		eo.setAcctNatureNo(AcctNatureNo.VALUE_11001);
		eo.setRbBusAcctPurpose(rbBusAcctPurpose);
		eo.setInlandOffshore("境内");
		eo.setCorporation(corporation);
		eo.setRestraintType(restraintType);
		eo.setTerm(term);
		eo.setTermType(termType);
		return eo;
	}

	/** 桩1：按{客户号}查询【客户信息】返回境内境外标识、客户细分类型 */
	private void stubClientCopy(String clientNo, CategoryType categoryType) {
		FmClientCopyEO clientCopy = buildClientCopy("境内", categoryType);
		Mockito.lenient().when(fmClientCopyBcc.findByPrimaryKey(clientNo)).thenReturn(clientCopy);
	}

	/** 桩2：配置查询返回单条【企业账户属性控制配置信息】，并记录收到的查询EO */
	private void stubNatureDefQuery(RbCorpNatureDefEO configured) {
		Mockito.lenient().when(rbCorpNatureDefBcc.findByEo(Mockito.any(RbCorpNatureDefEO.class)))
				.thenAnswer(invocation -> {
					capturedQueryEo = invocation.getArgument(0);
					List<RbCorpNatureDefEO> result = new ArrayList<>();
					result.add(configured);
					return result;
				});
	}

	/** 桩3：《检查限制类型》（ST001）返回检查结果 */
	private void stubCheckResult(Map<String, Object> result) {
		externalTaskClient.checkTypeResult = result;
	}

	/** 桩4：《检查是否跨法人》（ST002）返回检查结果 */
	private void stubCrossLegalResult(Map<String, Object> result) {
		externalTaskClient.crossLegalResult = result;
	}

	/** 桩5：《检查增加限制起始日期》（ST003）返回检查结果 */
	private void stubStartDateResult(Map<String, Object> result) {
		externalTaskClient.startDateResult = result;
	}

	/** 桩6：《登记账户限制信息》（ST004）返回结果 */
	private void stubRegisterResult(Map<String, Object> result) {
		externalTaskClient.registerResult = result;
	}

	private Map<String, Object> passResult() {
		Map<String, Object> result = new HashMap<>();
		result.put(KEY_CHECK_RESULT, "通过");
		return result;
	}

	private Map<String, Object> rejectResult() {
		Map<String, Object> result = new HashMap<>();
		result.put(KEY_CHECK_RESULT, "不通过");
		return result;
	}

	private ST051InputBO buildInput(Date runDate, String baseAcctNo, RbBusAcctPurpose rbBusAcctPurpose,
			String clientNo) {
		ST051InputBO input = new ST051InputBO();
		input.setRunDate(runDate);
		input.setBaseAcctNo(baseAcctNo);
		input.setTranBranch(TranBranch.VALUE_351155);
		input.setRbBusAcctPurpose(rbBusAcctPurpose);
		input.setClientNo(clientNo);
		input.setAcctNatureNo(AcctNatureNo.VALUE_11001);
		return input;
	}

	// TC001 正常路径：客户细分类型为一人公司，企业标志"是"，命中配置（VALUE_23、"3"、M），
	// BR005计算2026-06-15+3个月=2026-09-15，三项检查"通过"并登记，成功返回全部五项输出
	@Test
	public void testST051T01() {
		stubClientCopy("C10020030001", CategoryType.VALUE_204);
		stubNatureDefQuery(buildNatureDef(RbBusAcctPurpose.VALUE_6, "是", RestraintType.VALUE_23, "3", TermType.M));
		stubCheckResult(passResult());
		stubCrossLegalResult(passResult());
		stubStartDateResult(passResult());
		stubRegisterResult(new HashMap<>());

		ST051InputBO input = buildInput(new GregorianCalendar(2026, Calendar.JUNE, 15).getTime(),
				"1100010000000001", RbBusAcctPurpose.VALUE_6, "C10020030001");
		ST051OutputBO output = st051Pbc.execute(input);

		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(new GregorianCalendar(2026, Calendar.SEPTEMBER, 15).getTime(), output.getEndDate());
		assertEquals("1100010000000001", output.getBaseAcctNo());
		assertEquals(RestraintType.VALUE_23, output.getRestraintType());
		assertEquals("3", output.getTerm());
		assertEquals(TermType.M, output.getTermType());
		// 子步骤1-3数据流：配置查询条件含[境内境外标识]与[企业标志]及{账户属性}{账户用途}
		assertEquals("是", capturedQueryEo.getCorporation());
		assertEquals("境内", capturedQueryEo.getInlandOffshore());
		assertEquals(AcctNatureNo.VALUE_11001, capturedQueryEo.getAcctNatureNo());
		assertEquals(RbBusAcctPurpose.VALUE_6, capturedQueryEo.getRbBusAcctPurpose());
	}

	// TC002 正常路径：客户细分类型为个体工商户（非列举四类），企业标志"否"，命中配置（VALUE_7、"6"、M），
	// BR005月末规则计算2026-01-31+6个月=2026-07-31，三项检查"通过"并登记，成功返回全部五项输出
	@Test
	public void testST051T02() {
		stubClientCopy("C10020030002", CategoryType.VALUE_206);
		stubNatureDefQuery(buildNatureDef(RbBusAcctPurpose.VALUE_1, "否", RestraintType.VALUE_7, "6", TermType.M));
		stubCheckResult(passResult());
		stubCrossLegalResult(passResult());
		stubStartDateResult(passResult());
		stubRegisterResult(new HashMap<>());

		ST051InputBO input = buildInput(new GregorianCalendar(2026, Calendar.JANUARY, 31).getTime(),
				"1100010000000002", RbBusAcctPurpose.VALUE_1, "C10020030002");
		ST051OutputBO output = st051Pbc.execute(input);

		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals(new GregorianCalendar(2026, Calendar.JULY, 31).getTime(), output.getEndDate());
		assertEquals("1100010000000002", output.getBaseAcctNo());
		assertEquals(RestraintType.VALUE_7, output.getRestraintType());
		assertEquals("6", output.getTerm());
		assertEquals(TermType.M, output.getTermType());
		// 子步骤1-3数据流：非列举客户细分类型赋值[企业标志]="否"
		assertEquals("否", capturedQueryEo.getCorporation());
		assertEquals("境内", capturedQueryEo.getInlandOffshore());
		assertEquals(AcctNatureNo.VALUE_11001, capturedQueryEo.getAcctNatureNo());
		assertEquals(RbBusAcctPurpose.VALUE_1, capturedQueryEo.getRbBusAcctPurpose());
	}

	// TC003 错误码路径：《检查限制类型》返回"不通过"，子步骤7返回错误码ER0039，子步骤8-12不再执行
	@Test
	public void testST051T03() {
		stubClientCopy("C10020030001", CategoryType.VALUE_204);
		stubNatureDefQuery(buildNatureDef(RbBusAcctPurpose.VALUE_6, "是", RestraintType.VALUE_23, "3", TermType.M));
		stubCheckResult(rejectResult());

		ST051InputBO input = buildInput(new GregorianCalendar(2026, Calendar.JUNE, 15).getTime(),
				"1100010000000001", RbBusAcctPurpose.VALUE_6, "C10020030001");
		ST051OutputBO output = st051Pbc.execute(input);

		assertFalse(output.isSucceed());
		assertEquals("ER0039", output.getErrorCode());
	}

	// TC004 错误码路径：《检查限制类型》"通过"，《检查是否跨法人》返回"不通过"，
	// 子步骤9返回错误码ER0040，子步骤10-12不再执行
	@Test
	public void testST051T04() {
		stubClientCopy("C10020030001", CategoryType.VALUE_204);
		stubNatureDefQuery(buildNatureDef(RbBusAcctPurpose.VALUE_6, "是", RestraintType.VALUE_23, "3", TermType.M));
		stubCheckResult(passResult());
		stubCrossLegalResult(rejectResult());

		ST051InputBO input = buildInput(new GregorianCalendar(2026, Calendar.JUNE, 15).getTime(),
				"1100010000000001", RbBusAcctPurpose.VALUE_6, "C10020030001");
		ST051OutputBO output = st051Pbc.execute(input);

		assertFalse(output.isSucceed());
		assertEquals("ER0040", output.getErrorCode());
	}

	// TC005 错误码路径：《检查限制类型》《检查是否跨法人》均"通过"，《检查增加限制起始日期》返回"不通过"，
	// 子步骤11返回错误码ER0041，子步骤12不再执行
	@Test
	public void testST051T05() {
		stubClientCopy("C10020030001", CategoryType.VALUE_204);
		stubNatureDefQuery(buildNatureDef(RbBusAcctPurpose.VALUE_6, "是", RestraintType.VALUE_23, "3", TermType.M));
		stubCheckResult(passResult());
		stubCrossLegalResult(passResult());
		stubStartDateResult(rejectResult());

		ST051InputBO input = buildInput(new GregorianCalendar(2026, Calendar.JUNE, 15).getTime(),
				"1100010000000001", RbBusAcctPurpose.VALUE_6, "C10020030001");
		ST051OutputBO output = st051Pbc.execute(input);

		assertFalse(output.isSucceed());
		assertEquals("ER0041", output.getErrorCode());
	}
}
