package com.dcits.deposit.step;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.AcctNatureNo;
import com.dcits.deposit.enums.ClientType;
import com.dcits.deposit.enums.SpecAcctFlag;
import com.dcits.deposit.enums.TaxResidentFlag;
import com.dcits.deposit.enums.TranBranch;
import com.dcits.deposit.facade.bo.ST055InputBO;
import com.dcits.deposit.facade.bo.ST055OutputBO;
import com.dcits.deposit.facade.components.IFmBranchBcc;
import com.dcits.deposit.facade.components.IFmClientCopyBcc;
import com.dcits.deposit.facade.eo.FmBranchEO;
import com.dcits.deposit.facade.eo.FmClientCopyEO;
import com.dcits.deposit.rule.BR006;

/**
 * ST055 设置账号 单元测试
 *
 * 用例来源：outputs/测试用例.md（ST055-TC001 ~ ST055-TC008）
 *
 * ExternalTaskClient 为具体类：测试运行环境 JDK 26 下 Mockito 5.14.2（Spring Boot 3.4.3 托管）
 * 创建具体类 mock 时 retransform 涉及 java.lang.Object（类文件版本 70）失败（首轮执行记录
 * 未保留，环境限制见 outputs/test-evidence/maven.stderr.log 的 Mockito 自附加告警）。
 * 故不用 @Mock，改为真实 ExternalTaskClient 携带覆写 getForObject 的 RestTemplate 桩；
 * 接口 mock 与 mockStatic 不受影响，维持 Mockito 方式。
 */
@ExtendWith(MockitoExtension.class)
public class ST055PbcTest {

	@Mock
	private IFmBranchBcc fmBranchBcc;

	@Mock
	private IFmClientCopyBcc fmClientCopyBcc;

	private ST055Pbc st055Pbc;

	@BeforeEach
	public void setUp() {
		st055Pbc = new ST055Pbc(newStubbedExternalTaskClient(), fmBranchBcc, fmClientCopyBcc);
	}

	/**
	 * 子步骤4 外部调用桩：按与父类一致的泛型签名覆写 RestTemplate.getForObject，按用例实参
	 * ("AC", 交易机构编码, 产品编号) 精确匹配返回生成账号，其他实参返回 null 使断言可见失败；
	 * 未触达外部调用的用例不受影响
	 */
	private ExternalTaskClient newStubbedExternalTaskClient() {
		RestTemplate restTemplate = new RestTemplate() {
			@Override
			@SuppressWarnings("unchecked")
			public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) {
				if (String.class.equals(responseType) && "AC".equals(uriVariables[0])
						&& "351155".equals(uriVariables[1]) && "P001001".equals(uriVariables[2])) {
					return (T) "6222000133511550001";
				}
				return null;
			}
		};
		return new ExternalTaskClient(restTemplate);
	}

	/** 构造输入：交易机构、产品编号、境内境外标志、账户开立行、客户号按用例固定，其余按用例变化 */
	private ST055InputBO buildInput(SpecAcctFlag specAcctFlag, String residentFlag, String baseAcctNo) {
		ST055InputBO input = new ST055InputBO();
		input.setTranBranch(TranBranch.VALUE_351155);
		input.setProdNo("P001001");
		input.setResidentFlag(residentFlag);
		input.setInlandOffshore("Y");
		input.setAcctBranch(TranBranch.VALUE_351156);
		input.setSpecAcctFlag(specAcctFlag);
		input.setBaseAcctNo(baseAcctNo);
		input.setClientNo("C2026001");
		return input;
	}

	/** 子步骤6 桩：按{开户机构}查询【机构信息】返回指定自贸区机构标志；FM_BRANCH.FTA_FLAG 为 VARCHAR(1)（见 ddl/FM_BRANCH.sql），桩取值 "Y"/"N"（编码部分） */
	private void stubBranch(String ftaFlag) {
		FmBranchEO eo = new FmBranchEO();
		eo.setFtaFlag(ftaFlag);
		Mockito.lenient().when(fmBranchBcc.findByBranch(TranBranch.VALUE_351156)).thenReturn(eo);
	}

	/** 构造子步骤8【客户信息】四要素 */
	private FmClientCopyEO buildClientEO(ClientType clientType, String isIndividual,
			TaxResidentFlag taxResidentFlag, String inlandOffshore) {
		FmClientCopyEO eo = new FmClientCopyEO();
		eo.setClientType(clientType);
		eo.setIsIndividual(isIndividual);
		eo.setTaxResidentFlag(taxResidentFlag);
		eo.setInlandOffshore(inlandOffshore);
		return eo;
	}

	// TC001 定制账户标志=A-全账户定制：子步骤1跳转《赋值定制账号》，[账号]取输入{账号}；residentFlag="N"、境内境外标志="Y"不触发 NRA 前缀；开户机构非自贸区（ftaFlag="N"），子步骤7提前返回原账号，不触达客户信息查询与规则
	@Test
	public void testST055T01() {
		stubBranch("N");
		ST055InputBO input = buildInput(SpecAcctFlag.A, "N", "6222000133511551234");
		ST055OutputBO output = st055Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("6222000133511551234", output.getBaseAcctNo());
	}

	// TC002 定制账户标志=N-非定制账户：子步骤1跳转《设置账号生成规则类型》，按"AC"调用基础公共《生成账号》赋值[账号]；非自贸区机构，子步骤7提前返回生成账号
	@Test
	public void testST055T02() {
		stubBranch("N");
		ST055InputBO input = buildInput(SpecAcctFlag.N, "N", null);
		ST055OutputBO output = st055Pbc.execute(input);
		assertTrue(output.isSucceed());
		assertNull(output.getErrorCode());
		assertNull(output.getErrorMessage());
		assertEquals("6222000133511550001", output.getBaseAcctNo());
	}

	// TC003 非定制账户主流程：生成账号后开户机构为自贸区（ftaFlag="Y"）；客户信息 100-个人、对私客户标志"Y-个人"、税收居民标识1、境内境外标志"Y-境内"，规则返回 FTI（VALUE_3605），[账号]="FTI"+生成账号；residentFlag="Y"且境内境外标志"Y"≠"N-境外"，子步骤5.1 的 a、b 均不命中，不加 NRA 前缀
	@Test
	public void testST055T03() {
		stubBranch("Y");
		FmClientCopyEO clientEO = buildClientEO(ClientType.VALUE_100, "Y-个人", TaxResidentFlag.VALUE_1, "Y-境内");
		Mockito.lenient().when(fmClientCopyBcc.findByPrimaryKey("C2026001")).thenReturn(clientEO);
		try (MockedStatic<BR006> br006 = Mockito.mockStatic(BR006.class)) {
			br006.when(() -> BR006.execute("Y-个人", TaxResidentFlag.VALUE_1, ClientType.VALUE_100, "Y-境内"))
					.thenReturn(AcctNatureNo.VALUE_3605);
			ST055InputBO input = buildInput(SpecAcctFlag.N, "Y", null);
			ST055OutputBO output = st055Pbc.execute(input);
			assertTrue(output.isSucceed());
			assertNull(output.getErrorCode());
			assertNull(output.getErrorMessage());
			assertEquals("FTI6222000133511550001", output.getBaseAcctNo());
		}
	}

	// TC004 定制账户+自贸区机构：客户信息 100-个人、税收居民标识2-非中国税收居民、境内境外标志"N-境外"，规则返回 FTF（VALUE_3606），[账号]="FTF"+输入{账号}
	@Test
	public void testST055T04() {
		stubBranch("Y");
		FmClientCopyEO clientEO = buildClientEO(ClientType.VALUE_100, "Y-个人", TaxResidentFlag.VALUE_2, "N-境外");
		Mockito.lenient().when(fmClientCopyBcc.findByPrimaryKey("C2026001")).thenReturn(clientEO);
		try (MockedStatic<BR006> br006 = Mockito.mockStatic(BR006.class)) {
			br006.when(() -> BR006.execute("Y-个人", TaxResidentFlag.VALUE_2, ClientType.VALUE_100, "N-境外"))
					.thenReturn(AcctNatureNo.VALUE_3606);
			ST055InputBO input = buildInput(SpecAcctFlag.A, "N", "6222000133511551234");
			ST055OutputBO output = st055Pbc.execute(input);
			assertTrue(output.isSucceed());
			assertNull(output.getErrorCode());
			assertNull(output.getErrorMessage());
			assertEquals("FTF6222000133511551234", output.getBaseAcctNo());
		}
	}

	// TC005 定制账户+自贸区机构：客户信息 200-对公、境内境外标志"Y-境内"，规则返回 FTE（VALUE_3603），[账号]="FTE"+输入{账号}；对私客户标志未赋值，静态桩按实参 null 匹配
	@Test
	public void testST055T05() {
		stubBranch("Y");
		FmClientCopyEO clientEO = buildClientEO(ClientType.VALUE_200, null, TaxResidentFlag.VALUE_1, "Y-境内");
		Mockito.lenient().when(fmClientCopyBcc.findByPrimaryKey("C2026001")).thenReturn(clientEO);
		try (MockedStatic<BR006> br006 = Mockito.mockStatic(BR006.class)) {
			br006.when(() -> BR006.execute(null, TaxResidentFlag.VALUE_1, ClientType.VALUE_200, "Y-境内"))
					.thenReturn(AcctNatureNo.VALUE_3603);
			ST055InputBO input = buildInput(SpecAcctFlag.A, "N", "6222000133511551234");
			ST055OutputBO output = st055Pbc.execute(input);
			assertTrue(output.isSucceed());
			assertNull(output.getErrorCode());
			assertNull(output.getErrorMessage());
			assertEquals("FTE6222000133511551234", output.getBaseAcctNo());
		}
	}

	// TC006 定制账户+自贸区机构：客户信息 200-对公、境内境外标志"N-境外"，规则返回 FTN（VALUE_3604），[账号]="FTN"+输入{账号}；对私客户标志未赋值，静态桩按实参 null 匹配
	@Test
	public void testST055T06() {
		stubBranch("Y");
		FmClientCopyEO clientEO = buildClientEO(ClientType.VALUE_200, null, TaxResidentFlag.VALUE_1, "N-境外");
		Mockito.lenient().when(fmClientCopyBcc.findByPrimaryKey("C2026001")).thenReturn(clientEO);
		try (MockedStatic<BR006> br006 = Mockito.mockStatic(BR006.class)) {
			br006.when(() -> BR006.execute(null, TaxResidentFlag.VALUE_1, ClientType.VALUE_200, "N-境外"))
					.thenReturn(AcctNatureNo.VALUE_3604);
			ST055InputBO input = buildInput(SpecAcctFlag.A, "N", "6222000133511551234");
			ST055OutputBO output = st055Pbc.execute(input);
			assertTrue(output.isSucceed());
			assertNull(output.getErrorCode());
			assertNull(output.getErrorMessage());
			assertEquals("FTN6222000133511551234", output.getBaseAcctNo());
		}
	}

	// TC007 定制账户+自贸区机构：客户信息 300-同业、境内境外标志"N-境外"，规则返回 FTU（VALUE_3607），[账号]="FTU"+输入{账号}；对私客户标志未赋值，静态桩按实参 null 匹配
	@Test
	public void testST055T07() {
		stubBranch("Y");
		FmClientCopyEO clientEO = buildClientEO(ClientType.VALUE_300, null, TaxResidentFlag.VALUE_1, "N-境外");
		Mockito.lenient().when(fmClientCopyBcc.findByPrimaryKey("C2026001")).thenReturn(clientEO);
		try (MockedStatic<BR006> br006 = Mockito.mockStatic(BR006.class)) {
			br006.when(() -> BR006.execute(null, TaxResidentFlag.VALUE_1, ClientType.VALUE_300, "N-境外"))
					.thenReturn(AcctNatureNo.VALUE_3607);
			ST055InputBO input = buildInput(SpecAcctFlag.A, "N", "6222000133511551234");
			ST055OutputBO output = st055Pbc.execute(input);
			assertTrue(output.isSucceed());
			assertNull(output.getErrorCode());
			assertNull(output.getErrorMessage());
			assertEquals("FTU6222000133511551234", output.getBaseAcctNo());
		}
	}

	// TC008 定制账户+自贸区机构：客户信息组合（客户类型600）无规则决策条目命中，BR006 返回 null，子步骤10 的 a-e 均不拼接前缀；失败处理节声明无业务失败场景，成功返回当前[账号]
	@Test
	public void testST055T08() {
		stubBranch("Y");
		FmClientCopyEO clientEO = buildClientEO(ClientType.VALUE_600, null, TaxResidentFlag.VALUE_1, "Y-境内");
		Mockito.lenient().when(fmClientCopyBcc.findByPrimaryKey("C2026001")).thenReturn(clientEO);
		try (MockedStatic<BR006> br006 = Mockito.mockStatic(BR006.class)) {
			br006.when(() -> BR006.execute(null, TaxResidentFlag.VALUE_1, ClientType.VALUE_600, "Y-境内"))
					.thenReturn(null);
			ST055InputBO input = buildInput(SpecAcctFlag.A, "N", "6222000133511551234");
			ST055OutputBO output = st055Pbc.execute(input);
			assertTrue(output.isSucceed());
			assertNull(output.getErrorCode());
			assertNull(output.getErrorMessage());
			assertEquals("6222000133511551234", output.getBaseAcctNo());
		}
	}
}
