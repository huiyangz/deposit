package com.dcits.deposit.step;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dcits.client.ExternalTaskClient;
import com.dcits.deposit.enums.AllDraInd;
import com.dcits.deposit.enums.Ccy;
import com.dcits.deposit.facade.bo.ST037InputBO;
import com.dcits.deposit.facade.bo.ST037OutputBO;
import com.dcits.deposit.facade.components.IFmBranchCcyBcc;
import com.dcits.deposit.facade.eo.FmBranchCcyEO;

/**
 * ST037 检查通兑标志
 *
 * 1.获取产品的通兑标志：根据{产品编号}、{参数KEY值}访问业务组件《产品管理》的
 * 业务功能《查询产品信息》，获取 $通兑标志$。
 * 2.检查通兑标志是否在产品配置的范围内：a.账户{通兑标志}非空时，产品[通兑标志]为
 * “N-不允许通兑”且账户{通兑标志}不为“N-不允许通兑”则返回错误码 ER0018，否则继续执行；
 * b.账户{通兑标志}为空时继续执行。
 * 3.检查通兑机构号：{通兑标志}为“D-指定机构通兑”且{通兑机构编号}为空则返回错误码 ER0019。
 * 4.获取机构币种：根据{通兑机构编号}按归属机构号查询【机构币种信息】获取[机构币种列表]。
 * 5.检查账户币种和机构币种匹配性：仅当{通兑标志}为“分行间通兑”或“指定机构间通兑”时
 * 检查{币种}是否在[机构币种列表]范围内，不在则返回错误码 ER0020；其余情况检查通过。
 */
@Service
public class ST037Pbc implements IST037 {

	/** 产品[通兑标志]“N-不允许通兑”按编码部分比较的编码 */
	private static final String NOT_ALLOWED_ALL_DRA_CODE = "N";

	/** {通兑标志}“D-指定机构通兑”按编码部分比较的编码 */
	private static final String DESIGNATED_DRA_CODE = "D";

	/**
	 * 子步骤5 币种匹配检查范围内的{通兑标志}取值（“分行间通兑”或“指定机构间通兑”
	 * 对应的 AllDraInd 常量）。这两种取值与 AllDraInd 已声明常量（N001~N004）的
	 * 对应关系未提供（SPEC 已接受的需求处理结论第3条），当前为空集，已声明常量及
	 * 空值均走“其余情况”；需求方对齐取值后在集合中登记对应常量。
	 */
	private static final Set<AllDraInd> CCY_CHECK_SCOPE_ALL_DRA = Collections.emptySet();

	private final ExternalTaskClient externalTaskClient;

	private final IFmBranchCcyBcc fmBranchCcyBcc;

	public ST037Pbc(ExternalTaskClient externalTaskClient, IFmBranchCcyBcc fmBranchCcyBcc) {
		this.externalTaskClient = externalTaskClient;
		this.fmBranchCcyBcc = fmBranchCcyBcc;
	}

	@Override
	public ST037OutputBO execute(ST037InputBO input) {
		ST037OutputBO output = new ST037OutputBO();

		// 子步骤1 获取产品的通兑标志：根据{产品编号}、{参数KEY值}调用产品管理《查询产品信息》
		String productAllDraInd = externalTaskClient.queryProductInfo(input.getProdNo(), input.getAttrKey());

		// 子步骤2a 账户{通兑标志}非空：产品[通兑标志]为“N-不允许通兑”（编码“N”）且账户
		// {通兑标志}不为“N-不允许通兑”时返回 ER0018，否则继续执行
		if (input.getAllDraInd() != null) {
			boolean accountNotAllowed = NOT_ALLOWED_ALL_DRA_CODE.equals(input.getAllDraInd().getValue());
			if (NOT_ALLOWED_ALL_DRA_CODE.equals(productAllDraInd) && !accountNotAllowed) {
				output.setErrorCode("ER0018");
				output.setErrorMessage("ER0018::账户通兑标志不在产品配置的通兑标志范围内");
				return output;
			}
		}
		// 子步骤2b 账户{通兑标志}为空：继续执行

		// 子步骤3 检查通兑机构号：{通兑标志}为“D-指定机构通兑”（编码“D”）且
		// {通兑机构编号}为空时返回 ER0019，否则继续执行
		if (input.getAllDraInd() != null
				&& DESIGNATED_DRA_CODE.equals(input.getAllDraInd().getValue())
				&& input.getAllDraIntBranch() == null) {
			output.setErrorCode("ER0019");
			output.setErrorMessage("ER0019::指定机构通兑时通兑机构编号为空");
			return output;
		}

		// 子步骤4 获取机构币种：根据{通兑机构编号}按归属机构号查询【机构币种信息】获取[机构币种列表]
		FmBranchCcyEO queryEo = new FmBranchCcyEO();
		queryEo.setBranch(input.getAllDraIntBranch());
		List<FmBranchCcyEO> branchCcyList = fmBranchCcyBcc.findByEo(queryEo);

		// 子步骤5 检查账户币种和机构币种匹配性：仅当{通兑标志}为“分行间通兑”或
		// “指定机构间通兑”时检查{币种}是否在[机构币种列表]范围内，不在返回 ER0020
		if (CCY_CHECK_SCOPE_ALL_DRA.contains(input.getAllDraInd())
				&& findBranchCcy(branchCcyList, input.getCcy()) == null) {
			output.setErrorCode("ER0020");
			output.setErrorMessage("ER0020::账户币种不在机构币种列表范围内");
			return output;
		}
		// 其余情况检查结果为“通过”
		output.setSucceed(true);
		return output;
	}

	/**
	 * 子步骤5 在[机构币种列表]中查找{币种}对应的机构币种记录，未命中返回 null
	 */
	private FmBranchCcyEO findBranchCcy(List<FmBranchCcyEO> branchCcyList, Ccy ccy) {
		for (FmBranchCcyEO eo : branchCcyList) {
			if (eo.getCcy() == ccy) {
				return eo;
			}
		}
		return null;
	}
}
